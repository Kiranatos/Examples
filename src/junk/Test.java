package junk;

import java.io.*;
import java.util.*;

public class Test {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        
        ArrayList<String> list = new ArrayList<>(); 
        int n=-1;
        int size=-1;
        boolean flag = true;
        for (int i = 0; i<10; i++) {
            String s = reader.readLine();
            if (flag) {
                if (s.length()>=size) {
                    size = s.length();
                } else {
                    flag = false;
                    n=i;
                }          
            }  
            list.add(s);
        }
        if (n>-1) System.out.println(n);        
    }
    
}
