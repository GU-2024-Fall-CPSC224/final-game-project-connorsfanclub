package edu.gonzaga;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SplashScreen extends JFrame {
    
    public SplashScreen() {
        // Set up the splash screen
        setTitle("Welcome to Gonzaga Candy Land");
        setSize(600, 400); // Make the window larger
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the splash screen panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLUE); // Set the background color to blue

        // Create a label and set the text color to red
        JLabel label = new JLabel("Welcome to Gonzaga Candy Land!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30)); // Increase font size
        label.setForeground(Color.RED); // Set text color to red

        // Add the label to the panel
        panel.add(label, BorderLayout.CENTER);
        add(panel);

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
