package junk;

/**
 * Класс для считывания и сплита слов
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryToRead {
    public static void main(String[] args) throws FileNotFoundException {
        String[] str = null;
        Scanner file = new Scanner(new File("F:\\words.txt"));
        while ( file.hasNextLine() ) {  
            String inLine = file.nextLine();
            str = inLine.split(" ");
            System.out.println(" length = " + str.length);            
        }
        file.close();
        
        //MullerWords mw = new MullerWords(str);
    }
}
