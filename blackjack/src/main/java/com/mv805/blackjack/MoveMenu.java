package com.mv805.blackjack;

import java.util.Scanner;

public class MoveMenu {

    public static Scanner scanner = new Scanner(System.in);

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

    public static String getMenuInput() {
        System.out.print("Where would you like to go? ");
        String choice = scanner.next().toUpperCase();
        return choice;
    }

    public static void processMenuInput(Player player, String menuChoice) {
        if (menuChoice.equals(Location.EXIT.getSelectionString())) {
            player.setPlayerState(PlayerState.EXITING);
        } else {
            player.setPlayerLocation(Location.getLocation(menuChoice));
            player.setPlayerState(PlayerState.MOVING);
        }
    }

}
