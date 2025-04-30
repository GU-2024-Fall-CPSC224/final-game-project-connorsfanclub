package edu.gonzaga;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NameInputScreen extends JFrame {
    private int numPlayers = 0;
    private final List<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;
    private JTextField inputField;
    private JLabel promptLabel;

    private final String[] defaultNames = {"Zag1", "Zag2", "Zag3", "Zag4"};
    private final String[] tokenColors = {"red", "blue", "green", "yellow"};

    public NameInputScreen() {
        setTitle("Enter Player Names");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);

        promptLabel = new JLabel("Enter number of players (2-4):");
        promptLabel.setBounds(50, 20, 300, 30);
        promptLabel.setFont(new Font("Arial", Font.BOLD, 16));
        promptLabel.setForeground(Color.WHITE);
        panel.add(promptLabel);

        inputField = new JTextField();
        inputField.setBounds(50, 60, 300, 30);
        panel.add(inputField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 100, 100, 30);
        submitButton.addActionListener(e -> handleInput());
        panel.add(submitButton);

        add(panel);
        setVisible(true);
    }

    private void handleInput() {
        if (numPlayers == 0) {
            try {
                int input = Integer.parseInt(inputField.getText().trim());
                if (input >= 2 && input <= 4) {
                    numPlayers = input;
                    promptLabel.setText("Enter name for Player 1");
                    inputField.setText("");
                } else {
                    promptLabel.setText("Please enter a number between 2 and 4:");
                }
            } catch (NumberFormatException ex) {
                promptLabel.setText("Invalid input. Please enter a number:");
            }
        } else {
            String nameInput = inputField.getText().trim();
            String name = nameInput.isEmpty() ? defaultNames[currentPlayerIndex] : nameInput;
            String color = tokenColors[currentPlayerIndex];
            players.add(new Player(name, color));

            currentPlayerIndex++;
            inputField.setText("");

            if (currentPlayerIndex < numPlayers) {
                promptLabel.setText("Enter name for Player " + (currentPlayerIndex + 1));
            } else {
                dispose(); // Close the name input screen
                new PlayCandyLand(players); // Start game with entered players
                PlayCandyLand.beginGame();  // Launch main game loop
            }
        }
    }
}
