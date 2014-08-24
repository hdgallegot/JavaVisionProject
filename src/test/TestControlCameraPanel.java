/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import camera.Camera;
import controllers.ControlCameraPanel;
import controllers.ControlImageProccesingButtons;
import graphics.frame.MyFrame;
import graphics.panel.generalpanel.MyPanelButtons;
import graphics.panel.generalpanel.MyPanelModificated;
import graphics.panel.specificpanel.PanelCameraButtons;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aldajo
 */
public class TestControlCameraPanel {

    public static void main(String[] args) {
        Camera cam;
        try {
            cam = new Camera();
            MyFrame frame = new MyFrame("Prueba");
            PanelCameraButtons pcb = new PanelCameraButtons();
            frame.add(pcb);
            //Con este objeto los controlo
            ControlCameraPanel controlcp = new ControlCameraPanel(pcb.getPanelButtons(), pcb.getPanelCamera(), cam);
            ControlImageProccesingButtons cimpb = new ControlImageProccesingButtons(pcb.getPanelLateralButtons(), controlcp.getM4p());
            cam.addCameraListener(cimpb);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(TestControlCameraPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
