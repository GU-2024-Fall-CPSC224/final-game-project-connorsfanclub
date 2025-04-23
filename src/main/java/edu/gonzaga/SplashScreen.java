// this could be where we write our Java Swing screen for ntro?
// I don't know if we want another file like GameGUI.java for the board implementation?
package edu.gonzaga;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class SplashScreen extends JFrame{ 
    //this is where the Graphic User interface will go
    JFrame frame; 
    JTextField textfield; 
    Font myFont = new Font("Helvetica", Font.BOLD, 30);

    public SplashScreen(){
        // create and configure main frame 
        frame= new JFrame("GU Candy Land"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit
        frame.setSize(1280, 720);            // Set window size
        frame.setLayout(null);              // Use absolute positioning
        frame.setResizable(false);         // Prevent window resizing

// create and configure text for PlayerName
        textfield = new JTextField();
        textfield.setBounds(18, 18, 300, 65);  // Position and size
        textfield.setFont(myFont);             // Set font
        textfield.setEditable(false);         // Prevent direct text input
        textfield.setHorizontalAlignment(JTextField.RIGHT); // Right-align text












        
    }
}