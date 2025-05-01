package edu.gonzaga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameScreen extends JFrame {

    private Board board;
    private List<Player> players;
    private CardDeck deck;
    private int currentPlayerIndex = 0;
    private JLabel cardLabel;
    private JLabel statusLabel;
    private JPanel boardPanel;
    private JLabel[] spaceLabels;
    private boolean gameOver = false;

    public GameScreen(List<Player> players, Board board) {
        this.players = players;
        this.board = board;
        this.deck = new CardDeck();
        this.deck.shuffle();

        setTitle("Candy Land Game");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main layout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Card label at top
        cardLabel = new JLabel("Click 'Next Turn' to draw a card", SwingConstants.CENTER);
        cardLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(cardLabel, BorderLayout.NORTH);

        // Status label at bottom
        statusLabel = new JLabel("Ready to start!", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        mainPanel.add(statusLabel, BorderLayout.SOUTH);

        // Board layout in center
        boardPanel = new JPanel(new GridLayout(5, 10));  // 5 rows x 10 columns = 50 spaces
        spaceLabels = new JLabel[board.getSpaces().size()];
        for (int i = 0; i < board.getSpaces().size(); i++) {
            JLabel label = new JLabel("" + i, SwingConstants.CENTER);
            label.setOpaque(true);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setBackground(getColorFromString(board.getSpace(i).getSpaceColor()));
            spaceLabels[i] = label;
            boardPanel.add(label);
        }
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        // Button on right
        JButton nextTurnButton = new JButton("Next Turn");
        nextTurnButton.addActionListener(e -> takeTurn());
        mainPanel.add(nextTurnButton, BorderLayout.EAST);

        add(mainPanel);
        setVisible(true);

        updateBoard();
    }

    private void takeTurn() {
        if (gameOver) return;

        Player currentPlayer = players.get(currentPlayerIndex);
        Card card = deck.drawCard();
        board.movePlayerToken(currentPlayer, card);

        cardLabel.setText(currentPlayer.getName() + " drew: " + card.toString());
        statusLabel.setText(currentPlayer.getName() + " moved to space " + currentPlayer.getPosition());

        updateBoard();

        // Check if player has reached Hemmingson (space 49)
        if (currentPlayer.getPosition() == 49) {
            gameOver = true;
            JOptionPane.showMessageDialog(this, currentPlayer.getName() + " wins by reaching Hemmingson!");
            new WinLooseScreen(players, board);
            dispose();
            return;
        }

        // Move to the next player
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    private void updateBoard() {
        for (int i = 0; i < spaceLabels.length; i++) {
            spaceLabels[i].setText("" + i);
        }

        for (Player player : players) {
            int pos = player.getPosition();
            String currentText = spaceLabels[pos].getText();
            spaceLabels[pos].setText(currentText + " | " + player.getName().charAt(0));
        }
    }

    private Color getColorFromString(String color) {
        switch (color.toLowerCase()) {
            case "red": return Color.RED;
            case "blue": return Color.BLUE;
            case "green": return Color.GREEN;
            case "yellow": return Color.YELLOW;
            case "orange": return Color.ORANGE;
            case "purple": return new Color(128, 0, 128);
            default: return Color.LIGHT_GRAY;
        }
    }
}
