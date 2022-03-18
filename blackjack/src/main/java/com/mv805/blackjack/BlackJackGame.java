package com.mv805.blackjack;

import java.util.List;

public class BlackJackGame {

    private int playerBet = 0;
    private BlackJackTable table;
    private List playersHand;
    private List dealersHand;

    public BlackJackGame(BlackJackTable table) {
        this.table = table;
    }

}
