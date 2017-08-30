package junk.prometeus.week5.var2;

public class ExitCommand implements Command {
    ReciverClass c;
    public ExitCommand(ReciverClass c) { this.c = c; }
    
    @Override
    public void execute() { c.exit(); }
}
