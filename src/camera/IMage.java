/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package camera;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;

/**
 *
 * @author aldajo
 */
public class IMage extends JComponent {

    private BufferedImage img;
    private MatOfByte matOfByte;
    private Mat imMat;
    private boolean isPrint = true;

    public IMage(BufferedImage imthm) {
        img = imthm;
    }

    public IMage(Mat image) {
        imMat = image;
        configureImage(image);
    }

    public IMage() {
    }

    public void configureImage(Mat im) {
        imMat = im;
        matOfByte = new MatOfByte();

        Highgui.imencode("at.jpg", im, matOfByte);

        byte[] byteArray = matOfByte.toArray();
        BufferedImage bufImage = null;

        try {
            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        img = bufImage;
        matOfByte = null;
        if (isPrint) {
            setMinimumSize(new Dimension(imMat.width(), imMat.height() + 30));
            setPreferredSize(new Dimension(imMat.width(), imMat.height() + 30));
            setMaximumSize(new Dimension(imMat.width() + 30, imMat.height() + 60));
            System.out.println(getSizeIM().toString());
            System.out.println("Channels: " + im.channels());
            isPrint = false;
        }
        repaint();
    }

    public void setNewImageSize(Mat im) {
        imMat = im;
        matOfByte = new MatOfByte();

        Highgui.imencode("at.jpg", im, matOfByte);

        byte[] byteArray = matOfByte.toArray();
        BufferedImage bufImage = null;

        try {
            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        img = bufImage;
        matOfByte = null;
        setMinimumSize(new Dimension(imMat.width(), imMat.height() + 30));
        setPreferredSize(new Dimension(imMat.width(), imMat.height() + 30));
        setMaximumSize(new Dimension(imMat.width() + 30, imMat.height() + 60));
//        System.out.println(getSizeIM().toString());
//        System.out.println("Channels: " + im.channels());
        isPrint = false;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (!(img == null)) {
            g2.translate(getWidth() / 2, getHeight() / 2);
            g2.drawImage(img, null, -imMat.width() / 2, -imMat.height() / 2);
        }
    }

    public Dimension getSizeIM() {
        Dimension dim = new Dimension(imMat.width(), imMat.height());
        return dim;
    }
}
