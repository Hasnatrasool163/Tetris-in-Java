package tetris;


import java.awt.*;
import java.awt.Graphics2D;


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
        // Draw a professional gradient background for the menu
        GradientPaint menuBG = new GradientPaint(0, 0, Color.DARK_GRAY, 0, HEIGHT, Color.BLACK);
        g2.setPaint(menuBG);
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        // Enable text anti-aliasing for smoother text
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Draw a prominent game title
        g2.setColor(Color.WHITE);
        Font titleFont = new Font("Verdana", Font.BOLD, 64);
        g2.setFont(titleFont);
        String title = "Tetris Pro";
        int titleWidth = g2.getFontMetrics().stringWidth(title);
        g2.drawString(title, (WIDTH - titleWidth) / 2, HEIGHT / 3);

        // Draw refined instructions
        Font instrFont = new Font("SansSerif", Font.PLAIN, 24);
        g2.setFont(instrFont);
        String instructions = "Press 1 to Start, Press 2 to Quit";
        int instrWidth = g2.getFontMetrics().stringWidth(instructions);
        g2.drawString(instructions, (WIDTH - instrWidth) / 2, HEIGHT / 2);

        instructions = "Press M to turn On the Music";
        instrWidth = g2.getFontMetrics().stringWidth(instructions);
        g2.drawString(instructions, (WIDTH - instrWidth) / 2, (int) (HEIGHT / (1.5)));
    }

    public void update()
    {

    }
}
