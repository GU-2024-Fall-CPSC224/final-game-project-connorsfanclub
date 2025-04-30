package edu.gonzaga;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

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

    public GameScreen(List<Player> players, Board board) {
        this.players = players;
        this.board = board;
        this.deck = new CardDeck();
        this.deck.shuffle();

        setTitle("Candy Land Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        cardLabel = new JLabel("Click 'Next Turn' to draw a card", SwingConstants.CENTER);
        cardLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(cardLabel, BorderLayout.NORTH);

        statusLabel = new JLabel("Ready to start!", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        mainPanel.add(statusLabel, BorderLayout.CENTER);

        JButton nextTurnButton = new JButton("Next Turn");
        nextTurnButton.addActionListener(e -> takeTurn());
        mainPanel.add(nextTurnButton, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void takeTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        Card card = deck.drawCard();
        board.movePlayerToken(currentPlayer, card);

        cardLabel.setText(currentPlayer.getName() + " drew: " + card.toString());
        statusLabel.setText(currentPlayer.getName() + " moved to space " + currentPlayer.getPosition());

        if (board.isEnd(currentPlayer.getPosition())) {
            JOptionPane.showMessageDialog(this, currentPlayer.getName() + " wins!");
            new WinLooseScreen(players, board);
            dispose();
            return;
        }

        // Move to next player
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}
