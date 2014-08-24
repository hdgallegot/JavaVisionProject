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
public class IPBlueChannels extends ImageProccessingFrame{

    public IPBlueChannels() {
        super("IPBLueChannel");
    }
    
    @Override
    public Mat ProccessImageOpenCV(Mat frame) {
        return ImageProccessingMethods.blueChannel(frame);
    }
    
}
