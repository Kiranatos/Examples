package junk.prometeus.week5.var2;

public class EchoCommand implements Command {
    ReciverClass c;
    public EchoCommand(ReciverClass c) { this.c = c; }
    
    @Override
    public void execute() { c.echo(); }
}
