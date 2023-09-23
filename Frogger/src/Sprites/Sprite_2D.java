/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sprites;

import FrogMotion.Motion;
import java.awt.*;

/**
 *
 * @author John
 */
public abstract class Sprite_2D extends Sprite {

    protected Motion motion;
    
    protected int MaxWidth, MaxHeight, xshift, yshift, locx, locy;
    
    protected Dimension dimension;
    
    protected Graphics gra;
    
    public byte getDirection()
    {
        if (motion != null)
        {
            return motion.getDirection();
        }
        else
        {
            return 0;
        }        
    }
    
    public void initMotion(Motion m)
    {
        motion = m;
        
        if (motion != null)
        {
            motion.setPosition(locx, locy);
            motion.setVelocity(xshift, yshift);
        }
    }
    
    public abstract void randomlySetPosition();
    
    public void randomlySetVelocity()
    {
        do{
            xshift = (int)(Math.random()*10);
            
        }while (xshift < 2);
        
        yshift = xshift;
    }

    public int getLocx()
    {
        return locx;
    }

    public int getLocy()
    {
        return locy;
    }

    public void setLocx(int locX)
    {
        locx = locX;
    }

    public void setLocy(int locY)
    {
        locy = locY;
    }
    
    public void setPosition(int locX, int locY)
    {
        locx = locX;
        locy = locY;
    }

    public int getVx()
    {
        return xshift;
    }

    public int getVy()
    {
        return yshift;
    }

    public void setVx(int vx)
    {
        xshift = vx;
    }

    public void setVy(int vy)
    {
        yshift = vy;
    }
    
    public void setVelocity(int vx, int vy)
    {
        xshift = vx;
        yshift = vy;
    }

    public Dimension getDimension()
    {        
        return dimension;
    }

    public void setDimension(Dimension dim) {
        
        this.dimension = dim;
        
        MaxWidth = dimension.width;
        MaxHeight = dimension.height;
    }

    public Graphics getGraphics() {
        
        return gra;
    }

    public void setGraphics(Graphics g) {
        
        this.gra = g;
    }
}