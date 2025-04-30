package edu.gonzaga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SplashScreen extends JFrame {

    public SplashScreen() {
        // Set up the splash screen
        setTitle("Welcome to Gonzaga Candy Land");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the image and set it as the background
        ImageIcon backgroundImage = new ImageIcon("path/to/your/image.jpeg"); // Replace with the actual path to the image
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout()); // Allows adding components over the image
        backgroundLabel.setOpaque(true);

        // Create a label with the welcome message
        JLabel textLabel = new JLabel("Welcome to Gonzaga Candy Land!", SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
        textLabel.setForeground(Color.WHITE); // Ensure text color contrasts with the image

        // Add the text label over the background image
        backgroundLabel.add(textLabel, BorderLayout.CENTER);
        add(backgroundLabel);

        // Make the splash screen visible
        setVisible(true);

        // Show the splash screen for 2 seconds and then close it
        try {
            Thread.sleep(2000); // Display for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dispose(); // Close the splash screen
    }

    public static void main(String[] args) {
        new SplashScreen(); // Create and display the splash screen
    }
}