/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import adapters.AdapterMat4Panel;
import graphics.frame.MyFrame;
import graphics.panel.generalpanel.MyPanelModificated;
import javax.swing.JPanel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

/**
 *
 * @author aldajo
 */
public class TestAdapterMat4Panel {
    public static void main(String[] args) {
         System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
         Mat image_tmp = Highgui.imread("img/img2.jpg");
         MyFrame frame = new MyFrame("HI");
         MyPanelModificated panel = new MyPanelModificated();
         AdapterMat4Panel am4p = new AdapterMat4Panel(panel, image_tmp);
         frame.add(panel);
    }
}
