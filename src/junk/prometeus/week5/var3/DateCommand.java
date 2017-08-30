package junk.prometeus.week5.var3;

public class DateCommand implements Command {
    
    @Override
    public void execute() { System.out.println(System.currentTimeMillis()); }
}
