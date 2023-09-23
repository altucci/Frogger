/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sprites;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/**
 *
 * @author John
 */
public class FrogSprite extends ImageSprite implements Runnable {
    
    protected volatile boolean jumping, finishedJumping;
    
    protected int count;
    
    protected Thread application = null;
    
    public FrogSprite() {
        
        super();
        
        jumping = false;
        
        finishedJumping = false;
        
        count = 0;
    }
    
    public FrogSprite(int x, int y, int vx, int vy, BufferedImage img, ImageObserver io) {
        
        super(x, y, vx, vy, img, io);
        
        jumping = false;
        
        finishedJumping = false;
        
        count = 0;
    }

    @Override
    public void update() {
        
        if (count < 10)
        {
            if (motion != null)
            {
                motion.updatePosition();
                
                setPosition(motion.getX(), motion.getY());
            }
            
            count++;
        }
        else
        {
            //jumping = false;
            finishedJumping = true;
            //count = 0;
        }
    }
    
    public void start() {
        
        if (this.application == null)
        {
            this.application = new Thread(this);
            this.application.start();
        }
    }

    @Override
    public void run() {
        
        while (true)
        {
            if (jumping)
            {
                update();
                
                try{
                    
                    Thread.sleep(10);
                    
                }catch(Exception e){

                }
            }
        }
    }
    
    public void finalizeJump()
    {
        jumping = false;
        
        count = 0;
    }

    public boolean isJumping() {
        
        return jumping;
    }

    public void setJumping(boolean jumping) {
        
        this.jumping = jumping;
    }

    public boolean isFinishedJumping() {
        
        return finishedJumping;
    }

    public void setFinishedJumping(boolean finishedJumping) {
        
        this.finishedJumping = finishedJumping;
    }
    
    public int getRow()
    {
//        if (jumping = true)
//            return -1;
        
        int row = locy/CurrentImage.getHeight();
        
        if (row == 6 || row == 12)
        {
            return -1;
        }
        
        if (row == 0)
        {
            return -2;
        }
        
        row--;
        
        if (row > 5)
        {
            row--;        
        }
        
        row = 9 - row;
        
        return row;
    }
}
