package pattern.command.ex1_youtube;

/**
 * 
 * Команда (Command)
 * 
 * классы Comp и User не знают о друг друге нечего.
 * 
 * 
 * Canal:       Школа программирования
 *                  https://www.youtube.com/user/programm4you
 * PlayList:    Шаблоны проектирования Java 
 *                  https://www.youtube.com/playlist?list=PLwcDaxeEINactCC4mly7RQon5juIpH-Q3
 * Video:       Шаблоны Java. Команда (Command)
 *                  https://www.youtube.com/watch?v=8gE-icd93WA&index=11&list=PLwcDaxeEINactCC4mly7RQon5juIpH-Q3&t=315s
 */
public class CommandAppEx1 {
    public static void main(String[] args) {
        Comp c = new Comp();
        User u = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));
        u.startComputer();
        u.resetComputer();
        u.stopComputer();
    }    
}

interface Command { void execute(); }

// Reciver - получатель, приемник
class Comp{
    void start(){ System.out.println("Start"); }
    void stop(){ System.out.println("Stop"); }
    void reset(){ System.out.println("Reset"); }
}

// ConcreteCommand (Можно сделать абстрактный класс)
class StartCommand implements Command {
    Comp computer;
    public StartCommand(Comp computer) { this.computer = computer; }    
    public void execute() { computer.start(); }
}
class StopCommand implements Command {
    Comp computer;
    public StopCommand(Comp computer) { this.computer = computer; }    
    public void execute() { computer.stop(); }
}
class ResetCommand implements Command {
    Comp computer;
    public ResetCommand(Comp computer) { this.computer = computer; }    
    public void execute() { computer.reset(); }
}

// Invoker (invoke - вызывать)
class User{
    private Command start;
    private Command stop;
    private Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    
    void startComputer(){ start.execute(); }
    void stopComputer(){ stop.execute(); }
    void resetComputer(){ reset.execute(); }
}