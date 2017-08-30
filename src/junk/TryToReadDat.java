package junk;

/**
 * Класс для тестирования MullerWordsmanager
 */


import res.MullerWordsManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryToReadDat {
    public static void main(String[] args) throws FileNotFoundException {
        
        //MullerWordsManager.createMullerFile("F:\\words.txt");
        
        
        MullerWordsManager mw = MullerWordsManager.getMuller();        
        MullerWordsManager mw2 = MullerWordsManager.getMuller();        
        MullerWordsManager mw3 = MullerWordsManager.getMuller();        
        
        
        
        
        String[] s = mw.getWordsStringArray();
        System.out.println("s = " + s.length);
        MullerWordsManager mw4 = MullerWordsManager.getMuller();        
        
        System.out.println("Singlton total = " + MullerWordsManager.totalSingltonObject);
        System.out.println(" = " + mw.getPath());
        System.out.println(" = " + mw.getQuantityOfWords());
        for (int i=0; i<5; i++)
            System.out.print(" = " + mw.getRandomWord());
        //System.out.println(" = " + mw.toString());
        
        
          
        
    }
}
