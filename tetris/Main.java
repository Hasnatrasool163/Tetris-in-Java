package tetris;

import javax.swing.*;

public class Main {

    public static void main(String[]args){

        JFrame window = new JFrame("Simple Tetris");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);


        // add game panel to the window

        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();

        // added JPanel to JFrame
        //  now the size of game panel becomes the size of JFrame

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gp.LaunchGame();

    }
}
