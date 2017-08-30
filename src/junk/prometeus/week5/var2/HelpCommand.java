package junk.prometeus.week5.var2;

public class HelpCommand implements Command {
    ReciverClass c;
    public HelpCommand(ReciverClass c) { this.c = c; }
    
    @Override
    public void execute() { c.help(); }
}
