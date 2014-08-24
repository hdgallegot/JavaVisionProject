/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

/**
 * @author aldajo
 */
public class SingleCameraCapture {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture camera =  new VideoCapture(1);
        Mat framevideo = new Mat();
        camera.open(1);
        camera.read(framevideo);
        Highgui.imwrite("image.png", framevideo);
    }
}
