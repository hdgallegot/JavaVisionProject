/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import imageproccessingOpenCV.ImageProccessingFrame;
import javax.swing.JSlider;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

/**
 *
 * @author aldajo
 */
public class TestProccessingFrame {
    public static void main(String[] args) {
         System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
         Mat image_tmp = Highgui.imread("img/img2.jpg");
         ImageProccessingFrame pi = new ImageProccessingFrame("Example");
         pi.addComponentSout(new JSlider());
         pi.displayImageProccessed(image_tmp);
    }
}
