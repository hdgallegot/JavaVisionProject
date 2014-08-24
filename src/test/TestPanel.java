/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import graphics.frame.MyFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author aldajo
 */
public class TestPanel {

    public static void main(String[] args) {
        MyFrame frame = new MyFrame("HI");
        JPanel panel = new JPanel();
        Border blackline = BorderFactory.createLineBorder(Color.black);

        TitledBorder title;
        title = BorderFactory.createTitledBorder(
                blackline, "Camera");
        title.setTitleJustification(TitledBorder.CENTER);
        title.setTitleColor(Color.yellow);

        panel.setBorder(title);
        panel.setBackground(new Color(0, 0, 0, 200));
        panel.setLayout(new BorderLayout());
        panel.add(new JButton("HI"));
        panel.getComponent(0).setBackground(new Color(0, 0, 0, 100));
        frame.getContentPane().setLayout(new GridLayout());
        frame.getContentPane().add(panel);
    }
}
