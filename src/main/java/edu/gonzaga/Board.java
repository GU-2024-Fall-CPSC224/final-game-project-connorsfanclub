package edu.gonzaga;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Space> spaces = new ArrayList<>();  // List of all spaces on the board
    private List<Player> players = new ArrayList<>();  // List of players
    private boolean firstTurn = true; // Flag to track the first turn for the players

    // Constructor to initialize the board
    public Board() {
    }

    // Initializes the board with alternating colors and symbols
    public void initializeBoard() {
        String[] colors = {"red", "blue", "green", "yellow", "orange", "purple"};
        String[] symbols = {"SaintAls", "Spike", "SkyBridge", "Herek", "Hemmingson"};
        int colorIndex = 0;
        int symbolIndex = 0;

        // Loop to create spaces for the board
        for (int i = 0; i < 50; i++) {
            String color = colors[colorIndex];
            colorIndex = colorIndex + 1;
            if (colorIndex == colors.length) {
                colorIndex = 0;  // Loop through colors if needed
            }

            String symbol = null;
            // Add symbols at every 10th space
            if (i % 10 == 0 && symbolIndex < symbols.length) {
                symbol = symbols[symbolIndex];
                symbolIndex = symbolIndex + 1;
            }
            Space space = new Space(i, color, symbol);  // Create a new space
            spaces.add(space);  // Add the space to the list
        }
    }

    // Return the list of spaces (for debugging or testing)
    public List<Space> getSpaces() {
        return spaces;
    }

    // Get the space at a specific index
    public Space getSpace(int index) {
        return spaces.get(index);
    }

    // Check if a player has reached the end of the board (last space)
    public boolean isEnd(int index) {
        return index >= spaces.size() - 1;
    }

    // Get the next space based on the color of the card
    // Handles single and double cards, moving to the first or second matching color space
    public int getNextSpace(String color, int startIndex, boolean isDouble) {
    int count = 0;

    // Loop through the spaces starting from the current position
    for (int i = startIndex + 1; i < spaces.size(); i++) {
        Space nextSpace = spaces.get(i);
        String spaceColor = nextSpace.getSpaceColor();

        if (spaceColor.equals(color)) {
            count++;
            // If it's a single color card, move to the first match
            // If it's a double color card, move to the second match
            if ((!isDouble && count == 1) || (isDouble && count == 2)) {
                return i;  // Return the index of the matched space
            }
        }
    }

    // If no valid space found, return the last space (end of the board)
    return spaces.size() - 1;  // Ensure we do not return an out-of-bounds index
}


    // Find the index of the space that matches the given symbol
    public int getSymbolIndex(String symbol) {
        for (int i = 0; i < spaces.size(); i++) {
            Space currentSpace = spaces.get(i);
            String spaceSymbol = currentSpace.getSpaceSymbol();

            if (spaceSymbol != null && spaceSymbol.equals(symbol)) {
                return i;  // Return the index of the space with the symbol
            }
        }
        return -1;  // Return -1 if the symbol was not found
    }

    // Restrict how each player moves based on custom rules
    public int getRestrictedMove(Player player, int newIndex, Card card) {
    int maxMove = 0;

    // Example: Limit moves for Player 1 to 3 spaces maximum per turn
    if (player.getName().equals("Zag1")) {
        maxMove = 3;
    } else if (player.getName().equals("Zag2")) {
        maxMove = 4;
    } else {
        maxMove = 5; // Default for other players
    }

    // Ensure that the new index doesn't exceed the restricted move limit
    int maxIndex = spaces.size() - 1;  // Get the last valid index
    int restrictedMove = Math.min(newIndex, player.getPosition() + maxMove);
    return Math.min(restrictedMove, maxIndex);  // Ensure the index doesn't go beyond the board's size
}


    // Move the player's token based on the drawn card
    public void movePlayerToken(Player player, Card card) {
    int newIndex;

    if (card.hasSymbol()) {
        // If the card has a symbol, move to the space with that symbol
        String symbol = card.getSymbol();
        newIndex = getSymbolIndex(symbol);
    } else {
        // If it's a color card, get the next space based on the color and whether it's a double card
        int currentIndex = player.getPosition();
        String cardColor = card.getColor();
        boolean isDouble = card.isDouble();
        newIndex = getNextSpace(cardColor, currentIndex, isDouble);
    }

    // Apply individual player movement restrictions
    newIndex = getRestrictedMove(player, newIndex, card);

    // Prevent jumping too far on the first turn
    if (firstTurn) {
        // If the player is on the first turn, limit the movement
        newIndex = Math.min(newIndex, player.getPosition() + 5);  // Limit to a maximum of 5 spaces for first turn
        if (player.getPosition() == 0) {
            firstTurn = false;  // End the first turn check after the player moves
        }
    }

    // Ensure the newIndex is within bounds
    int maxIndex = spaces.size() - 1;
    if (newIndex >= 0 && newIndex <= maxIndex) {
        player.moveTo(newIndex);
    } else {
        // Ensure the player does not move out of bounds, place them at the last space
        player.moveTo(maxIndex);
    }
}

}