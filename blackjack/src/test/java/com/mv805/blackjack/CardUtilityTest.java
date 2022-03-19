package com.mv805.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

public class CardUtilityTest {

    @Test
    void testShuffleThrowsException() {
        Deck deck = new Deck();
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> CardUtility.Shuffle(0, deck.getDeck()));
        assertEquals("Can't shuffle zero times", exception.getMessage());
    }

    @Test
    void testShuffleIsShuffled() {
        Deck deck = new Deck();
        List checkList = new ArrayList<>(deck.getDeck());
        CardUtility.Shuffle(1, checkList);
        assertTrue(!deck.getDeck().equals(checkList));
    }

    @Test
    void testCheckInputIsTableFalseIfNotInt() {
        String input = "String";
        assertFalse(CardUtility.CheckInputIsTable(input));
    }

    @Test
    void testCheckInputIsTableTrueIfTableExists() {
        String input;

        for (int i = 0; i < HallTable.values().length; i++) {
            input = String.valueOf(HallTable.values()[i].getSelectionString());
            assertTrue(CardUtility.CheckInputIsTable(input));
        }

    }
}
