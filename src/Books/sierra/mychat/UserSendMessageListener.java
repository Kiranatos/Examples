/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books.sierra.mychat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserSendMessageListener implements ActionListener {
    
    private UserGUI gui;
    private UserSocketDEEPER usd;

    @Override
    public void actionPerformed(ActionEvent e) {        
        String m = gui.mainMessageJTextArea.getText();        
        //gui.mainChatJTextArea.setText(m);
        usd.newUserMessage(m);
        //gui.mainChatJTextArea.append("\nRender: " + m);
        gui.mainMessageJTextArea.setText("");
    }
    
    public void setGUI(UserGUI gui)
    {
        this.gui = gui;
    }
    public void setUserSocketDEEPER(UserSocketDEEPER usd)
    {
        this.usd = usd;
    }
    
}


