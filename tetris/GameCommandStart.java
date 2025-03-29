package tetris;

public class GameCommandStart implements Command {


    @Override
    public void execute() {
        System.out.println("Game Starting");
        KeyHandler.gamestart = true;
    }
}
