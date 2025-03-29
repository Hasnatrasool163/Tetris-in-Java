package tetris;

import mino.*;

import java.awt.*;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;


public class MenuHandler {

    // 25 *12
    // 25 * 20
    public static final int WIDTH = 1150;
    public static final int HEIGHT = 620;

    public static int right_x;
    public static int left_x;
    public static int top_y;
    public static int bottom_y;

    public void draw(Graphics2D g2){
        g2.setColor(Color.green);
        g2.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        g2.drawString("Press 1 to start, Press 2 to Quit", WIDTH-900, HEIGHT/2);
    }

    public void update()
    {

    }
}
