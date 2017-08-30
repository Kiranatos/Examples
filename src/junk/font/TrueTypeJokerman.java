package junk.font;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TrueTypeJokerman extends JFrame {

  private String textMessage = "Java Internationalization";

  public TrueTypeJokerman() {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    ge.getAllFonts();

    Font font = new Font("Jokerman", Font.PLAIN, 35);
    JLabel textLabel = new JLabel(textMessage);
    textLabel.setFont(font);

    getContentPane().add(textLabel);
    setVisible(true);
  }

  public static void main(String[] args) {
    JFrame frame = new TrueTypeJokerman();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}