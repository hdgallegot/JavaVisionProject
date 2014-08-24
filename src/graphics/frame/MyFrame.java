/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.frame;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import values.MyColors;

/**
 *
 * @author aldajo
 */
public class MyFrame extends JFrame{

    public MyFrame(String title){
        super(title);
        initComponents();
    }
    
    private void initComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        //setForeground(Color.black);
        getContentPane().setBackground(MyColors.frameColor);
        getContentPane().setForeground(new Color(11, 11, 85));
    }
    
}
