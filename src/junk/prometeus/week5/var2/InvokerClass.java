package junk.prometeus.week5.var2;

public class InvokerClass {
    
    private Command help;
    private Command echo;
    private Command date;
    private Command exit;

    public InvokerClass(Command help, Command echo, Command date, Command exit) {
        this.help = help;
        this.echo = echo;
        this.date = date;
        this.exit = exit;
    }
    
    void help(){ help.execute(); }
    void echo(){ echo.execute(); }
    void date(){ date.execute(); }
    void exit(){ exit.execute(); }
    
}
