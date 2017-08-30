package junk.font;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class WindowTest {
    
    public static void main(String[] args) throws FontFormatException, IOException {
        final JFrame jf = new JFrame("barra");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pa = new JPanel(new GridLayout(0, 1));
        JLabel lab_1 = new JLabel("Гравитационные волны");
        JLabel lab_2 = new JLabel("Гравитационные волны");
        JLabel lab_3 = new JLabel("Гравитационные волны");
        JLabel lab_4 = new JLabel("Гравитационные волны");
        
        // используем стандартные шрифты: в первом случае логический шрифт, а во втором физический.
        // обратите внимание, что на картинке они выглядят одинаково
        lab_1.setFont(new Font("Serif", Font.PLAIN, 24));
        lab_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        //теперь пробуем загрузить шрифт из внешнего файла        
        Font f_ye = Font.createFont(Font.TRUETYPE_FONT, new File("F:\\Teddy_Bear.ttf"));
        lab_3.setFont(f_ye.deriveFont(Font.PLAIN, 24.0f));
        // и еще один шрифт из внешнего файла
        Font f_inv = Font.createFont(Font.TRUETYPE_FONT,new File("F:\\Teddy_Bear.ttf"));
        lab_4.setFont(f_inv.deriveFont(Font.PLAIN, 24.0f));
        
        // получим и выведем в виде JComboBox список всех шрифтов
        pa.add(new JLabel("getAllFonts"));
        Font [] allFonts = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        pa.add(new JComboBox(allFonts));
        pa.add(new JLabel("count fonts = "+ allFonts.length));
        // список названий всех шрифтов доступных для текущей локали
        pa.add(new JLabel("getAvailableFontFamilyNames"));
        String [] locFontNames = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        pa.add(new JComboBox(locFontNames));
        pa.add(new JLabel("count fonts = "+ locFontNames.length));
        pa.add(lab_1);
        pa.add(lab_2);
        pa.add(lab_3);
        pa.add(lab_4);
        jf.setContentPane(pa);
        jf.pack();
        
        SwingUtilities.invokeLater( new  Runnable(){ 
            public void run(){
            jf.setVisible(true);
            }
        });
        
    }
    
    public static Font getFont() {
        Font font = null;    
        String fName = "F:\\Teddy_Bear.ttf";
        try {
            //InputStream is = WindowTest.class.getResourceAsStream(fName);            
          //  InputStreamReader is = new InputStreamReader(new FileInputStream(fName));
            //BufferedReader r = new BufferedReader(is);
           
            //InputStream is2 = new ByteArrayInputStream(r);
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))

            //font = Font.createFont(Font.TRUETYPE_FONT, is);
            font = Font.createFont(Font.TRUETYPE_FONT, new File(fName));
            
            System.out.println(font);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(fName + " not loaded.  Using serif font.");
            font = new Font("serif", Font.PLAIN, 24);
        }
        return font;
  }
    
}
 /*       JFrame window = new JFrame("Test");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        Dimension size = new Dimension(800, 600);
                
        window.setResizable(true);
        window.setMinimumSize(size);
        
        
        
        
        JPanel mPanel = new JPanel();
        mPanel.setLayout(new BorderLayout());
        
        JLabel jL = new JLabel("north 1");
        jL.setBackground(Color.RED);
        jL.setForeground(Color.BLUE);
        jL.setFont(WindowTest.getFont());
        jL.setSize(80, 60);
        jL.setMinimumSize(new Dimension(50,50));
        mPanel.add(jL, BorderLayout.NORTH);
        
        mPanel.add(new JButton("center"), BorderLayout.WEST);        
        mPanel.add(new JButton("center"), BorderLayout.CENTER);
        mPanel.add(new JButton("center"), BorderLayout.EAST);
        mPanel.add(new JButton("center"), BorderLayout.SOUTH);
        
        window.getContentPane().add(mPanel, BorderLayout.CENTER);
        
        
        window.pack(); //Изменит размер окна, так чтобы он подходил под размер контента
        window.setLocationRelativeTo(null); //окно появляется по центру экрана
        window.setVisible(true);*/