package com.mv805.blackjack;

import java.util.Arrays;
import java.util.List;

public enum Location {

    LOBBY("L", "Lobby", Arrays.asList("B", "A", "E")),
    ATM("A", "ATM", Arrays.asList("L")),
    HALL("B", "Blackjack Hall", Arrays.asList("L", "T")),
    TABLES("T", "Blackjack Tables"),
    EXIT("E", "Exit Casino (Quit Game)");

    private final String displayName;
    private final String selectionString;
    private List<String> menuList;

    private Location(String selectionString, String displayName, List<String> menuList) {
        this.selectionString = selectionString;
        this.displayName = displayName;
        this.menuList = menuList;
    }

    private Location(String selectionString, String displayName) {
        this.selectionString = selectionString;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSelectionString() {
        return selectionString;
    }

    public List<String> getMenuList() {
        return menuList;
    }

    // returns a location based on the given selection string. i.e. "A" returns ATM
    public static Location getLocation(String index) {

        for (Location location : Location.values()) {
            if (location.getSelectionString().equals(index)) {
                return location;
            }
        }

        return null;
    }

}
