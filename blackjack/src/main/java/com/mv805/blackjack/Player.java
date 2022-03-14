package com.mv805.blackjack;

public class Player {

    private int money;
    private Location location = Location.LOBBY;
    private PlayerState playerState = PlayerState.INTRO;

    public Player(int money) {
        this.money = money;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public Location getPlayerLocation() {
        return location;
    }

    public void setPlayerLocation(Location location) {
        this.location = location;
    }
}
