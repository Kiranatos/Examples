/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books.sierra.mychat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerSendFileListener implements ActionListener {
    
    private ServerGUI gui;
    ServerSocketDEEPER ssd;

    @Override
    public void actionPerformed(ActionEvent e) {        
        String m = gui.textField.getText();
        ssd.newServerFileUpload(m);        
    }
    
    public void setGUI(ServerGUI gui)
    {
        this.gui = gui;
    }
    public void setServerSocketDEEPER(ServerSocketDEEPER ssd)
    {
        this.ssd = ssd;
    }
    
}
