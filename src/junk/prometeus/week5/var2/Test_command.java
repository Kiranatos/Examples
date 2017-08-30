package junk.prometeus.week5.var2;

public class Test_command {

    public static void main(String[] args) {

        System.out.println("Test case: args == null");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(null);

        String[] app_args = new String[1];
        app_args[0] = null;
        System.out.println("\nTest case: args[0] == null");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args);

        app_args[0] = "";
        System.out.println("\nTest case: args[0]=\"\" is empty");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args);

        app_args[0] = "help";
        System.out.println("\nTest case: correct command help");
        System.out.println("Right answer: Help executed");
        System.out.print("Your answer: ");
        Application.main(app_args);

        app_args[0] = "echo";
        System.out.println("\nTest case: incorrect command echo");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args);

        app_args[0] = "date";
        System.out.println("\nTest case: incorrect command date");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args);
        
        app_args[0] = "exit";
        System.out.println("\nTest case: correct command exit");
        System.out.println("Right answer: Goodbye!");
        System.out.print("Your answer: ");
        Application.main(app_args);
        
        String[] app_args1 = new String[2];
        app_args1[0] = "help";
        app_args1[1] = "error";
        System.out.println("\nTest case: incorrect command help");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args1);
        
        app_args1[0] = "echo";
        app_args1[1] = "Bingo!";
        System.out.println("\nTest case: correct command echo");
        System.out.println("Right answer: Bingo!");
        System.out.print("Your answer: ");
        Application.main(app_args1);
        
        app_args1[1] = null;        
        System.out.println("\nTest case: correct command echo");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args1);
                
        app_args1[0] = "date";
        app_args1[1] = "now";
        System.out.println("\nTest case: correct command date");
        System.out.println("Right answer: " + System.currentTimeMillis());
        System.out.print("Your answer: ");
        Application.main(app_args1);

        app_args1[1] = "error";
        System.out.println("\nTest case: incorrect command date");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args1);
        
        app_args1[1] = null;
        System.out.println("\nTest case: incorrect command date");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args1);
        
        app_args1[0] = "exit";
        System.out.println("\nTest case: incorrect command exit");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args1);

        String[] app_args2 = new String[3];
        app_args2[0] = "help";
        app_args2[1] = "error";
        app_args2[2] = "error";
        System.out.println("\nTest case: incorrect command help");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args2);

        app_args2[0] = "echo";
        app_args2[1] = "Bingo!";
        System.out.println("\nTest case: incorrect command echo");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args2);

        app_args1[0] = "date";
        app_args1[1] = "now";
        System.out.println("\nTest case: incorrect command date");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args2);

        app_args1[1] = "error";
        System.out.println("\nTest case: incorrect command date");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args2);

        app_args1[0] = "exit";
        System.out.println("\nTest case: incorrect command exit");
        System.out.println("Right answer: Error");
        System.out.print("Your answer: ");
        Application.main(app_args2);       

    }

}


/*
Принятый код:


package com.tasks5.command;
public class Application {
    public static void main(String[] args){
            //YOUR CODE COMES HERE
            ReciverClass c = new ReciverClass();
            InvokerClass u = new InvokerClass(new HelpCommand(c), new EchoCommand(c), new DateCommand(c), new ExitCommand(c));
            
            if ( (args!=null)  && (args.length>0) && (args[0]!=null) )  {
                
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


package com.tasks5.command;
public class DateCommand implements Command {
    ReciverClass c;
    public DateCommand(ReciverClass c) { this.c = c; }
    
    @Override
    public void execute() { c.date(); }
}



package com.tasks5.command;
public class EchoCommand implements Command {
    ReciverClass c;
    public EchoCommand(ReciverClass c) { this.c = c; }
    
    @Override
    public void execute() { c.echo(); }
}



package com.tasks5.command;
public class ExitCommand implements Command {
    ReciverClass c;
    public ExitCommand(ReciverClass c) { this.c = c; }
    
    @Override
    public void execute() { c.exit(); }
}


package com.tasks5.command;
public class HelpCommand implements Command {
    ReciverClass c;
    public HelpCommand(ReciverClass c) { this.c = c; }
    
    @Override
    public void execute() { c.help(); }
}



package com.tasks5.command;
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


package com.tasks5.command;
public class ReciverClass {
    private String str;

    public void setStr(String str) { this.str = str; }
    
    void help(){ System.out.println("Help executed"); }
    void echo(){ System.out.println(str); }
    void date(){ System.out.println(System.currentTimeMillis()); }
    void exit(){ System.out.println("Goodbye!"); }
}

*/