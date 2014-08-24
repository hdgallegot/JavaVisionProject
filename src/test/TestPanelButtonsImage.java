/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import adapters.AdapterMat4Panel;
import graphics.frame.MyFrame;
import graphics.panel.generalpanel.MyPanelButtons;
import graphics.panel.generalpanel.MyPanelModificated;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

/**
 *
 * @author aldajo
 */
public class TestPanelButtonsImage {
    public static void main(String[] args) {
         System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
         Mat image_tmp = Highgui.imread("img/img2.jpg");
         MyFrame frame = new MyFrame("HI");
         MyPanelModificated panel = new MyPanelModificated();
         AdapterMat4Panel am4p = new AdapterMat4Panel(panel, image_tmp);
         
         JPanel panelframe = new JPanel();
         
         panelframe.setLayout(new BorderLayout());
         panelframe.add(panel, BorderLayout.CENTER);
         
         MyPanelButtons pButtons = new MyPanelButtons();
         panelframe.add(pButtons, BorderLayout.SOUTH);
         
         frame.add(panelframe);
    }
}