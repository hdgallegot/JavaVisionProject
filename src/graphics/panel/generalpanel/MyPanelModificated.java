/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.panel.generalpanel;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author aldajo
 */
public class MyPanelModificated extends JPanel{

    private Border blackline;
    private TitledBorder title;
    
    public MyPanelModificated() {
        initComponents();
    }
    
    private void initComponents(){
        blackline = BorderFactory.createLineBorder(Color.black);

        title = BorderFactory.createTitledBorder(
                blackline, "Camera");
        title.setTitleJustification(TitledBorder.CENTER);
        title.setTitleColor(Color.yellow);

        setBorder(title);
        setBackground(new Color(0, 0, 0, 200));
    }
    
}
