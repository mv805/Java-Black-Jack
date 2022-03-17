package com.mv805.blackjack;

public class BlackJackTable {

    private int minBet;
    private int maxBet;
    private int numberOfDecks;
    private boolean soft17hit;

    public BlackJackTable(int minBet, int maxBet, int numberOfDecks, boolean soft17hit) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.numberOfDecks = numberOfDecks;
        this.soft17hit = soft17hit;
    }

}
