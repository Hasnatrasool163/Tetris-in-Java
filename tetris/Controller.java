package tetris;

import java.util.ArrayList;

public class Controller {
    ArrayList<Command> slots = new ArrayList<Command>();

    public void setSlot(Command command)
    {
        slots.add(command);
    }

    public void pressbuton(int index)
    {
        if(slots.isEmpty())
        {
            System.out.println("Slots are empty");
        }
        else
        {
            Command command = slots.get(index);
            if(command!=null)
            {
                command.execute();

            }
            else
            {
                System.out.println("Command not found");
            }
        }
    }
}
