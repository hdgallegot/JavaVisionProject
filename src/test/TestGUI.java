/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import graphics.frame.MyFrame;
import gui.GUI;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author aldajo
 */
public class TestGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyFrame frame = new MyFrame("");
        frame.add(new GUI());
        frame.setMinimumSize(frame.getMinimumSize());
    }
    
}
