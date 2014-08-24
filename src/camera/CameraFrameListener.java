/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camera;

import org.opencv.core.Mat;

/**
 *
 * @author aldajo
 */
public interface CameraFrameListener {
    
    void onFrameCapture(Mat frame);

    
}
