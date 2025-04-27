package edu.gonzaga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WinLooseScreen extends JFrame {
    private Player winner;
    private List<Player> players;
    private Board board;

    public WinLooseScreen(List<Player> players, Board board) {
        this.players = players;
        this.board = board;

        // Initialize winner and losers text
        StringBuilder losersText = new StringBuilder("Losers: ");
        
        // Loop through players and check if they have reached the end using board.isEnd
        for (Player player : players) {
            if (board.isEnd(player.getPosition())) {
                winner = player;
            } else {
                losersText.append(player.getName()).append(" ");
            }
        }

        // Set up the Win/Lose screen
        setTitle("Game Over!");
        setSize(600, 400); // Set the size of the window
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel and set the layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.CYAN); // Set a nice background color

        // Create a label to display the winner
        JLabel winnerLabel = new JLabel("Winner: " + (winner != null ? winner.getName() : "No Winner"), SwingConstants.CENTER);
        winnerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        winnerLabel.setForeground(Color.RED);

        // Create a label to display the losers
        JLabel losersLabel = new JLabel(losersText.toString(), SwingConstants.CENTER);
        losersLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        losersLabel.setForeground(Color.BLACK);

        // Add the winner label to the panel at the top
        panel.add(winnerLabel, BorderLayout.NORTH);
        
        // Add the losers label below the winner
        panel.add(losersLabel, BorderLayout.CENTER);

        // Add the panel to the frame
        add(panel);

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Sample data to test the WinLooseScreen
        Board board = new Board();
        board.initializeBoard();

        // Create some dummy players for testing
        List<Player> players = List.of(new Player("Zag1", "red"), new Player("Zag2", "blue"));
        
        // Manually set positions for testing
        players.get(0).moveTo(50); // Player 1 is at the end (Winner)
        players.get(1).moveTo(20); // Player 2 is not at the end (Loser)

        // Launch the WinLooseScreen with the sample data
        new WinLooseScreen(players, board);
    }
}
