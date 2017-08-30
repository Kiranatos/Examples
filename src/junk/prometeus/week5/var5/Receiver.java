package junk.prometeus.week5.var5;

import java.util.HashMap;
import java.util.Map;

public class Receiver {

    private final Command mCommandHelp; // Поддерживаемая ресивером команда Help.
    private final Command mCommandEcho; // Поддерживаемая ресивером команда Echo.
    private final Command mCommandExit; // Поддерживаемая ресивером команда Exit.
    private final Command mCommandDate; // Поддерживаемая ресивером команда Date.

    public Receiver() {
        mCommandHelp = new CommandHelp(this);
        mCommandEcho = new CommandEcho(this);
        mCommandExit = new CommandExit(this);
        mCommandDate = new CommandDate(this);
    }

    /**
     * Прочитать инструкцию по использованию Исполнителя команд.
     *
     * @return - Соответствие строк с именами команд самим командам.
     */
    public Map<String, Command> getInstruction() {
        Map<String, Command> result = new HashMap<>();
        result.put("help", mCommandHelp);
        result.put("echo", mCommandEcho);
        result.put("exit", mCommandExit);
        result.put("date", mCommandDate);
        return result;
    }

    /**
     * Обработчик команды Help.
     */
    public void help() {
        System.out.println("Help executed");
    }

    /**
     * Обработчик команды Echo.
     *
     * @param aMsg - Выводимое сообщение.
     */
    public void echo(String aMsg) {
        System.out.println(aMsg);
    }

    /**
     * Обработчик команды Exit.
     */
    public void exit() {
        System.out.println("Goodbye!");
    }

    /**
     * Обработчик команды Date с параметром now.
     */
    public void dateNow() {
        System.out.println(System.currentTimeMillis());
    }

}
