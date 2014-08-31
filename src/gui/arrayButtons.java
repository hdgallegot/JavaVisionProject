/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author aldajo
 */
public class arrayButtons extends JPanel{
    
    private int numberRows = 5;
    private JButton[] buttons;

    public arrayButtons() {
        setLayout(new GridLayout(numberRows, 1));
        initCompontents();
    }
    
    private void initCompontents(){
        buttons = new JButton[numberRows];
        for(int i=0; i<numberRows; i++){
            buttons[i] = new JButton("b"+ (i+1));
            add(buttons[i]);
        }
    }
    
}
