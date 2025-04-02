package tetris;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable, PowerUpObserver {

    public static  final int WIDTH=1150;
    public static  final int HEIGHT=620;

    final int FPS = 60; // to update screen 60 times a second (frames per seconds)
    Thread GameThread; // to run game loop

    PlayManager pm = new PlayManager();
    MenuHandler mh = new MenuHandler();
    public static Sound music = new Sound();
    public static Sound se = new Sound();

    public static Boolean powerupused;

    public static int PowerupCounter;

    public static Boolean powerupInProgress;



    public GamePanel(KeyHandler kh) {
        // panel settings
        powerupused = false;
        powerupInProgress = false;
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.addKeyListener(kh);
        this.setFocusable(true);

    }


    public void LaunchGame(){
        GameThread = new Thread(this);
        GameThread.start();

    }

    @Override
    public void run() {

        // so  in every game loop
        // we perform 2 task
        // update + draw
        // in update we update position x and y
        double drawInterval = (double) 1000000000 /FPS;
        double delta =0;

        long lastTime = System.nanoTime();
        long currentTime;
        double poweruptimedelta = 0;

        long currentPowerupTime;
        long lastPowerUpTime = System.currentTimeMillis();

        int powerupCounter = 0;

        int powerupInProgressCounter = 0;

        while(GameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >=1){
                update();
                repaint();
                delta--;
            }

            currentPowerupTime = System.currentTimeMillis();

            poweruptimedelta += (currentPowerupTime - lastPowerUpTime)/1000F;

            lastPowerUpTime = currentPowerupTime;

            if (poweruptimedelta >= 1){

                poweruptimedelta--;

                //This logic takes care of the power up being on cooldown
                if(powerupused && powerupCounter >= 20){
                    powerupused = false;
                    powerupCounter = 0;
                    System.out.println("Powerup Rest: " + powerupCounter);
                }
                else if(powerupused && powerupCounter < 20){
                    powerupCounter++;
                    System.out.println("Powerup Counter: " + powerupCounter);
                }

                //this makes it so that when the power up is used and in progress it keeps track of the time
                if(powerupused && powerupInProgress){
                    powerupInProgressCounter++;
                }

                //this resets the power up
                if(powerupInProgress && powerupInProgressCounter >= 10){
                    powerupInProgress = false;
                    PlayManager.dropInterval -= 40;
                    powerupInProgressCounter = 0;
                    System.out.println("Powerup over!");
                }
            }

        }
    }

    private void update() {

        if (!KeyHandler.gamestart) {
            mh.update();
        }
        if (KeyHandler.gamequit)
        {
            System.exit(0);
        }
        else if(!KeyHandler.pausePressed && !pm.gameOver)
        {
        pm.update();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        if (!KeyHandler.gamestart)
        {
            mh.draw(g2);
        }
        else {
         pm.draw(g2);
            }
//        pm.draw(g2);

    }

    @Override
    public void PowerUpUpdate() {
       if(!powerupused){
           PlayManager.dropInterval += 40;
           System.out.println(PlayManager.dropInterval);
           powerupused = true;
           powerupInProgress = true;
           PowerupCounter = 0;
       }
       else {
           System.out.println("the power up is on cooldown");
       }
    }
}
