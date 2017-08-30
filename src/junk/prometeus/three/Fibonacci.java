package junk.prometeus.three;

public class Fibonacci {
    
    public long getNumber(int position){
        if (position ==1) return 1L;
        else if (position ==2) return 1L;
        else if (position < 1) return -1;
        else
            return (long)(new Fibonacci().getNumber(position-1) + new Fibonacci().getNumber(position-2));
        
        
        
    }
    
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        for (int i = -3; i<10; i++)
            System.out.println(f.getNumber(i));
    }
}
