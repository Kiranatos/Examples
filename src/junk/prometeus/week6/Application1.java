package junk.prometeus.week6;

public class Application1 {
    
    public static void main(String[] args) {
        String str = "Hhhhhhhhhhhhhheeeelloooooooooooo";

        if (str.length() > 1) {
            StringBuilder sb = new StringBuilder();
            char[] c = str.toCharArray();
            char check = c[0];
            int k=1;
            for(int i=1; i<c.length; i++) {
                
                if (k==9) {
                    sb.append(check).append(k);
                    k=1;
                }
                else if (c[i]==check) { k++; }                
                else {                
                    sb.append(check);
                    if (k>1) sb.append(k);
                    check = c[i];       
                    k=1;
                }            
                
                if (i == c.length-1) { 
                    sb.append(c[i]); 
                    if (k>1) sb.append(k);
                }
            }
            
            str = sb.toString();
        }
        
        System.out.println(str);
    }
    
}
