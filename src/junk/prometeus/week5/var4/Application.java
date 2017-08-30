package junk.prometeus.week5.var4;

public class Application {
    public static void main(String[] args){
        
            if ( (args!=null) && (args.length>0) && (args[0]!=null) )  {
                
                if ( (args[0].equals("help")) && (args.length == 1) ) 
                    new Command() {
                        @Override
                        public void execute() { System.out.println("Help executed"); }
                    }.execute();
                
                else if ( (args[0].equals("exit")) && (args.length == 1) )
                    new Command() {
                        @Override
                        public void execute() { System.out.println("Goodbye!"); }
                    }.execute();
                
                else if ( (args[0].equals("echo")) && 
                          (args.length == 2) && 
                          (args[1]!=null) ) {                    
                    new Command() {
                        @Override
                        public void execute() { System.out.println(args[1]); }
                    }.execute();
                }
                
                else if ( (args[0].equals("date")) && 
                          (args.length == 2) && 
                          (args[1]!=null) &&
                          (args[1].equals("now"))  )
                    new Command() {
                        @Override
                        public void execute() { System.out.println(System.currentTimeMillis()); }
                    }.execute();
                
                else System.out.println("Error");                
            }
            else System.out.println("Error");
	}
}
