/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import imageproccessingOpenCV.IPColorChannels;
import imageproccessingOpenCV.ImageProccessingFrameTabs;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import values.MyStrings;

/**
 *
 * @author aldajo
 */
public class TestProccessingFrameTabs {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
         Mat image_tmp = Highgui.imread("img/img2.jpg");
         ImageProccessingFrameTabs pi = new ImageProccessingFrameTabs("Example", MyStrings.channelsNames);
         pi.displayImageProccessed(image_tmp);
         
         IPColorChannels colorChannels = new IPColorChannels("Example2", MyStrings.channelsNames);
         colorChannels.displayImageProccessed(image_tmp);
    }
}
