package com.mv805.blackjack;

public enum BlackJackGamePhase {

    SHUFFLE,
    BETTING,
    DEALING,
    WIN_CHECK,
    PLAYER_ACTION,
    BUST_CHECK,
    TURN_CHECK,
    PLAYER_DONE_CHECK,
    REVEAL,
    DEALER_ACTION,
    SETTLE_PAYOUT,
    DETERMINE_NEW_GAME
}
