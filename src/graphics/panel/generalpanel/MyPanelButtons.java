/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.panel.generalpanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import values.MyColors;
import values.MyStrings;

/**
 *
 * @author aldajo
 */
public class MyPanelButtons extends MyPanelModificated{

    private JButton[] buttons;
    private JTextField campoTexto;

    public MyPanelButtons() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(MyColors.frameColor);
        
        buttons = new JButton[MyStrings.buttonsPanelNames.length];
        campoTexto = new JTextField();
        campoTexto.setPreferredSize(new Dimension(150,30));
        
        for(int i=0; i<buttons.length; i++){
            buttons[i] = new JButton(MyStrings.buttonsPanelNames[i]);
            add(buttons[i]);
        }
        add(campoTexto);
    }

    public JButton[] getButtons() {
        return buttons;
    }

    public JTextField getCampoTexto() {
        return campoTexto;
    }
    
    public void addActionListener4Buttons(ActionListener al){
        for (JButton b : buttons) {
            b.addActionListener(al);
        }
    }
    
}
