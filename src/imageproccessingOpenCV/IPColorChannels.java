/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproccessingOpenCV;

import org.opencv.core.Mat;

/**
 *
 * @author aldajo
 */
public class IPColorChannels extends ImageProccessingFrameTabs{

    public IPColorChannels(String title, String[] namesPanels) {
        super(title, namesPanels);
    }

    @Override
    public Mat[] ProccessImagesOpenCV(Mat frame) {
        return ImageProccessingMethods.colorChannels(frame);
    }
    
}
