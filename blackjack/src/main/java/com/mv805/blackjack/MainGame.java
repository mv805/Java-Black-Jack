package com.mv805.blackjack;

public class MainGame {

    private Player player = new Player(1000);
    private boolean gameOver = false;

    public void RunGame() {

        while (!gameOver) {

            switch (player.getPlayerState()) {
                case INTRO:
                    System.out.println("*****************************");
                    System.out.println("Welcome to Black Jack Casino!");
                    System.out.println("*****************************");
                    player.setPlayerState(PlayerState.MOVING);
                    break;
                case MOVING:
                    MoveMenu.DisplayMenu(player);
                    String menuChoice = MoveMenu.getMenuInput(player);
                    MoveMenu.processMenuInput(player, menuChoice);
                    break;
                case PLAYING:
                    break;
                case EXITING:
                    System.out.println("Goodbye!");
                    gameOver = true;
                    break;
                default:
                    break;

            }
        }
    }
}
