/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.panel.generalpanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import values.MyColors;
import values.MyStrings;

/**
 *
 * @author aldajo
 */
public class MyLateralButtons extends MyPanelModificated{
    
    private JButton[] buttons;

    public MyLateralButtons() {
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new GridLayout(MyStrings.buttonProccessingImageNames.length, 1));
        setBackground(MyColors.frameColor);
        
        buttons = new JButton[MyStrings.buttonProccessingImageNames.length];
        for(int i=0; i<buttons.length; i++){
            buttons[i] = new JButton(MyStrings.buttonProccessingImageNames[i]);
            add(buttons[i]);
        }
    }

    public JButton[] getButtons() {
        return buttons;
    }
    
    public void addActionListener4Buttons(ActionListener al){
        for (JButton b : buttons) {
            b.addActionListener(al);
        }
    }
    
}
