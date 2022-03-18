package com.mv805.blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class MoveMenuTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(0);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @ParameterizedTest
    @EnumSource(value = Location.class, names = { "EXIT" })
    void testProcessMenuInput_ShouldExit(Location location) {
        MoveMenu.processMenuInput(player, location.getSelectionString());
        assertEquals(PlayerState.EXITING, player.getPlayerState());
    }

    @ParameterizedTest
    @EnumSource(value = Location.class, names = { "LOBBY", "ATM", "HALL" })
    void testProcessMenuInput_PlayerShouldBeMoveState(Location location) {
        MoveMenu.processMenuInput(player, location.getSelectionString());
        assertEquals(PlayerState.MOVING, player.getPlayerState());
    }

    @ParameterizedTest
    @EnumSource(value = Location.class, names = { "LOBBY", "ATM", "HALL" })
    void testProcessMenuInput_PlayerShouldRelocate(Location location) {
        MoveMenu.processMenuInput(player, location.getSelectionString());
        assertEquals(location, player.getPlayerLocation());
    }

    @Test
    void testDisplayMenu_ShouldDisplayOptionAndName() {

        player.setPlayerLocation(Location.LOBBY);
        String displayAllMenu = "B: Blackjack Hall\r\n" +
                "A: ATM\r\n" +
                "E: Exit Casino (Quit Game)";
        MoveMenu.DisplayMenu(player);
        assertEquals(displayAllMenu, outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        displayAllMenu = "L: Lobby";
        player.setPlayerLocation(Location.ATM);
        MoveMenu.DisplayMenu(player);
        assertEquals(displayAllMenu, outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        displayAllMenu = "1: Table 1-- Min Bet: 5 / Max Bet: 500 / Number of Decks used: 3 / Dealer stands on 17\r\n" +
                "2: Table 2-- Min Bet: 25 / Max Bet: 2500 / Number of Decks used: 3 / Dealer stands on 17\r\n" +
                "3: Table 3-- Min Bet: 10 / Max Bet: 1000 / Number of Decks used: 3 / Dealer stands on 17\r\n" +
                "4: Table 4-- Min Bet: 50 / Max Bet: 5000 / Number of Decks used: 6 / Dealer hits on soft 17\r\n" +
                "5: Table 5-- Min Bet: 100 / Max Bet: 10000 / Number of Decks used: 6 / Dealer stands on 17\r\n" +
                "B: Blackjack Hall";
        player.setPlayerLocation(Location.TABLES);
        MoveMenu.DisplayMenu(player);
        assertEquals(displayAllMenu, outputStreamCaptor.toString().trim());
    }

}
