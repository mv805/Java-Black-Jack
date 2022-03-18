package com.mv805.blackjack;

public class BlackJackTable {

    private int minBet;
    private int maxBet;
    private int numberOfDecks;
    private boolean hitOnSoft17;

    public BlackJackTable(int minBet, int maxBet, int numberOfDecks, boolean soft17hit) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.numberOfDecks = numberOfDecks;
        this.hitOnSoft17 = soft17hit;
    }

    public int getMinBet() {
        return minBet;
    }

    public int getMaxBet() {
        return maxBet;
    }

    public int getNumberOfDecks() {
        return numberOfDecks;
    }

    public boolean ishitOnSoft17() {
        return hitOnSoft17;
    }

}
