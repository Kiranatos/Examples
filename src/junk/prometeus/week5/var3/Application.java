package junk.prometeus.week5.var3;

public class Application {
    public static void main(String[] args){
        
            if ( (args!=null) && (args.length>0) && (args[0]!=null) )  {
                
                if ( (args[0].equals("help")) && (args.length == 1) ) 
                    new HelpCommand().execute();
                else if ( (args[0].equals("exit")) && (args.length == 1) )
                    new ExitCommand().execute();
                else if ( (args[0].equals("echo")) && 
                          (args.length == 2) && 
                          (args[1]!=null) ) {                    
                    new EchoCommand(args[1]).execute();
                }
                else if ( (args[0].equals("date")) && 
                          (args.length == 2) && 
                          (args[1]!=null) &&
                          (args[1].equals("now"))  )
                    new DateCommand().execute();
                else System.out.println("Error");                
            }
            else System.out.println("Error");
	}
}
