/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adapters;

import camera.CameraFrameListener;
import camera.IMage;
import graphics.panel.generalpanel.MyPanelModificated;
import javax.swing.JPanel;
import org.opencv.core.Mat;

/**
 *
 * @author aldajo
 */
public class AdapterMat4Panel{
    
    private JPanel myPanelImage;
    private IMage myIMage;

    public AdapterMat4Panel(JPanel myPanelImage, Mat frameVideo) {
        this.myPanelImage = myPanelImage;
        myIMage = new IMage(frameVideo);
        
        this.myPanelImage.add(myIMage);
        this.myPanelImage.setMinimumSize(myIMage.getSizeIM());
    }
    
    public static void adaptMat4Panel(JPanel panelImage, Mat frameVideo, IMage iMage){
        iMage.configureImage(frameVideo);
        panelImage.add(iMage);
    }
    
    public void refreshMatFrame4Image(Mat frameVideo){
        myIMage.configureImage(frameVideo);
    }
    
    public void refreshNewMatFrame4Image(Mat frameVideo){
        myIMage.setNewImageSize(frameVideo);
    }
    
}
