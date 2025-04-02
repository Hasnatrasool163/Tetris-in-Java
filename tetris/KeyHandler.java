package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observer;

public class KeyHandler implements KeyListener, Subject {

    public Controller buttons = new Controller();

    public GameCommandStart startcomamnd = new GameCommandStart();
    public GameCommandQuit quitcomamnd = new GameCommandQuit();

    public static ArrayList<PowerUpObserver> observers = new ArrayList<>();
    public static boolean musicOn = false;
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
        if(code == KeyEvent.VK_S){
            notifyObservers();
        }
        if(code == KeyEvent.VK_M) {
            if (musicOn) {
                GamePanel.music.stop();
                musicOn = false;
                System.out.println("Music Off");
            } else {
                GamePanel.music.play(0, true);
                GamePanel.music.loop();
                musicOn = true;
                System.out.println("Music On");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void addObserver(PowerUpObserver o) {
        observers.add((PowerUpObserver) o);
    }

    @Override
    public void removeObserver(PowerUpObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(PowerUpObserver o : observers)
        {
            o.PowerUpUpdate();
        }
    }
}
