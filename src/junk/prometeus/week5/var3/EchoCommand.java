package junk.prometeus.week5.var3;

public class EchoCommand implements Command {
    String str;
    public EchoCommand(String str) { this.str = str; }
    
    @Override
    public void execute() { System.out.println(str); }
}
