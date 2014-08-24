/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproccessingOpenCV;

import adapters.AdapterMat4Panel;
import camera.IMage;
import graphics.frame.MyFrame;
import graphics.panel.generalpanel.MyPanelModificated;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import org.opencv.core.Mat;

/**
 *
 * @author aldajo
 */
public class ImageProccessingFrameTabs extends MyFrame{
    
    private Mat[] myMats;
    private MyPanelModificated[] myOpenCVPanel;
    private IMage imgIMage[];
    private JTabbedPane myTabs;
    
    public ImageProccessingFrameTabs(String title, String[] namesPanels) {
        super(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myOpenCVPanel = new MyPanelModificated[namesPanels.length];
        imgIMage = new IMage[namesPanels.length];
        myTabs = new JTabbedPane();
        for (int i = 0; i < myOpenCVPanel.length; i++) {
             myOpenCVPanel[i] = new MyPanelModificated();
             myTabs.add(namesPanels[i], myOpenCVPanel[i]);
             imgIMage[i] = new IMage();
        }
        add(myTabs);
    }
    
    public Mat[] ProccessImagesOpenCV(Mat frame){
        Mat[] thFrames = new Mat[myOpenCVPanel.length];
        for(int i=0; i<thFrames.length; i++){
            thFrames[i] = frame;
        }
        return thFrames;
    }
    
    public void displayImageProccessed(Mat frame){
        Mat thempMat = frame.clone();
        myMats = ProccessImagesOpenCV(thempMat);
        
        for(int i=0; i<myOpenCVPanel.length; i++){
            AdapterMat4Panel.adaptMat4Panel(myOpenCVPanel[i], myMats[i], imgIMage[i]);
        }
    }
    
}
