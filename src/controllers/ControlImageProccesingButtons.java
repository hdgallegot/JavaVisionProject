/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import adapters.AdapterMat4Panel;
import camera.Camera;
import camera.CameraFrameListener;
import graphics.panel.generalpanel.MyLateralButtons;
import imageproccessingOpenCV.IPBlueChannels;
import imageproccessingOpenCV.IPColorChannels;
import imageproccessingOpenCV.IPColorReduce;
import imageproccessingOpenCV.IPDetectSquares;
import imageproccessingOpenCV.IPPreproccessing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.opencv.core.Mat;
import values.MyMatImages;
import values.MyStrings;

/**
 *
 * @author aldajo
 */
public class ControlImageProccesingButtons implements ActionListener, CameraFrameListener {

    private MyLateralButtons lateralButtons;
    private JButton[] buttons;
    private Camera cam;
    private IPColorReduce reduceFrame;
    private IPBlueChannels blueFrame;
    private IPColorChannels colorFrame;
    private IPPreproccessing prepros;
    private IPDetectSquares ipdetectSquares;
    private AdapterMat4Panel mat4Panel;

    public ControlImageProccesingButtons(MyLateralButtons lButtons, Camera cam, AdapterMat4Panel m4p) {
        lateralButtons = lButtons;
        buttons = lButtons.getButtons();
        lateralButtons.addActionListener4Buttons(this);
        this.cam = cam;
    }

    public ControlImageProccesingButtons(MyLateralButtons lButtons, AdapterMat4Panel m4p) {
        lateralButtons = lButtons;
        buttons = lButtons.getButtons();
        lateralButtons.addActionListener4Buttons(this);
        mat4Panel = m4p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(buttons[0])) {
            if(reduceFrame != null){
                reduceFrame.dispose();
                reduceFrame = null;
            }
            reduceFrame = new IPColorReduce();
            mat4Panel.refreshNewMatFrame4Image(reduceFrame.ProccessImageOpenCV(MyMatImages.ImageOpenCVCharged));
            
        } else if (e.getSource().equals(buttons[1])) {
            if(blueFrame != null){
                blueFrame.dispose();
                blueFrame = null;
            }
            blueFrame = new IPBlueChannels();
            mat4Panel.refreshNewMatFrame4Image(blueFrame.ProccessImageOpenCV(MyMatImages.ImageOpenCVCharged));
        } else if (e.getSource().equals(buttons[2])) {
            if(colorFrame != null){
                colorFrame.dispose();
                colorFrame = null;
            }
            colorFrame = new IPColorChannels("", MyStrings.channelsNames);
        } else if (e.getSource().equals(buttons[3])) {
            if(reduceFrame != null){
                reduceFrame.dispose();
                reduceFrame = null;
            }
            if(blueFrame != null){
                blueFrame.dispose();
                blueFrame = null;
            }
            if(colorFrame != null){
                colorFrame.dispose();
                colorFrame = null;
            }
            //falta agregar algunas cosillas
        } else if (e.getSource().equals(buttons[4])){
            if(prepros != null){
                prepros.dispose();
                prepros = null;
            }
            prepros = new IPPreproccessing();
            mat4Panel.refreshNewMatFrame4Image(prepros.ProccessImageOpenCV(MyMatImages.ImageOpenCVCharged));
        } else if (e.getSource().equals(buttons[5])){
            if(ipdetectSquares != null){
                ipdetectSquares.dispose();
                ipdetectSquares = null;
            }
            ipdetectSquares = new IPDetectSquares("");
            mat4Panel.refreshNewMatFrame4Image(ipdetectSquares.ProccessImageOpenCV(MyMatImages.ImageOpenCVCharged));
        }
    }

    @Override
    public void onFrameCapture(Mat frame) {
        if (reduceFrame != null) {
            reduceFrame.displayImageProccessed(frame);
        }
        if (blueFrame != null) {
            blueFrame.displayImageProccessed(frame);
        }
        if (colorFrame != null) {
            colorFrame.displayImageProccessed(frame);
        }
        if (prepros != null){
            prepros.displayImageProccessed(frame);
        }
        if (ipdetectSquares != null){
            ipdetectSquares.displayImageProccessed(frame);
        }
    }
}
