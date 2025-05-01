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

<<<<<<< Updated upstream
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // for user input
>>>>>>> Stashed changes

public class PlayCandyLand {
<<<<<<< Updated upstream
    public static List<Player> players = new ArrayList<>(); // list of players (we can do 2-4?)

    public static void main(String[] args) {
        // Create the splash screen before anything else
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SplashScreen();  // Show the splash screen
=======

    private static final Scanner scanner = new Scanner(System.in); // used to ask for player input
    private static final Board board = new Board(); // the game board (spaces + symbols)
    private static final CardDeck deck = new CardDeck(); // shuffled deck of cards
    private static final List<Player> players = new ArrayList<>(); // list of players (we can do 2-4?)

    public static void main(String[] args) {
        // goal of this game entry point is to print a welcome message, call beginGame (sets everythig up)
        // and loops through each player's turn until someone wins (gameOver = true)
        System.out.println("Welcome to Gonzaga Candy Land!");
        new SplashScreen();
        beginGame();

        boolean gameOver = false;
        while (!gameOver) {
            for (Player player : players) {
                System.out.println("\n " + player.getName() + "'s turn:");
                gameOver = takeTurn(player);
                if (gameOver) {
                    
                    Player winner = players.get(0);  
                System.out.println("Winner: " + winner.getName());
                new WinLooseScreen(players, board); 
                break; 
                }
    
>>>>>>> Stashed changes
            }
        });
    }

<<<<<<< Updated upstream
    // This method will be called after the names are entered, transition to the main game
    public static void startGame() {
        // Start the main game after players are initialized in NameInputScreen
        new GameScreen(players, new Board());
=======
    // here we set up board, deck, and players
    private static void beginGame() {
        setupPlayers(); // calls function to get names
        board.initializeBoard();
        
        System.out.println("\nBoard setup complete. Let’s play!");

         
    }
    
    // set up players (2-4) and enter their names
    private static void setupPlayers() {
        int numPlayers;
       new NameInputScreen(); 
        do {
            System.out.print("Enter number of players (2-4): ");
            numPlayers = Integer.parseInt(scanner.nextLine());
        } while (numPlayers < 2 || numPlayers > 4);

        // put the default name logic here
        String[] defaultNames = {"Zag1", "Zag2", "Zag3", "Zag4"};
        String[] tokenColors = {"red", "blue", "green", "yellow"};

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + " (or press enter for default): ");
            String input = scanner.nextLine().trim();
            String name = input.isEmpty() ? defaultNames[i] : input;
            players.add(new Player(name, tokenColors[i])); // creates a new player object and adds to the list
        }

    }

    // need to handle a single player turn here
    private static boolean takeTurn(Player player) {
        Card card = deck.drawCard();
        System.out.println("Drew card: " + card);

        board.movePlayerToken(player, card); // handles if there is a position change
        System.out.println(player.getName() + " is now at space " + player.getPosition());

        if (board.isEnd(player.getPosition())) {
            System.out.println("Finished: " + player.getName() + " has reached Hemmingson and WINS!!");

            return true; // if they've reached last space -> stops the game
            
        }
    
        return false;

>>>>>>> Stashed changes
    }

    
}
