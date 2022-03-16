package com.mv805.blackjack;

import java.util.Collections;
import java.util.List;

public class CardUtility {

    public static void shuffle(int numberOfTimes, List itemToShuffle) {
        if (numberOfTimes <= 0) {
            throw new IllegalArgumentException("Can't shuffle zero times");
        }

        for (int i = 0; i < numberOfTimes; i++) {
            Collections.shuffle(itemToShuffle);
        }

    }

}
