/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sprites;

import Constants.Constants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 *
 * @author John
 */
public class ImageSprite extends Sprite_2D {
    
    protected int width, height;
    
    protected BufferedImage CurrentImage;
    
    protected ImageObserver imageObserver;
    
    public ImageSprite() {
        
        setDimension(Constants.DIMENSION);
        
        randomlySetPosition();
        
        randomlySetVelocity();
    }
    
    public ImageSprite(int x, int y, int vx, int vy, BufferedImage img, ImageObserver io) {
        
        Restore();
        
        locx = x;
        locy = y;
        xshift = vx;
        yshift = vy;
        
        CurrentImage = img;
        
        imageObserver = io;
        
        setDimension(Constants.DIMENSION);
    }
    
    @Override
    public void paint(Graphics g) {
        
        if (Visible)
        {            
            g.drawImage(CurrentImage, locx, locy, imageObserver);
        }
    }

    @Override
    public void update() {
        
        
    }
    
    @Override
    public void randomlySetPosition()
    {
        do{
            locx = (int)(Math.random()*(MaxWidth-(width)));
            
        }while ((locx-(width)) <= 0);
        
        do{
            locy = (int)(Math.random()*(MaxHeight-(height)));
            
        }while ((locy-(height)) <= 0);
    }
    
    public void setImage(BufferedImage frogImg)
    {
        CurrentImage = frogImg;
    }
    
    public BufferedImage getImage()
    {
        return CurrentImage;
    }
    
    public int getImageHeight()
    {
        return CurrentImage.getHeight();
    }
    
    public int getImageWidth()
    {
        return CurrentImage.getWidth();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
