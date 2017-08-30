package junk;


/*
Game_Tanks
package tanks;
Display



*/


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display {
    
    public static void start (int width, int height, String title) {
        
        JFrame window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        Dimension size = new Dimension(width, height);
                
        window.setResizable(true);
        window.setMinimumSize(size);
        
        
        window.pack(); //Изменит размер окна, так чтобы он подходил под размер контента
        window.setLocationRelativeTo(null); //окно появляется по центру экрана
        window.setVisible(true);
        
        JPanel mPanel = new JPanel();
        mPanel.setLayout(new BorderLayout());
        
        window.getContentPane().add(mPanel, BorderLayout.CENTER);
        
        mPanel.add(new JButton("center"), BorderLayout.NORTH);
        mPanel.add(new JButton("center"), BorderLayout.WEST);
        mPanel.add(new JButton("center"), BorderLayout.CENTER);
        mPanel.add(new JButton("center"), BorderLayout.EAST);
        mPanel.add(new JButton("center"), BorderLayout.SOUTH);
    }
    
}
