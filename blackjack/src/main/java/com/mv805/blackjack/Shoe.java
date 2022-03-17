package com.mv805.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shoe {

    private List<Card> dealingShoe = new ArrayList<Card>();
    private Random random = new Random();
    private int lowerInsertionBound;
    private final float dealerInsertEstimate = .66f;
    private int cutCardInsertioninterval;
    private CutCard cutCard = new CutCard();

    public Shoe(int numberOfDecks) {
        this.fillShoe(numberOfDecks);
        CardUtility.shuffle(10, dealingShoe);
        setCutCardInsertionBounds();
        this.addCutCard();
    }

    private void fillShoe(int numberOfDecks) {

        for (int i = 0; i < numberOfDecks; i++) {
            Deck deck = new Deck();
            for (PlayingCard playingCard : deck.getDeck()) {
                dealingShoe.add(playingCard);
            }
        }
    }

    private void addCutCard() {
        dealingShoe.add(random.nextInt(cutCardInsertioninterval) + lowerInsertionBound, cutCard);
    }

    private void setCutCardInsertionBounds() {
        lowerInsertionBound = (int) (dealerInsertEstimate * dealingShoe.size());
        cutCardInsertioninterval = dealingShoe.size() - lowerInsertionBound + 1;
    }

    public void shoeStatistics() {
        System.out.printf("Size of shoe is: %d%n", dealingShoe.size());
        System.out.printf("Lower insertion bound: %d%n", lowerInsertionBound);
        System.out.printf("Cut Card is at index: %d%n", dealingShoe.indexOf(cutCard));
    }

    private Card dealCard() {
        return dealingShoe.remove(0);
    }

}
