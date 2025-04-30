package edu.gonzaga;

import java.util.List;
import java.util.Scanner;

/**
 * Main program class for launching your team's program.
 */
public class PlayCandyLand {
    
    private static final Scanner scanner = new Scanner(System.in); // Optional, not needed for names anymore
    private static final Board board = new Board(); // The game board (spaces + symbols)
    private static final CardDeck deck = new CardDeck(); // Shuffled deck of cards
    private static List<Player> players; // List of players (set from NameInputScreen)

    // Constructor accepts the player list from NameInputScreen
    public PlayCandyLand(List<Player> players) {
        PlayCandyLand.players = players;
    }

    public static void main(String[] args) {
        // Start the name input screen (it triggers the game start after names are collected)
        new SplashScreen(); 
       
    }

    // Called after names are entered and the game is ready to start
    public static void beginGame() {
         board.initializeBoard(); // Set up board
         new GameScreen(players, board); // Launch GUI
        System.out.println("Welcome to Gonzaga Candy Land!");
        board.initializeBoard();  // Sets up the board
        deck.shuffle();           // Shuffle cards
         
        System.out.println("\nBoard setup complete. Let’s play!"); 

        boolean gameOver = false;
        while (!gameOver) {
            for (Player player : players) {
                System.out.println("\n" + player.getName() + "'s turn:");
                gameOver = takeTurn(player);
                if (gameOver) {
                    System.out.println("Winner: " + player.getName());
                    
                    break;
                }
            }
        }

        System.out.println("Thanks for playing!");
    }

    // Handles one player's turn
    private static boolean takeTurn(Player player) {
        Card card = deck.drawCard(); // Draw a card
        System.out.println("Drew card: " + card);

        board.movePlayerToken(player, card); // Move token
        System.out.println(player.getName() + " is now at space " + player.getPosition());

        if (board.isEnd(player.getPosition())) {
            System.out.println("Finished: " + player.getName() + " has reached Hemmingson and WINS!!");
            return true; // Player has won
        }

        return false; // Game continues
    }
}
