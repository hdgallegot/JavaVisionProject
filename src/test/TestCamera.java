/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import camera.Camera;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aldajo
 */
public class TestCamera {
    public static void main(String[] args) {
        try {
            Camera cam = new Camera();
            cam.openCamera(0);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(TestCamera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
