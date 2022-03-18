package com.mv805.blackjack;

public class MainGame {

    private Player player = new Player(1000);
    private boolean gameOver = false;

    public void RunGame() {

        while (!gameOver) {

            switch (player.getPlayerState()) {
                case INTRO:
                    System.out.println("Welcome to Black Jack Casino!");
                    player.setPlayerState(PlayerState.MOVING);
                    break;
                case MOVING:
                    MoveMenu.DisplayMenu(player);
                    System.out.println();
                    MoveMenu.processMenuInput(player, MoveMenu.getMenuInput(player));
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
