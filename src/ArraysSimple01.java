import java.util.Arrays;

public class ArraysSimple01 {
    public static void main(String[] args) {
        /** 
         * int[][] a = new int[Y][X];
         * [0][0] , [0][1] , [0][2] , [0][3] , [0][4] ,
         * [1][0] , [1][1] , [1][2] , [1][3] , [1][4] ,
         * [2][0] , [2][1] , [2][2] , [2][3] , [2][4] ,
         */        
        int[][] a = new int[3][5]; // прямоугольный массив
        int size1 = a.length;
        int size2 = a[0].length;
        int[][] b = new int[3][]; // массив переменной длины (тут - треугольный)
        b[0] = new int[1];
        b[1] = new int[2];
        b[2] = new int[3];
        int c[] = new int[] {1,2,3,};
        c = new int[]{0,1,2,3}; // а вот так не сработает: c = {0,1,2,3};
        
        int[] array1D= {0,1,2,3};        
        int[][] array2D= {{0,1,5,10},{2,3,1,0,5,55,16},{0,1}};
        int[][][] array3D= {
            {   {2,3,1,0},
                {2,3,1,0},
                {2,3,1,0}},
            
            {   {2,3,1,0},
                {2,3,1,0},
                {2,3,1,0}},
            
            {   {2,3,1,0},
                {2,3,1,0},
                {2,3,1,0}}};
        System.out.println("============array1D==========");
        System.out.println(array1D);
        System.out.println(Arrays.toString(array1D)); //Работает на глубину одного измерения (для одномерных масивов)
        System.out.println("============array2D==========");
        System.out.println(array2D);
        System.out.println(Arrays.toString(array2D)); 
        System.out.println(Arrays.deepToString(array2D));
        System.out.println("============array3D==========");
        System.out.println(array3D);
        System.out.println(Arrays.toString(array3D));
        System.out.println(Arrays.deepToString(array3D));
    }
}