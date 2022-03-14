package com.mv805.blackjack;

public enum CardRank {

    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    KING("King", 10),
    QUEEN("Queen", 10),
    JACK("Jack", 10),
    ACE("Ace", 11);

    private final String displayRank;
    private final int cardValue;

    private CardRank(String displayRank, int cardValue) {
        this.displayRank = displayRank;
        this.cardValue = cardValue;
    }

    public String getRank() {
        return displayRank;
    }

    public int getValue() {
        return cardValue;
    }

}
