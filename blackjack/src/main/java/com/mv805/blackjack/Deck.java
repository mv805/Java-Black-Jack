package com.mv805.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<PlayingCard> deck = new ArrayList<>();

    public Deck() {
        fillDeck();
        CardUtility.shuffle(10, deck);
    }

    private void fillDeck() {

        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                deck.add(new PlayingCard(rank, suit));
            }
        }
    }

    public void printDeck() {
        for (PlayingCard playingCard : deck) {
            System.out.println(playingCard.getInfoString());
        }
    }

    public List<PlayingCard> getDeck() {
        return deck;
    }
}
