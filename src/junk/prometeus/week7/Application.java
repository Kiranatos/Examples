package junk.prometeus.week7;

import java.util.Deque;
import java.util.LinkedList;

public class Application {    

	public static double parse(String rpnString) {
            
            //System.out.println(" ------[" + rpnString + "]------ ");
            String[] sM = rpnString.split(" ");
            Deque dequeA = new LinkedList();
            double result = 0.0;
            
            try {
                for (int i=0; i<sM.length; i++) {
                    switch (sM[i]) {
                        case "+" : 
                            dequeA.push((double)dequeA.pop() + (double)dequeA.pop());
                            //System.out.println("[+]"); 
                            break;
                        case "-" : 
                            double dm2 = (double)dequeA.pop();
                            double dm1 = (double)dequeA.pop();
                            dequeA.push(dm1-dm2);
                            //System.out.println("[-]"); 
                            break;
                        case "*" : 
                            dequeA.push( (double)dequeA.pop() * (double)dequeA.pop() );
                            //System.out.println("[*]"); 
                            break;
                        case "/" : 
                            double dd2 = (double)dequeA.pop();
                            double dd1 = (double)dequeA.pop();
                            if (dd2 == 0.0) throw new ArithmeticException();
                            dequeA.push(dd1/dd2);
                            //System.out.println("[/]");                            
                            break;
                        default :
                            dequeA.push(Double.parseDouble(sM[i]));                           
                            break;
                    }
                }                
            } 
            catch (ArithmeticException e) { throw new ArithmeticException(); }
            catch (Exception e) { throw new RPNParserException(); }                                    
            
            if (dequeA.size() == 1) result = (double)dequeA.pop();
            else throw new RPNParserException();
            
            return result;		
	}

        
        
        
        
        
        
        
        
        
	public static void main(String[] args) {
            
            System.out.println("RESULT: " + Application.parse("10 20 +")); //30
            System.out.println("RESULT: " + Application.parse("10 20 + 30 40 + *")); //2100
            System.out.println("RESULT: " + Application.parse("10 20 30.0 * +")); //610
            System.out.println("RESULT: " + Application.parse("12 2 3 4 * 10 5 / + * +")); //40
            
            //System.out.println(Application.parse("10 20 30 () +")); // RPNParserException 
            //System.out.println(Application.parse("10 20 Е * +")); // RPNParserException 
            //System.out.println(Application.parse("0 0 /")); //ArithmeticException   
	}
}

