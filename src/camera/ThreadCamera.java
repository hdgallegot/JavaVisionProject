/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camera;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

/**
 *
 * @author aldajo
 */
public class ThreadCamera implements Runnable {

    private VideoCapture camera;
    private ArrayList<CameraFrameListener> usersCamera;
    private Mat frameVideo;
    private boolean flag = true;

    public ThreadCamera(VideoCapture camera, ArrayList<CameraFrameListener> usersCamera) {
        this.camera = camera;
        this.usersCamera = usersCamera;
        frameVideo = new Mat();
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        JOptionPane.showMessageDialog(null, "Se activará la cámara");

        while (true) {

            if (flag) {
                camera.read(frameVideo);
                for (CameraFrameListener u : usersCamera) {
                    u.onFrameCapture(frameVideo);
                }
            }else{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadCamera.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }

        }

    }
}
