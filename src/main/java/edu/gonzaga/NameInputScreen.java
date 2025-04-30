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
    private int numPlayers; // Number of players
    private List<String> playerNames = new ArrayList<>(); // List to store player names
    private int currentPlayerIndex = 0; // Track current player
    private JTextField inputField; // Input field for names
    private JLabel promptLabel; // Label to prompt user

    public NameInputScreen() {
        // Set up the frame
        setTitle("Enter Player Names");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);

        // Prompt for the number of players
        promptLabel = new JLabel("Enter number of players (2-4):");
        promptLabel.setBounds(50, 20, 300, 30);
        promptLabel.setFont(new Font("Arial", Font.BOLD, 18));
        promptLabel.setForeground(Color.WHITE);
        panel.add(promptLabel);

        // Input field for number of players or names
        inputField = new JTextField();
        inputField.setBounds(50, 60, 300, 30);
        panel.add(inputField);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 100, 100, 30);
        submitButton.addActionListener(e -> handleInput());
        panel.add(submitButton);

        // Add the panel to the frame
        add(panel);
        setVisible(true);
    }

    private void handleInput() {
        // Handle the input depending on the current state (number of players or player names)
        if (numPlayers == 0) {
            // Get the number of players
            try {
                int input = Integer.parseInt(inputField.getText().trim());
                if (input >= 2 && input <= 4) {
                    numPlayers = input; // Set number of players
                    promptLabel.setText("Enter name for Player 1:");
                    inputField.setText(""); // Clear input field
                } else {
                    promptLabel.setText("Please enter a number between 2 and 4:");
                }
            } catch (NumberFormatException ex) {
                promptLabel.setText("Invalid input. Please enter a number:");
            }
        } else {
            // Get the player's name
            String name = inputField.getText().trim();
            if (!name.isEmpty()) {
                playerNames.add(name); // Store the name
                currentPlayerIndex++;

                if (currentPlayerIndex < numPlayers) {
                    promptLabel.setText("Enter name for Player " + (currentPlayerIndex + 1) + ":");
                    inputField.setText(""); // Clear input field
                } else {
                    // All names are entered
                    System.out.println("Players: " + playerNames);
                    dispose(); // Close the screen
                }
            } else {
                promptLabel.setText("Name cannot be empty. Try again:");
            }
        }
    }

    public static void main(String[] args) {
        new NameInputScreen(); // Launch the NameInputScreen
    }
}