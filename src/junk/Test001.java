package junk;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test001 {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("TEST");
        
        frame.setMinimumSize(new Dimension(800,600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("ddddddddddddddddddddddddddd");
        panel.add(label);        
        frame.setContentPane(panel);                
        frame.setVisible(true);
        frame.pack();
    }    
}
