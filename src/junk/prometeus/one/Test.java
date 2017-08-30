package junk.prometeus.one;

public class Test {
    
    public static void main(String[] args) {
        LinkedList L = new LinkedList();
        
        L.add(5);   //0
        L.add(12);  //1
        L.add(Integer.valueOf(13));  //2
        L.add(new Integer(14));  //3
        L.add(Integer.SIZE);  //4
        L.add(Integer.MIN_VALUE);  //5
        L.add(Integer.MAX_VALUE);  //6
        L.add(Integer.BYTES);  //7        
        L.add(22);  //8
        L.add(22);  //9
        
        System.out.println("\nSIZE: " + L.size());
        for (int i = -1; i< 11; i++ )
            System.out.print(" #"+i + "=" + L.get(i));
        
        L.add(100);
        
        System.out.println("\nSIZE: " + L.size());                
        for (int i = -1; i< L.size() + 1; i++ )
            System.out.print(" #"+i + "=" + L.get(i));
        
        
        System.out.print("\n" + L.delete(10));
        
        System.out.println("\nSIZE: " + L.size());                
        for (int i = -1; i< L.size() + 1; i++ )
            System.out.print(" #"+i + "=" + L.get(i));        
    }    
}
