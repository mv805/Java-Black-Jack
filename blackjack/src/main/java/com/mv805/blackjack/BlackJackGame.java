package com.mv805.blackjack;

import java.util.List;

public class BlackJackGame {

    private int playerBet = 0;
    private HallTable table;
    private List playersHand;
    private List dealersHand;

    public BlackJackGame(HallTable table) {
        this.table = table;
        mainGameLogic(table);
    }

    public static void mainGameLogic(HallTable table){
        System.out.println("in the game with table " + table.getDisplayName());
    }

}
