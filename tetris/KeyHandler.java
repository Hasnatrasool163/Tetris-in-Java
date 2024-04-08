package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public static boolean upPressed,downPressed,leftPressed,rightPressed,pausePressed;
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

    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
