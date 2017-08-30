package junk.prometeus.week5.var2;

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
