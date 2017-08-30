package pattern.command.ex4_all_house.commands;

import patterns.command.ex4_all_house.commands.Command;
import patterns.command.ex4_all_house.commands.Command;
import patterns.command.ex4_all_house.commands.Command;

public class MacroCommand implements Command {
    Command[] commands;

    public MacroCommand(Command[] commands) { this.commands = commands; }
    
    public void execute() {
        for (int i = 0; i< commands.length; i++ )
            commands[i].execute();     
    }

    @Override
    public void undo() {
        //for (int i = commands.length-1; i >= 0; i-- )
        for (int i = 1; i < commands.length; i++ )
            commands[i].undo();     
    }    
}
