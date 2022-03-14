package com.mv805.blackjack;

public enum Location {

    LOBBY("L", "Lobby", new String[] { "H", "A", "E" }),
    ATM("A", "ATM", new String[] { "L" }),
    HALL("H", "Blackjack Hall", new String[] { "1", "2", "3", "L" }),
    EXIT("E", "Exit Casino (Quit Game)", new String[] { "1", "2", "3", "L" }),
    TABLE_ONE("1", "Table One", new String[0]),
    TABLE_TWO("2", "Table Two", new String[0]),
    TABLE_THREE("3", "Table Three", new String[0]);

    private final String displayName;
    private final String selectionString;
    private final String[] menuList;

    private Location(String selectionString, String displayName, String[] menuList) {
        this.selectionString = selectionString;
        this.displayName = displayName;
        this.menuList = menuList;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSelectionString() {
        return selectionString;
    }

    public String[] getMenuList() {
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
