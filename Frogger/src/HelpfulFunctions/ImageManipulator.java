package HelpfulFunctions;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 *
 * @author John
 */
public class ImageManipulator {    

    public static BufferedImage makeColorTransparent(BufferedImage image, Color color) {
        
        BufferedImage dimg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = dimg.createGraphics();   
        g.setComposite(AlphaComposite.Src);   
        g.drawImage(image, null, 0, 0);   
        g.dispose();   
        for(int i = 0; i < dimg.getHeight(); i++) {               
            for(int j = 0; j < dimg.getWidth(); j++) {                   
                if(dimg.getRGB(j, i) == color.getRGB()) {   
                    dimg.setRGB(j, i, 0x8F1C1C);   
                }   
            }   
        }   
        return dimg;   
    }

    public static BufferedImage rotate(BufferedImage img, int angle) {   
        
        int w = img.getWidth();   
        int h = img.getHeight();   
        BufferedImage dimg = dimg = new BufferedImage(w, h, img.getType());   
        Graphics2D g = dimg.createGraphics();   
        g.rotate(Math.toRadians(angle), w/2, h/2);   
        g.drawImage(img, null, 0, 0);   
        return dimg;   
    } 
    
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {   
        
        int w = img.getWidth();   
        int h = img.getHeight();   
        BufferedImage dimg = dimg = new BufferedImage(newW, newH, img.getType());   
        Graphics2D g = dimg.createGraphics();   
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);   
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);   
        g.dispose();   
        return dimg;   
    } 
}
