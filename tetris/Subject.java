package tetris;

import java.util.Observer;

public interface Subject {

    public void addObserver(PowerUpObserver o);
    public void removeObserver(PowerUpObserver o);
    public void notifyObservers();
}
