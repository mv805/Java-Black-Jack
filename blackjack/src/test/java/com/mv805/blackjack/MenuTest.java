package com.mv805.blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class MenuTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(0);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @BeforeEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @ParameterizedTest
    @EnumSource(value = Location.class, names = { "EXIT" })
    void testProcessMenuInput_ShouldExit(Location location) {
        Menu.processMenuInput(player, location.getSelectionString());
        assertEquals(PlayerState.EXITING, player.getPlayerState());
    }

    @ParameterizedTest
    @EnumSource(value = Location.class, names = { "LOBBY", "ATM", "HALL" })
    void testProcessMenuInput_PlayerShouldMove(Location location) {
        Menu.processMenuInput(player, location.getSelectionString());
        assertEquals(PlayerState.MOVING, player.getPlayerState());
    }

    @ParameterizedTest
    @EnumSource(value = Location.class, names = { "LOBBY", "ATM", "HALL" })
    void testProcessMenuInput_PlayerShouldRelocate(Location location) {
        Menu.processMenuInput(player, location.getSelectionString());
        assertEquals(location, player.getPlayerLocation());
    }

    @Test
    void testDisplayMenu_ShouldDisplayOptionAndName() {

        String displayAllMenu = "L: Lobby\r\n" +
                "A: ATM\r\n" +
                "H: Blackjack Hall";

        String[] stringArray = { "L", "A", "H" };
        Menu.DisplayMenu(stringArray);
        assertEquals(displayAllMenu, outputStreamCaptor.toString().trim());
    }

}
