package pattern.command.ex4_all_house;

import patterns.command.ex4_all_house.commands.Command;
import pattern.command.ex4_all_house.commands.ConcreteCommand;

/**
 * Сьерра К., Бейтс Б., Фримен Э., Фримен Э. - Паттерны проектирования (2011-656-1).
 * стр. 238 глава 6
*/

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;
    
    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];
        
        Command noCommand = new ConcreteCommand.NoCommand();
        for (int i=0; i<7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }
    
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;        
    }
    
    //нажатие на кнопку
    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }
    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }
    public void undoButtonWasPushed() {        
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("\n------ Remote Control ------\n");
        for (int i=0; i<onCommands.length; i++) {
            str.append("[slot " + i + "] " + onCommands[i].getClass().getSimpleName() + 
                    "  " + offCommands[i].getClass().getName() + "\n");
        }
        return str.toString();
    }
}




