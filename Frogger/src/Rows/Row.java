package Rows;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Row 
{
    protected int rowLocation;
    protected Point[] points;
    protected int xBoundry;
    protected int numOfImages;
    protected BufferedImage currentImage;
    protected String rowType;
    
    protected int distanceDrawnApart;
    protected int movementDirection;
    protected int movementSpeed;
    protected int currentImageWidth;
    
    protected boolean harmfulness;
    protected boolean landHarmfulness;
    
    public int getRowLocation()
    {
        return rowLocation;
    }
    
    public int getPointY(int i)
    {
        return points[i].y;
    }
    
    public int getPointX(int i)
    {
        return points[i].x;
    }
    
    public int getXBoundry()
    {
        return xBoundry;
    }
    
    public void setXBoundry(int xbound)
    {
        xBoundry = xbound;
    }
    
    public BufferedImage getCurrentImage()
    {
        return currentImage;
    }
    
    public int getNumOfImages()
    {
        return numOfImages;
    }
    
    public String getRowType()
    {
        return rowType;
    }
    
    public void initialize()
    {
        int x = 0;
        this.currentImageWidth = getCurrentImage().getWidth();//80; //currentImage.getWidth(io);  
        for(int i = 0; i<=numOfImages-1; i++)
        {
            points[i] = new Point(x, rowLocation);
            x += distanceDrawnApart+currentImageWidth;
        } 
    }
    
    public void update()
    {
        int x;
       
        for(int i = 0; i<=numOfImages-1; i++) // updates the points for where each image should be drawn 
        {
           switch(movementDirection)
           {
               case 1: //left
                   x = points[i].x-this.movementSpeed;
                   break;
               default:
                   x = points[i].x+this.movementSpeed; 
                   break;
           }
           if(x > xBoundry)
               points[i].x =-currentImageWidth;
           else if(x < -currentImageWidth)
               points[i].x = xBoundry;
           else
               points[i].x = x;
        }   
    }    
    
}
