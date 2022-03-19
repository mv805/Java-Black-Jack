package com.mv805.blackjack;

import java.util.Collections;
import java.util.List;

public class CardUtility {

    public static void Shuffle(int numberOfTimes, List itemToShuffle) {
        if (numberOfTimes <= 0) {
            throw new IllegalArgumentException("Can't shuffle zero times");
        }

        for (int i = 0; i < numberOfTimes; i++) {
            Collections.shuffle(itemToShuffle);
        }

    }

    public static boolean CheckInputIsTable(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }

        for (HallTable table : HallTable.values()) {
            if (input.equals(table.getSelectionString())) {
                return true;
            }
        }

        return false;
    }

}
