package appletssimple;

import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class AppletsSimple extends JApplet {    
    String input;

    @Override
    public void destroy() { super.destroy(); }
    @Override
    public void stop() { super.stop(); }
    @Override
    public void start() { super.start(); }
    
    @Override
    public void init() {
        input = JOptionPane.showInputDialog("Enter your text");
    }
    
    @Override
    public void paint (Graphics g)
    {
        super.paint(g);
        g.drawString("This: " + input, 25, 25);
        g.drawLine(10, 30, 210, 30);
        g.drawLine(15, 50, 210, 30);        
    }
}
/*
public void init()
public void start()
public void paint(Graphics g)
public void stop()
public void destroy()
*/