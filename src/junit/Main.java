package junit;

public class Main {
    public static int add(int a, int b) { return a+b; }
    public static int get(int index) { 
        int[] m = new int[] {10,11};
        return m[index]; 
    }
    
    public static void main(String[] args) {
        System.out.println(add(2,3));
        System.out.println(get(11));        
    }
}
