package com.mv805.blackjack;

import java.util.Scanner;

public class MoveMenu {

    public static Scanner scanner = new Scanner(System.in);
    private static String invalidMessage = "***Invalid Input, Try Again***";

    public static void DisplayMenu(Player player) {

        try {// try catch for any invalid inputs that arent validated
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
        } catch (Exception e) {
            System.out.println(invalidMessage);
        }

    }

    public static String getMenuInput(Player player) {

        if (player.getPlayerState().equals(PlayerState.MOVING)) {
            System.out.print("Where would you like to go? ");
        } else if (player.getPlayerState().equals(PlayerState.PLAYING)) {
            System.out.print("Make Selection ");
        }

        String choice = scanner.nextLine().toUpperCase().trim().replaceAll("\\s", "");

        if (validateInputCorrect(choice)) {
            return choice;
        } else {
            return null;
        }
    }

    public static void processMenuInput(Player player, String menuChoice) {

        if (menuChoice == null) {
            System.out.println(invalidMessage);
            System.out.println();

        } else if (menuChoice.equals(Location.EXIT.getSelectionString())) {
            player.setPlayerState(PlayerState.EXITING);

        } else {
            player.setPlayerLocation(Location.getLocation(menuChoice));
            player.setPlayerState(PlayerState.MOVING);
        }
    }

    private static boolean validateInputCorrect(String input) {

        if (input.isEmpty() || input == null) {
            return false;
        } else if (input.length() > 1) {
            return false;
        }
        return true;
    }

}
