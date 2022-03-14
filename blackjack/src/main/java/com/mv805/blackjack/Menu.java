package com.mv805.blackjack;

import java.util.Scanner;

public class Menu {

    public static Scanner scanner = new Scanner(System.in);

    public static void DisplayMenu(String[] menuList) {

        for (String menuOption : menuList) {
            System.out.printf("%s: %s%n", Location.getLocation(menuOption).getSelectionString(),
                    Location.getLocation(menuOption).getDisplayName());
        }
        System.out.println();
    }

    public static String getMenuInput() {
        System.out.print("Enter Selection:");
        String choice = scanner.next();
        System.out.println();
        return choice;
    }

    public static void processInput(Player player, String menuChoice) {
        if (menuChoice.equals(Location.EXIT.getSelectionString())) {
            player.setPlayerState(PlayerState.EXITING);
        } else {
            player.setPlayerLocation(Location.getLocation(menuChoice));
        }
    }

}
