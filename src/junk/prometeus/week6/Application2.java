package junk.prometeus.week6;

public class Application2 {
    
    public static void main(String[] args) {
        String str = "2v3z";//args[0];
        if (str.length() > 1) {           
            
            StringBuilder sb = new StringBuilder();
            char[] c = str.toCharArray();            
            boolean fail = false;
            int k=1;
            for(int i=0; i<c.length; i++) {                
                
                if ( (i>0) && (c[i]==c[i-1])) { fail = true; }
                
                
                if (Character.isDigit(c[i])) {
                    
                    if ((i==0) || 
                            (Character.isDigit(c[i-1])) ||
                            (Character.getNumericValue(c[i]) == 1) ||
                            (Character.getNumericValue(c[i]) == 0) ) { fail = true; break;}
                    
                    k = Character.getNumericValue(c[i]);                    
                    while(k > 1) {
                        sb.append(c[i-1]);
                        k--;                        
                    }
                    
                } else { sb.append(c[i]); }
            }
            
            
            if (fail) str = "Fail";
            else 
                str = sb.toString();
        
        
        }        
        System.out.println(str);
    }
    
}


/*
  //ok
Application.main(new String[] {"Hh9h3e4l2o5"}); //Hhhhhhhhhhhhhheeeellooooo
Application.main(new String[] {"Xv2z3"}); //Xvvzzz
Application.main(new String[] {"#3b2a7og2"}); //###bbaaaaaaaogg
Application.main(new String[] {" 5r8*3_m%"}); //     rrrrrrrr***_m%
Application.main(new String[] {"H+9!"}); //H+++++++++!
Application.main(new String[] {"?!@#$%^&*()_+{}{}{}!"}); //?!@#$%^&*()_+{}{}{}!
                                                           ?!@#$%^&*()_+{}{}{}!
Application.main(new String[] {"weret"}); //weret
Application.main(new String[] {","}); //,
Application.main(new String[] {"."});//.
Application.main(new String[] {"Hh9h3"});//Hhhhhhhhhhhhh
                                           Hhhhhhhhhhhhh
Application.main(new String[] {"e4l2o5"});//eeeellooooo
                                            eeeellooooo
Application.main(new String[] {"f3k2z"});//fffkkz
Application.main(new String[] {"f3k"});//fffk
Application.main(new String[] {"f"});//f

//err ->""
Application.main(new String[] {"9f4t5"});
Application.main(new String[] {"H195x"}); 
Application.main(new String[] {"1h9h3e4l2o5"}); 
Application.main(new String[] {"h9hh6"}); 
Application.main(new String[] {"aaa"});
Application.main(new String[] {"Hh90helo"});
Application.main(new String[] {"2v3z"});
Application.main(new String[] {"v1d2"});
Application.main(new String[] {"v0d2"});
Application.main(new String[] {"Hhhhhhhhhhhhhheeeellooooo"});
Application.main(new String[] {"null"});
Application.main(new String[] {"null"});
Application.main(new String[] {""});
Application.main(new String[] {"Hh9h3","e4l2o5"});
*/