/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import values.MyIntegers;

/**
 *
 * @author aldajo
 */
public class InRange {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture camera =  new VideoCapture(0);
        Mat framevideo = new Mat();
        camera.open(0);
        camera.read(framevideo);
        Highgui.imwrite("image.png", framevideo);
        Highgui.imwrite("imageInRange.png", preproc(framevideo));
    }
    
    public static Mat preproc(Mat frame) {
        Mat preprosMat = new Mat();
        
        Imgproc.cvtColor(frame, preprosMat, Imgproc.COLOR_RGB2HSV);
        
        Core.inRange(frame, new Scalar(242, 228,103),
                new Scalar(255, 255, 255), preprosMat);

        return preprosMat;
    }
}
