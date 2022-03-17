package com.mv805.blackjack;

import java.util.List;
import java.util.Scanner;

public class MoveMenu {

    public static Scanner scanner = new Scanner(System.in);

    public static void DisplayMenu(List<String> menuList) {

        for (String menuOption : menuList) {
            System.out.printf("%s: %s%n", Location.getLocation(menuOption).getSelectionString(),
                    Location.getLocation(menuOption).getDisplayName());
        }

    }

    public static String getMenuInput() {
        System.out.print("Enter Selection:");
        String choice = scanner.next();
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
