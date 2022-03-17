package com.mv805.blackjack;

public abstract class Card {

    private CardType cardType;

    public Card(CardType cardType) {
        this.cardType = cardType;
    }

    public CardType getType() {
        return cardType;
    }

    public abstract String getInfoString();
}
