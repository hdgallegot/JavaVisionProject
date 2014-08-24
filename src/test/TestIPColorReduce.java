/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import imageproccessingOpenCV.IPColorReduce;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

/**
 *
 * @author aldajo
 */
public class TestIPColorReduce {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
         Mat image_tmp = Highgui.imread("img/img2.jpg");
        IPColorReduce ip = new IPColorReduce();
        ip.displayImageProccessed(image_tmp);
    }
}
