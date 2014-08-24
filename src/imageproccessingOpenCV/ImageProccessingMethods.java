/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproccessingOpenCV;

import java.util.ArrayList;
import java.util.List;
import openCVTools.Splitting;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;
import values.MyBooleans;
import values.MyIntegers;

/**
 *
 * @author aldajo
 */
public class ImageProccessingMethods {

    public static Mat colorReduce(Mat frame, int div) {

        int nl = frame.rows();
        int nc = frame.cols();
        double[] pixelVal = {0, 0, 0};
        for (int j = 0; j < nl; j++) {
            for (int i = 0; i < nc; i++) {
                pixelVal = frame.get(j, i);
                for (int c = 0; c < 3; c++) {
                    pixelVal[c] = (int) pixelVal[c] / div * div + div / 2;
                }
                frame.put(j, i, pixelVal);
            }
        }

        return frame;
    }

    public static Mat binarize() {
        return null;
    }

    public static Mat smooth() {
        return null;
    }

    public static Mat blueChannel(Mat frame) {

        int nl = frame.rows();
        int nc = frame.cols();
        int div = 64;
        double[] pixelVal = {0, 0, 0};
        for (int j = 0; j < nl; j++) {
            for (int i = 0; i < nc; i++) {
                pixelVal = frame.get(j, i);
                pixelVal[0] = (int) pixelVal[0] / div * div + div / 2;
                pixelVal[1] = 0;
                pixelVal[2] = 0;
                frame.put(j, i, pixelVal);
            }
        }

        return frame;
    }

    @SuppressWarnings("empty-statement")
    public static Mat[] colorChannels(Mat frame) {
        Mat frames[] = new Mat[frame.channels()];

        for (int i = 0; i < frames.length; i++) {
            frames[i] = frame.clone();
        }

        int nl = frame.rows();
        int nc = frame.cols();
        double[] pixelVal = {0, 0, 0};
        double[] pixelTh = {0, 0, 0};
        for (int j = 0; j < nl; j++) {
            for (int i = 0; i < nc; i++) {
                pixelVal = frame.get(j, i);

                for (int f = 0; f < frames.length; f++) {
                    for (int c = 0; c < pixelVal.length; c++) {
                        if (f == c) {
                            pixelTh[c] = pixelVal[c];
                        } else {
                            pixelTh[c] = 0;
                        }
                    }
                    frames[f].put(j, i, pixelTh);
                }

            }
        }

        return frames;
    }

    //Binarize Method
    public static Mat preproc(Mat frame) {
        Mat preprosMat = new Mat();
        
        Imgproc.cvtColor(frame, preprosMat, Imgproc.COLOR_RGB2HSV);
        
        Core.inRange(frame, new Scalar(MyIntegers.valueThreshold1, MyIntegers.valueThreshold2, MyIntegers.valueThreshold3),
                new Scalar(MyIntegers.valueThreshold4, MyIntegers.valueThreshold5, MyIntegers.valueThreshold6), preprosMat);
        
//        List<Mat> framesVideoSeparated = Splitting.spliting(frame);
//        //preprosMat = framesVideoSeparated.get(2).clone();
//        Imgproc.threshold(framesVideoSeparated.get(2),
//                preprosMat,
//                MyIntegers.valueThreshold1, 255, Imgproc.THRESH_BINARY);
//        Imgproc.erode(preprosMat, preprosMat, new Mat());
//        Imgproc.dilate(preprosMat, preprosMat, new Mat());

        return preprosMat;
    }

    public static Mat findContours(Mat frame) {

        Mat contoursMat = preproc(frame);

        Mat result = new Mat(contoursMat.size(), CvType.CV_8U, new Scalar(255));
        List<MatOfPoint> contours = new ArrayList<>();
        List<MatOfPoint> contoursGeneral = new ArrayList<>();
        Imgproc.findContours(contoursMat, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
//        Imgproc.drawContours(result, contours, -1, new Scalar(0), 2);
        
        for(int i = 0; i < contours.size(); i++){
            double area = Imgproc.contourArea(contours.get(i));
            if(MyBooleans.flag){
                System.out.println(area);
            }           
            if(area < MyIntegers.minContours || area > MyIntegers.maxContours){
                contours.remove(i);
            }else if(area > MyIntegers.mediumContours && area < MyIntegers.maxContours){
                contoursGeneral.add(contours.get(i));
            }
        }
        
        Imgproc.drawContours(result, contours, -1, new Scalar(0), 2);
        
//         MyBooleans.flag = false;
         
         //centros de masa
         for(int i = 0; i < contoursGeneral.size(); i++){
             Moments mom = Imgproc.moments(contoursGeneral.get(i));
             Core.circle(result, 
                     new Point(mom.get_m10()/mom.get_m00(), mom.get_m01()/mom.get_m00()), 
                     2, new Scalar(80),2);
         }
         
         

//        List<RotatedRect> minRects = new ArrayList<>();
//        for (int i = 0; i < contours.size(); i++) {
//            minRects.add(Imgproc.minAreaRect(new MatOfPoint2f(contours.get(i).toArray())));
//            Point rect_point[] = new Point[4];
//            minRects.get(i).points(rect_point);
//            for (int j = 0; j < 4; j++) {
//                Core.line(result, rect_point[j], rect_point[(j+1)%4], new Scalar(170),2);
//            }
//        }
        
//        Rect r0;
//        for (int i = 0; i < contours.size(); i++) {
//            r0 = Imgproc.boundingRect(contours.get(i));
//            Core.rectangle(result, r0.tl(), r0.br(), new Scalar(20, 250, 0), 2);
//        }
//        Rect r0 = Imgproc.boundingRect(contours.get(0));
//        Core.rectangle(result, r0.tl(), r0.br(), new Scalar(20), 2);

        return result;
    }
    //BUnarize method and eroting and dilate
}
