/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.frame;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import values.MyColors;

/**
 *
 * @author aldajo
 */
public class MyFrame extends JFrame{

    public MyFrame(String title){
        super(title);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            initComponents();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
