package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    /**
     * This ctor creates a new game state
     */
    PigGameState state;
    public PigLocalGame() {
        state = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(playerIdx == state.getPlayerTurn()) {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if(this.players[state.getPlayerTurn()] == action.getPlayer()) {
            if (action instanceof PigHoldAction) {
                if (state.getPlayerTurn() == 0) {
                    int score = state.getPlayer1Score();
                    score += state.getRunningTotal();
                    state.setPlayer1Score(score);
                    state.setPlayerTurn(1);
                } else {
                    int score = state.getPlayer2Score();
                    score += state.getRunningTotal();
                    state.setPlayer2Score(score);
                    state.setPlayerTurn(0);
                }
                state.setRunningTotal(0);
                return true;
            }
            if (action instanceof PigRollAction) {
                Random r = new Random();
                int val = r.nextInt(6) + 1;
                state.setDieValue(val);
                if (state.getDieValue() != 1) {
                    int score = state.getRunningTotal();
                    score += state.getDieValue();
                    state.setRunningTotal(score);
                } else {
                    state.setRunningTotal(0);
                    state.setPlayerTurn(1 - state.getPlayerTurn());
                }
                return true;
            }
        }
        return false;
    }//makeMove


    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new PigGameState(state));
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(state.getPlayer1Score() >=50) {
            return "Player 1 Wins with " + state.getPlayer1Score() + " points!";
        }
        if(state.getPlayer2Score() >=50) {
            return "Player 2 Wins with " + state.getPlayer2Score() + " points!";
        }
        return null;
    }

}// class PigLocalGame
