/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books.sierra.mychat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerCleanChatButtonListener1 implements ActionListener {
    
    private ServerGUI gui;
    private ServerSocketDEEPER usd;

    @Override
    public void actionPerformed(ActionEvent e) {                
        gui.mainChatJTextArea.setText("");                
    }
    
    public void setGUI(ServerGUI gui)
    {
        this.gui = gui;
    }
    public void setServerSocketDEEPER(ServerSocketDEEPER usd)
    {
        this.usd = usd;
    }
    
}


