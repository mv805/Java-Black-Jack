package com.mv805.blackjack;

import java.util.List;

public class BlackJackGame {

    //TABLE_1("1", "Table 1", new BlackJackTable(5, 500, 3, false)),
    private int playerBet = 0;
    private List playersHand;
    private List dealersHand;
    private HallTable gameTable;
    private Shoe shoe;
    private boolean gameOver = false;
    private boolean cutCardFound = false;
    private final int SHUFFLE_CYCLES = 20;
    private BlackJackGamePhase gamePhase = BlackJackGamePhase.SHUFFLE;

    public BlackJackGame(HallTable table) {
        this.gameTable = table;
        //this.minBet = table.getTable().getMinBet();
        //this.maxBet = table.getTable().getMaxBet();
        //this.numberOfDecks = table.getTable().getNumberOfDecks();
        //this.soft17hit = table.getTable().ishitOnSoft17();
        shoe = new Shoe(gameTable.getTable().getNumberOfDecks());

        MainGameLogic(table);
    }

    private void MainGameLogic(HallTable table){
        while (!gameOver) {
            switch (gamePhase) {
                case SHUFFLE:
                    ShufflePhase();
                    break;
                case BETTING:
                    break;
                default:
                    break;
            }
        }
    }

    private void ShufflePhase(){
        if (cutCardFound){
            shoe = new Shoe(gameTable.getTable().getNumberOfDecks());
            System.out.println("Cut card issued last round. New Shoe is being prepared...");
        } 
    }

}
