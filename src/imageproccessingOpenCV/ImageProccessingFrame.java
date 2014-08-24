/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproccessingOpenCV;

import adapters.AdapterMat4Panel;
import camera.IMage;
import graphics.frame.MyFrame;
import graphics.panel.generalpanel.MyPanelModificated;
import java.awt.BorderLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import org.opencv.core.Mat;

/**
 *
 * @author aldajo
 */
public class ImageProccessingFrame extends MyFrame {

    private Mat myMat;
    private MyPanelModificated myOpenCVPanel;
    private IMage imgIMage;
    
    public ImageProccessingFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myOpenCVPanel = new MyPanelModificated();
        imgIMage = new IMage();
        getContentPane().setLayout(new BorderLayout());
        add(myOpenCVPanel,BorderLayout.CENTER);
    }
    
    public Mat ProccessImageOpenCV(Mat frame){
        return frame;
    }
    
    public void displayImageProccessed(Mat frame){
        Mat thempMat = frame.clone();
        myMat = ProccessImageOpenCV(thempMat);
        AdapterMat4Panel.adaptMat4Panel(myOpenCVPanel, myMat, imgIMage);
    }
    
    public void addComponentSout(JComponent comp){
        add(comp,BorderLayout.SOUTH);
    }
    
}
