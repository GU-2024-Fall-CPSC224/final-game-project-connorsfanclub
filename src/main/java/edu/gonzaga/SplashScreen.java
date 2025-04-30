package edu.gonzaga;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SplashScreen extends JFrame {

    public SplashScreen() {
        // Set up the splash screen
        setTitle("Welcome to Gonzaga Candy Land!");
        setSize(600, 400); // Set the size of the window
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load and scale the background image
        ImageIcon backgroundImageIcon = new ImageIcon("src/main/java/edu/gonzaga/4db728927333728bcb5717cdba3040d8.jpg");
        Image backgroundImage = backgroundImageIcon.getImage();
        Image scaledImage = backgroundImage.getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Create a panel with custom painting for the background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.drawImage(scaledIcon.getImage(), 0, 0, this);
            }
        };

        panel.setLayout(null); // Use null layout for custom positioning
        panel.setBackground(Color.CYAN); // Fallback color if image fails

        // Add welcome message
        JLabel splashLabel = new JLabel(" ", SwingConstants.CENTER);
        splashLabel.setBounds(100, 100, 400, 40);
        splashLabel.setFont(new Font("Arial", Font.BOLD, 24));
        splashLabel.setForeground(Color.BLACK);
        panel.add(splashLabel);

        // Add Start Game button
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(250, 250, 100, 40);
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        startButton.setBackground(Color.GREEN);
        startButton.setForeground(Color.BLACK);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When the Start Game button is clicked, close the splash screen
                dispose(); // Close the splash screen
                new NameInputScreen(); // Open the NameInputScreen
            }
        });
        panel.add(startButton);

        // Add the panel to the frame and display
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Display the SplashScreen first
        new SplashScreen();
    }
}
