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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    private static final Scanner scanner = new Scanner(System.in);
    private static final Board board = new Board();
    private static final CardDeck deck = new CardDeck();
    private static final List<Player> players = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Gonzaga Candy Land!");
        // need to set up players here?

        boolean gameOver = false;
        while (!gameOver) {
            // main game logic here? then we just set up gameOver = true when need to break?
        }

    }
}

// general gameflow/notes here
// during a turn (Turn()), a card is drawn from CardDeck, card's symbol/color is checked,
// Board.getNextSpace(color) finds right space to move to
// Board.movePlayerToken() moves the player
// the player's current position is updated with Player.moveTo(Space)
