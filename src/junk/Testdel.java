package junk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testdel {
    
    public static void main(String[] args) {
        int a = 0;
        String word = "\\bworld\\b";
        Pattern w = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        
            String str = "khdfgdsg, world fdlkfs world klsdfjslkdf world";
            Matcher m = w.matcher(str);
            while (m.find())
            {
                int k = m.start();
                System.out.println(k);
                a++;
            }
        
        System.out.println(a);
        
    }
    
}
