package Rows;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import RowProperties.RowProperties;
import Constants.Constants;

public class MultiImageRow extends Row
{
    protected ArrayList<BufferedImage> imgs;
    protected int wait;
    protected int animationSpeed;
    protected int currentImageIndex;
    protected ArrayList imagesToAnimateIndex;
 
    public MultiImageRow(int rLocation)
    {
        rowType = "MultiImageRow";
        rowLocation = rLocation;
    }
    
    public MultiImageRow(int rLocation, RowProperties rowPropertiestObject)
    {
        rowType = "MultiImageRow";
        rowLocation = rLocation;
        imgs = rowPropertiestObject.getMultiImage();
        distanceDrawnApart = rowPropertiestObject.getDistanceApart();
        movementDirection = rowPropertiestObject.getDirection();
        movementSpeed = rowPropertiestObject.getSpeed();
        numOfImages = rowPropertiestObject.getSize();  
        animationSpeed = rowPropertiestObject.getAnimationSpeed();
        wait = animationSpeed;
        harmfulness = rowPropertiestObject.getIsHarmful();
        landHarmfulness = rowPropertiestObject.getIsLandHarmful();
        currentImageIndex = 0;
        currentImage = imgs.get(currentImageIndex);
        points = new Point[numOfImages];
        imagesToAnimateIndex = rowPropertiestObject.getImagesToAnimateIndex();
        xBoundry = Constants.DIMENSION.width;
        initialize();
    }

    public BufferedImage getCurrentMultiImage() // this method is used IF animateThisImage returns true
    {
            int s = imgs.size();
            s -= 1;
            
            if(wait == 0)
            {
                if(currentImageIndex == s) //currently at the last index in the arry of images, so we 'loop' back to the first image
                {
                    currentImageIndex = 0;
                    wait = animationSpeed;
                    return imgs.get(currentImageIndex);
                }
                else
                {
                    currentImageIndex++;
                    wait = animationSpeed;
                    return imgs.get(currentImageIndex);
                }   
            }
            else
            {
                wait--;
                return imgs.get(currentImageIndex);
            }
                
    }
    
    public int getCurrentImageIndex() // get the index of the currentImage that is being drawn from the getCurrentMultiImage() method
    {
        return currentImageIndex;
    }
    
    public int getImageArraySize()
    {
        return imgs.size();
    }
    
    public boolean getLandHarmfulness()
    {
        return landHarmfulness;
    }
    
    public boolean animateThisImage(int i) // tells us if we should we animate the image at point[i]
    {
        if(imagesToAnimateIndex.contains(i))
            return true;
        else 
            return false;
    }
}
