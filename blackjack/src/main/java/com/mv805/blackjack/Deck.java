package com.mv805.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<PlayingCard> deck = new ArrayList<>();

    public Deck() {
        fillDeck();
    }

    private void fillDeck() {

        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                deck.add(new PlayingCard(rank, suit));
            }
        }
    }

    public void shuffle(int numberOfTimes) {

        if (numberOfTimes > 0) {
            for (int i = 0; i < numberOfTimes; i++) {
                Collections.shuffle(deck);
            }
        } else {
            Collections.shuffle(deck);
        }

    }

    public void printDeck() {
        for (PlayingCard playingCard : deck) {
            System.out.println(playingCard.getInfoString());
        }
    }
}
