package tetris;

public class GameCommandQuit implements Command {

    @Override
    public void execute() {
        System.out.println("Game Quit");
        KeyHandler.gamequit = true;
    }
}
