package edu.gonzaga;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PlayCandyLand {
    public static List<Player> players = new ArrayList<>(); // list of players (we can do 2-4?)

    public static void main(String[] args) {
        // Create the splash screen before anything else
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SplashScreen();  // Show the splash screen
            }
        });
    }

    // This method will be called after the names are entered, transition to the main game
    public static void startGame() {
        // Start the main game after players are initialized in NameInputScreen
        new GameScreen(players, new Board());
    }
}
