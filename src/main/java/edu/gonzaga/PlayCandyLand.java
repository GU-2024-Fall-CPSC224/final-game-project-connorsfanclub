/*
 * Final project main driver class
 * 
 * 
 * Project Description:
 * 
 * 
 * Contributors:
 * 
 * 
 * Copyright: 2023
 */
package edu.gonzaga;

/**
 * Main program class for launching your team's program. Should include the
 * beginGame, Turn, isGameOver methods note: interacts with Board, CardDeck and
 * Player
 *
 *
 * PlayCandlyLand.beginGame() should prob set up the Board, CardDeck, and
 * initialize Players
 */
public class PlayCandyLand {

    public static void main(String[] args) {
        System.out.println("Hello Team Game");

        // Your code here. Good luck!
    }
}

// general gameflow/notes here
// during a turn (Turn()), a card is drawn from CardDeck, card's symbol/color is checked,
// Board.getNextSpace(color) finds right space to move to
// Board.movePlayerToken() moves the player
// the player's current position is updated with Player.moveTo(Space)
