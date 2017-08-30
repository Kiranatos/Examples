package junk.prometeus.week5.var1;

public class Application {
	public static void main(String[] args){
            //YOUR CODE COMES HERE
            Comp c = new Comp();
            User u = new User(new HelpCommand(c), new EchoCommand(c), new DateCommand(c), new ExitCommand(c));
            
            if ( (args!=null) && (args.length>0) && (args[0]!=null) )  {
                
                if ( (args[0].equals("help")) && (args.length == 1) ) 
                    u.help();                
                else if ( (args[0].equals("exit")) && (args.length == 1) )
                    u.exit();                
                else if ( (args[0].equals("echo")) && 
                          (args.length == 2) && 
                          (args[1]!=null) ) {
                    c.setStr(args[1]);
                    u.echo(); 
                }
                else if ( (args[0].equals("date")) && 
                          (args.length == 2) && 
                          (args[1]!=null) &&
                          (args[1].equals("now"))  )
                    u.date();                
                else System.out.println("Error");                
            }
            else System.out.println("Error");
	}
}

// ConcreteCommand
class HelpCommand implements Command {
    Comp c;
    public HelpCommand(Comp c) { this.c = c; }
    
    @Override
    public void execute() { c.help(); }
}
class EchoCommand implements Command {
    Comp c;
    public EchoCommand(Comp c) { this.c = c; }
    
    @Override
    public void execute() { c.echo(); }
}
class DateCommand implements Command {
    Comp c;
    public DateCommand(Comp c) { this.c = c; }
    
    @Override
    public void execute() { c.date(); }
}
class ExitCommand implements Command {
    Comp c;
    public ExitCommand(Comp c) { this.c = c; }
    
    @Override
    public void execute() { c.exit(); }
}

// Reciver - получатель, приемник
class Comp{
    private String str;

    public void setStr(String str) { this.str = str; }
    
    void help(){ System.out.println("Help executed"); }
    void echo(){ System.out.println(str); }
    void date(){ System.out.println(System.currentTimeMillis()); }
    void exit(){ System.out.println("Goodbye!"); }
}

// Invoker (invoke - вызывать)
class User{
    private Command help;
    private Command echo;
    private Command date;
    private Command exit;

    public User(Command help, Command echo, Command date, Command exit) {
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