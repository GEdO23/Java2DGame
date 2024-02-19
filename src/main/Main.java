package main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        // Will let the window properly close with the close button
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");
        // When window location is not specified, display's at center of the screen
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

}
