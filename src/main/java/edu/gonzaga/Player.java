package edu.gonzaga;

public class Player {
    private String name;
    private String tokenColor;
    private int position;
    private boolean isFirstTurn; // New variable to track first turn

    public Player(String name, String tokenColor) {
        this.name = name;
        this.tokenColor = tokenColor;
        this.position = 0; // All players start at position 0
        this.isFirstTurn = true; // Initially, the player is on their first turn
    }

    public String getName() {
        return name;
    }

    public String getTokenColor() {
        return tokenColor;
    }

    public int getPosition() {
        return position;
    }

    public void moveTo(int position) {
        this.position = position;
    }

    // Method to mark the player’s turn as not first anymore
    public void setFirstTurn(boolean isFirstTurn) {
        this.isFirstTurn = isFirstTurn;
    }

    // Method to check if it's the player's first turn
    public boolean isFirstTurn() {
        return isFirstTurn;
    }
}
