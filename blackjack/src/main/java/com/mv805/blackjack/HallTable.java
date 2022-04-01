package com.mv805.blackjack;

public enum HallTable {

    TABLE_1("1", "Table 1", new BlackJackTable(5, 500, 3, false)),
    TABLE_2("2", "Table 2", new BlackJackTable(25, 2500, 3, false)),
    TABLE_3("3", "Table 3", new BlackJackTable(10, 1000, 3, false)),
    TABLE_4("4", "Table 4", new BlackJackTable(50, 5000, 6, true)),
    TABLE_5("5", "Table 5", new BlackJackTable(100, 10000, 6, false));

    private BlackJackTable table;
    private final String displayName;
    private final String selectionString;

    private HallTable(String selectionString, String displayName, BlackJackTable table) {
        this.displayName = displayName;
        this.selectionString = selectionString;
        this.table = table;
    }

    public BlackJackTable getTable() {
        return table;
    }

    public void setTable(BlackJackTable table) {
        this.table = table;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSelectionString() {
        return selectionString;
    }

    // returns a table based on the given selection string. i.e. "1" returns TABLE_1
    public static HallTable getTableFromStringChoice(String index) {

        for (HallTable table : HallTable.values()) {
            if (table.getSelectionString().equals(index)) {
                return table;
            }
        }

        return null;
    }

}
