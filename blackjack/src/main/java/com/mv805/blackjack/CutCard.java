package com.mv805.blackjack;

public class CutCard extends Card {
    public CutCard() {
        super(CardType.CUT_CARD);
    }

    @Override
    public String getInfoString() {
        return "Cut Card";
    }
}
