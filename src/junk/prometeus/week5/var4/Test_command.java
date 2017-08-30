package junk.prometeus.week5.var4;

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
