/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openCVTools;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import org.opencv.core.Core;
import org.opencv.core.Mat;

/**
 *
 * @author aldajo
 */
public class Splitting {
    
    public static List<Mat> spliting(Mat v){
        List<Mat> rgb;
        rgb = new ArrayList<>();
        Core.split(v, rgb);
        return rgb;
    }
}
