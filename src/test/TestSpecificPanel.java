/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import graphics.frame.MyFrame;
import graphics.panel.specificpanel.PanelCameraButtons;

/**
 *
 * @author aldajo
 */
public class TestSpecificPanel {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame("Prueba");
        PanelCameraButtons pcb = new PanelCameraButtons();
        
        frame.add(pcb);
    }
}
