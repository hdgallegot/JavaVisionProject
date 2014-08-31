/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import adapters.AdapterMat4Panel;
import camera.Camera;
import camera.CameraFrameListener;
import graphics.panel.generalpanel.MyPanelButtons;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import values.MyBooleans;
import values.MyMatImages;

/**
 *
 * @author aldajo
 */
public class ControlCameraPanel implements ActionListener, CameraFrameListener {

    private MyPanelButtons panelButtons;
    private JPanel panelCamera;
    private AdapterMat4Panel m4p;
    private Camera camera;
    private JButton[] buttons;
    private JTextField textField;
    private Mat initialFrame;
    private boolean oneTime = true, isdisplayImage = true;

    public ControlCameraPanel(MyPanelButtons panelButtons, JPanel panelCamera, Camera camera) {
        this.panelButtons = panelButtons;
        this.panelCamera = panelCamera;

        this.camera = camera;
        buttons = this.panelButtons.getButtons();
        textField = this.panelButtons.getCampoTexto();

        panelButtons.addActionListener4Buttons(this);

        initialFrame = Highgui.imread("img/img2.jpg");
        MyMatImages.ImageOpenCVCharged = initialFrame;
        m4p = new AdapterMat4Panel(this.panelCamera, initialFrame);
        camera.addCameraListener(this);
    }

    public AdapterMat4Panel getM4p() {
        return m4p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(buttons[0])) {
            camera.openCamera(1);
        } else if (e.getSource().equals(buttons[1])) {
            if (camera.isOpen()) {
                if(camera.isVideo()){
                    camera.stopCameraVideo();
                }
                Mat frame = camera.getCapture();
                m4p.refreshNewMatFrame4Image(frame);
            } else {
                JOptionPane.showMessageDialog(null, "Encienda primero la camara");
            }
        } else if (e.getSource().equals(buttons[2])) {
            if (camera.isOpen()) {
                camera.startCameraVideo();
                isdisplayImage = false;
                MyBooleans.chargeImage = true;
            } else {
                JOptionPane.showMessageDialog(null, "Encienda primero la camara");
            }
        } else if (e.getSource().equals(buttons[3])) {
            //falta por definir
        } else if (e.getSource().equals(buttons[4])){
            camera.loadImage("img/"+textField.getText());
            System.out.println("img/"+textField.getText());
            m4p.refreshNewMatFrame4Image(MyMatImages.ImageOpenCVCharged);
            MyBooleans.chargeImage = true;
            isdisplayImage = true;
        }
    }

    @Override
    public void onFrameCapture(Mat frame) {
        if(!isdisplayImage){
            if(frame == null){
                System.out.println("error");
            }

            if (oneTime) {
                m4p.refreshNewMatFrame4Image(frame);
                oneTime = false;
            } else {
                m4p.refreshNewMatFrame4Image(frame);
            }
        }
    }
}
