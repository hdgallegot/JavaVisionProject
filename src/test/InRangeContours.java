/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import values.MyBooleans;
import values.MyIntegers;

/**
 *
 * @author aldajo
 */
public class InRangeContours {
    
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture camera =  new VideoCapture(1);
        Mat framevideo = new Mat();
        Mat preproceced = new Mat();
        camera.open(1);
        camera.read(framevideo);
        Highgui.imwrite("image.png", framevideo);
        preproceced = preproc(framevideo);
        Highgui.imwrite("imageInRange.png", preproceced);
        Highgui.imwrite("imageContours.png", findContours(framevideo));
    }
    
    public static Mat preproc(Mat frame) {
        Mat preprosMat = new Mat();
        
        Imgproc.cvtColor(frame, preprosMat, Imgproc.COLOR_RGB2HSV);
        
        Core.inRange(frame, new Scalar(242, 228,103),
                new Scalar(255, 255, 255), preprosMat);

        return preprosMat;
    }
    
    public static Mat findContours(Mat frame) {

        Mat contoursMat = preproc(frame);

        Mat result = new Mat(contoursMat.size(), CvType.CV_8U, new Scalar(255));
        List<MatOfPoint> contours = new ArrayList<>();
        List<MatOfPoint> contoursGeneral = new ArrayList<>();
        Imgproc.findContours(contoursMat, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
        
        for(int i = 0; i < contours.size(); i++){
            double area = Imgproc.contourArea(contours.get(i));
            if(MyBooleans.flag){
                System.out.println(area);
            }           
            if(area < 2000 || area > 4200){
                contours.remove(i);
            }else if(area > 2000 && area < 4200){
                contoursGeneral.add(contours.get(i));
            }
        }
//        
        Imgproc.drawContours(result, contoursGeneral, -1, new Scalar(0), 2);
//         
//         //centros de masa
//         for(int i = 0; i < contoursGeneral.size(); i++){
//             Moments mom = Imgproc.moments(contoursGeneral.get(i));
//             Core.circle(result, 
//                     new Point(mom.get_m10()/mom.get_m00(), mom.get_m01()/mom.get_m00()), 
//                     2, new Scalar(80),2);
//         }
         
        
        Rect r0;
        for (int i = 0; i < contours.size(); i++) {
            r0 = Imgproc.boundingRect(contours.get(i));
            Core.rectangle(result, r0.tl(), r0.br(), new Scalar(0, 250, 0), 2);
        }
//        Rect r0 = Imgproc.boundingRect(contours.get(0));
//        Core.rectangle(result, r0.tl(), r0.br(), new Scalar(20), 2);

        return result;
    }
}
