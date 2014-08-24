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
public class IPColorReduce extends ImageProccessingFrame{

    public IPColorReduce() {
        super("Color Reduce");
    }

    @Override
    public Mat ProccessImageOpenCV(Mat frame) {
        return ImageProccessingMethods.colorReduce(frame, 86);
    }
    
}
