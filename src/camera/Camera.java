/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camera;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import values.MyMatImages;

/**
 *
 * @author aldajo
 */
public class Camera {

    private VideoCapture camera;
    private boolean isOpen = false, isVideo = false;
    private ArrayList<CameraFrameListener> usersCamera;
    private Thread thCamera;
    private ThreadCamera cameraStart;
    private Mat chargedImage;

    public Camera() throws InterruptedException {
        // Load the native library.
        usersCamera = new ArrayList<>();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Thread.sleep(1000);
    }
    
    public Mat loadImage(String address){
        chargedImage = Highgui.imread(address);
        MyMatImages.ImageOpenCVCharged = chargedImage;
        return chargedImage;
    }

    public void openCamera(int value) {
        if (!isOpen) {
            camera = new VideoCapture(value);
            camera.open(value); //Useless
            cameraStart = new ThreadCamera(camera, usersCamera);
            if (!camera.isOpened()) {
                System.out.println("Camera Error");
            } else {
                System.out.println("Camera OK?");
                isOpen = true;
            }
        }else{
            JOptionPane.showMessageDialog(null, "La camara ya esta encendida");
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void addCameraListener(CameraFrameListener user) {
        usersCamera.add(user);
    }

    public void startCameraVideo() {
        if (!isVideo) {
            //cameraStart = new ThreadCamera(camera, usersCamera);
            thCamera = new Thread(cameraStart);
            cameraStart.setFlag(true);
            thCamera.start();
            isVideo = true;
        } else {
            JOptionPane.showMessageDialog(null, "ya se esta capturando el video");
        }
    }

    public Mat getCapture() {
        if (isOpen) {
            Mat capture = new Mat();
            camera.read(capture);
            sendFrameUsers(capture);
            return capture;
        } else {
            JOptionPane.showMessageDialog(null, "La camara No está encendida");
            return null;
        }
    }

    public void stopCameraVideo() {
        cameraStart.setFlag(false);
        thCamera = null;
        isVideo = false;
    }

    public void closeCamera() {
        cameraStart = null;
        thCamera = null;
        camera.release();
        isOpen =false;
    }

    private void sendFrameUsers(Mat frame) {
        for (CameraFrameListener u : usersCamera) {
            u.onFrameCapture(frame);
        }
    }
    //crear un método para cargar una imagen
}
