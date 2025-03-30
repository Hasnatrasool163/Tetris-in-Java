package tetris;

import javax.swing.*;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[]args){

        JFrame window = new JFrame("Simple Tetris");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        KeyHandler kh = new KeyHandler();
        GamePanel gp = new GamePanel(kh);

        kh.addObserver(gp);
        window.add(gp);
        window.pack();

        gp.LaunchGame();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
