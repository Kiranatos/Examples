package junk.prometeus.week5.var5;

import java.util.ArrayList;
import java.util.Map;

public class CommandWithReceiver {

    public static void main(String[] args) {
        try {
            if (args != null && args.length > 0) {
                Receiver receiver = new Receiver();
                Map<String, Command> instruction = receiver.getInstruction();
                String commandID = args[0].toLowerCase();
                Command command = instruction.get(commandID);
                if (command != null) {
                    if (command.getNumOfArguments() == args.length - 1) {
                        if (command.getNumOfArguments() > 0) {
                            ArrayList<Object> arguments = new ArrayList<>();
                            for (int i = 1; i <= command.getNumOfArguments(); i++) {
                                arguments.add(args[i]);
                            }
                            command.setArguments(arguments);
                        }
                        command.execute();
                    } else {
                        throw new Exception("Некорректное количество аргументов.");
                    }
                } else {
                    throw new Exception("Неизвестная ресиверу команда.");
                }
            } else {
                throw new Exception("В программу не переданы аргументы.");
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
