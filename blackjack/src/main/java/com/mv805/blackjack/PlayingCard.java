package com.mv805.blackjack;

public class PlayingCard extends Card {

    private CardRank rank;
    private CardSuit suit;

    public PlayingCard(CardRank rank, CardSuit suit) {

        super(CardType.PLAYING_CARD);
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        return rank.getValue();
    }

    public String getInfoString() {
        return rank.getRank() + " of " + suit.getSuit();
    }
}
