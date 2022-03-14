package com.mv805.blackjack;

public enum CardSuit {

    DIAMOND("Diamonds"),
    SPADE("Spades"),
    HEART("Hearts"),
    CLUB("Clubs");

    private final String displayName;

    private CardSuit(String displayName) {
        this.displayName = displayName;
    }

    public String getSuit() {
        return displayName;
    }

}
