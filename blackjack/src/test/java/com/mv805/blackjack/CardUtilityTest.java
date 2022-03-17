package com.mv805.blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CardUtilityTest {

    @Test
    void testShuffle() {
        Deck deck = new Deck();
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> CardUtility.shuffle(0, deck.getDeck()));
        assertEquals("Can't shuffle zero times", exception.getMessage());
    }
}
