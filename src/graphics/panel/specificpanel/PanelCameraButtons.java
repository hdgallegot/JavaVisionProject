/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.panel.specificpanel;

import graphics.panel.generalpanel.MyLateralButtons;
import graphics.panel.generalpanel.MyPanelButtons;
import graphics.panel.generalpanel.MyPanelModificated;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import values.MyColors;

/**
 *
 * @author aldajo
 */
public class PanelCameraButtons extends JPanel{

    private MyPanelButtons panelButtons;
    private MyPanelModificated panelCamera;
    private MyLateralButtons panelLateralButtons;
    
    public PanelCameraButtons() {
        initComponents();
    }
    
    private void initComponents(){
        panelButtons = new MyPanelButtons();
        panelCamera = new MyPanelModificated();
        panelLateralButtons = new MyLateralButtons();
        
        setBackground(MyColors.frameColor);
        setLayout(new BorderLayout());
        add(panelCamera, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);
        add(panelLateralButtons, BorderLayout.WEST);
    }

    public MyPanelModificated getPanelCamera() {
        return panelCamera;
    }

    public MyPanelButtons getPanelButtons() {
        return panelButtons;
    }

    public MyLateralButtons getPanelLateralButtons() {
        return panelLateralButtons;
    }
    
}
