package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by kaurn19 on 10/12/2016.
 */
public class PigGameState extends GameState{
    private int player1Score;
    private int player2Score;
    private int playerTurn;
    private int runningTotal;
    private int dieValue;

    public PigGameState(){
        player1Score = 0;
        player2Score = 0;
        playerTurn = 0;
        runningTotal = 0;
        dieValue = 0;
    }

    public PigGameState(PigGameState state) {
        player1Score = state.player1Score;
        player2Score = state.player2Score;
        playerTurn = state.playerTurn;
        runningTotal = state.runningTotal;
        dieValue = state.dieValue;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public int getDieValue() {
        return dieValue;
    }

    public void setPlayer1Score(int player1Score){
        this.player1Score = player1Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void setDieValue(int dieValue) {
        this.dieValue = dieValue;
    }
}
