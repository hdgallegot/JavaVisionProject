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
public class IPDetectSquares extends ImageProccessingFrame{

    public IPDetectSquares(String title) {
        super(title);
    }
    
    @Override
    public Mat ProccessImageOpenCV(Mat frame) {
        return ImageProccessingMethods.findContours(frame);
    }
    
}
