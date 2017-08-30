package junk.prometeus.week5.var2;

public class DateCommand implements Command {
    ReciverClass c;
    public DateCommand(ReciverClass c) { this.c = c; }
    
    @Override
    public void execute() { c.date(); }
}
