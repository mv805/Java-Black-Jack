package com.mv805.blackjack;

import java.util.Scanner;

//test
public class MoveMenu {// test branch addition

    public static Scanner scanner = new Scanner(System.in);
    private static String invalidMessage = "***Invalid Input, Try Again***";

    public static void DisplayMenu(Player player) {

        if (player.getPlayerLocation().equals(Location.TABLES)) {
            for (HallTable table : HallTable.values()) {
                System.out.printf("%s: %s-- Min Bet: %d / Max Bet: %d / " +
                        "Number of Decks used: %d / ",
                        table.getSelectionString(),
                        table.getDisplayName(),
                        table.getTable().getMinBet(),
                        table.getTable().getMaxBet(),
                        table.getTable().getNumberOfDecks());

                if (table.getTable().ishitOnSoft17()) {
                    System.out.printf("Dealer hits on soft 17%n");
                } else {
                    System.out.printf("Dealer stands on 17%n");
                }
            }
            System.out.printf("%s: %s%n", Location.HALL.getSelectionString(), Location.HALL.getDisplayName());

        } else {
            for (String menuOption : player.getPlayerLocation().getMenuList()) {
                System.out.printf("%s: %s%n", Location.getLocation(menuOption).getSelectionString(),
                        Location.getLocation(menuOption).getDisplayName());
            }
        }
    }

    public static String getMenuInput(Player player) {

        System.out.print("Where would you like to go? ");
        String menuChoice = scanner.nextLine().toUpperCase().trim().replaceAll("\\s", "");
        return menuChoice;

    }

    public static void processMenuInput(Player player, String menuChoice) {
        if (!validateInputCorrect(menuChoice)) {
            System.out.println(invalidMessage);
        } else {
            MoveMenu.movePlayer(player, menuChoice);
        }
    }

    private static boolean validateInputCorrect(String input) {
        // input should come in trimmed and uppercase and no white spaces
        boolean locationsContainInput = false;

        if (input.isEmpty() || input == null) {
            return false;
        }
        if (input.length() > 1) {
            return false;
        }

        for (Location location : Location.values()) {
            if (location.getSelectionString().equals(input)) {
                locationsContainInput = true;
                break;
            }
        }
        for (HallTable table : HallTable.values()) {
            if (table.getSelectionString().equals(input)) {
                locationsContainInput = true;
                break;
            }
        }

        if (!locationsContainInput) {
            return false;
        }

        return true;
    }

    public static void movePlayer(Player player, String menuChoice) {

        if (menuChoice.equals(Location.EXIT.getSelectionString())) {
            player.setPlayerState(PlayerState.EXITING);

        } else if (CardUtility.CheckInputIsTable(menuChoice)) {
            System.out.println("Playin a game...");//remove once game logic complete
            player.setPlayerLocation(Location.LOBBY);
        } else {
            player.setPlayerLocation(Location.getLocation(menuChoice));
            player.setPlayerState(PlayerState.MOVING);
        }
    }

}
