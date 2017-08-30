package junk.buffer;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

/**
 * Тест работы Буфера обмена
 */
public class ClipboardTest {
    
    // This method writes a string to the system clipboard.
    // otherwise it returns null.
    public static void setClipboard(String str) {
        StringSelection ss = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    }
    
    public static void main(String[] args) {
        String testText = "Тестовая строка для копирования в буфер обмена";
        
        ClipboardTest.setClipboard(testText);
    }
}
