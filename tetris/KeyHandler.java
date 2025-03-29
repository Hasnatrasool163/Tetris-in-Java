package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public Controller buttons = new Controller();

    public GameCommandStart startcomamnd = new GameCommandStart();
    public GameCommandQuit quitcomamnd = new GameCommandQuit();



    public static boolean upPressed,downPressed,leftPressed,rightPressed,pausePressed;

    public static boolean gamestart = false;
    public static boolean gamequit = false;

    public KeyHandler()
    {
        buttons.setSlot(startcomamnd);
        buttons.setSlot(quitcomamnd);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W ){
                upPressed = true;
        }
        if(code == KeyEvent.VK_UP ){
                upPressed = true;
        }
        if(code == KeyEvent.VK_A){
                leftPressed = true;
        }if(code == KeyEvent.VK_LEFT){
                leftPressed = true;
        }
        if(code == KeyEvent.VK_S){
                downPressed = true;
        }if(code == KeyEvent.VK_DOWN){
                downPressed = true;
        }
        if(code == KeyEvent.VK_D){
                rightPressed = true;
        }if(code == KeyEvent.VK_RIGHT){
                rightPressed = true;
        }
        if(code == KeyEvent.VK_SPACE) {
            if(pausePressed){
                pausePressed = false;
                GamePanel.music.play(0,true);
                GamePanel.music.loop();
            }
            else{
                pausePressed = true;
                GamePanel.music.stop();
            }
        }
        if(code == KeyEvent.VK_1){
            buttons.pressbuton(0);
        }
        if(code == KeyEvent.VK_2){
            buttons.pressbuton(1);
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
