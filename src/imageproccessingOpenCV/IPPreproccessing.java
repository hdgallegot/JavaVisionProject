/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageproccessingOpenCV;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.opencv.core.Mat;
import values.MyIntegers;

/**
 *
 * @author aldajo
 */
public class IPPreproccessing extends ImageProccessingFrame{
    
    private JSlider slider, slider2, slider3, slider4, slider5, slider6;
    private JPanel panel;
    private JLabel label1, label2, label3, label4, label5, label6;
    private Box panelSliders;
    
    public IPPreproccessing() {
        super("Color Reduce");
        panelSliders = Box.createVerticalBox();
        slider = new JSlider();
        slider2 = new JSlider();
        slider3 = new JSlider();
        slider4 = new JSlider();
        slider5 = new JSlider();
        slider6 = new JSlider();
        
        panel = new JPanel(new GridLayout(2, 3));
        
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        
        panelSliders.add(slider);
        panelSliders.add(slider2);
        panelSliders.add(slider3);
        panelSliders.add(slider4);
        panelSliders.add(slider5);
        panelSliders.add(slider6);
        panelSliders.add(panel);
        addComponentSout(panelSliders);
        
        slider.setMinimum(0);
        slider2.setMinimum(0);
        slider3.setMinimum(0);
        slider4.setMinimum(0);
        slider5.setMinimum(0);
        slider6.setMinimum(0);
        
        slider.setMaximum(255);
        slider2.setMaximum(255);
        slider3.setMaximum(255);
        slider4.setMaximum(255);
        slider5.setMaximum(255);
        slider6.setMaximum(255);
        
        slider.setValue(65);
        slider2.setValue(65);
        slider3.setValue(65);
        slider4.setValue(65);
        slider5.setValue(65);
        slider6.setValue(65);
        
        label1.setText("B: "+slider.getValue());
        label2.setText("G: "+slider2.getValue());
        label3.setText("R: "+slider3.getValue());
        
        label4.setText("B: "+slider4.getValue());
        label5.setText("G: "+slider5.getValue());
        label6.setText("R: "+slider6.getValue());
        
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MyIntegers.valueThreshold1 = slider.getValue();
                label1.setText("B: "+slider.getValue());
            }
        });
        
        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MyIntegers.valueThreshold2 = slider2.getValue();
                label2.setText("G: "+slider2.getValue());
            }
        });
        
        slider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MyIntegers.valueThreshold3 = slider3.getValue();
                label3.setText("R: "+slider3.getValue());
            }
        });
        
        slider4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MyIntegers.valueThreshold4 = slider4.getValue();
                label4.setText("B: "+slider4.getValue());
            }
        });
        
        slider5.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MyIntegers.valueThreshold5 = slider5.getValue();
                label5.setText("G: "+slider5.getValue());
            }
        });
        
        slider6.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MyIntegers.valueThreshold6 = slider6.getValue();
                label6.setText("R: "+slider6.getValue());
            }
        });
    }
    
    
    
    @Override
    public Mat ProccessImageOpenCV(Mat frame) {
        return ImageProccessingMethods.preproc(frame);
    }
    
}
