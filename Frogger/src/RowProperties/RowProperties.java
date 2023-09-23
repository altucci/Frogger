package RowProperties;


import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class RowProperties 
{
    BufferedImage img;
    ArrayList<BufferedImage> imgs;
    boolean isHarmful;
    boolean isLandHarmful;
    int animationSpeed;
    int distanceApart;
    int direction;
    int speed;
    int size;
    ArrayList imagesToAnimateIndex = new ArrayList();
    
    public RowProperties(BufferedImage img, boolean isHarmful, boolean isLandHarmful, int distance, int direction, int speed, int size)
    {
        this.img = img;
        this.isHarmful = isHarmful;
        this.isLandHarmful = isLandHarmful;
        this.distanceApart = distance;
        this.direction = direction;
        this.speed = speed;
        this.size = size;
    }

    public RowProperties(ArrayList<BufferedImage> imgs, boolean isHarmful, boolean isLandHarmful, int distance, int direction, int speed, int size, int animationSpeed, int...imagesToAnimateIndex)
    {
        this.imgs = imgs;
        this.isHarmful = isHarmful;
        this.isLandHarmful = isLandHarmful;
        this.animationSpeed = animationSpeed;
        this.distanceApart = distance;
        this.direction = direction;
        this.speed = speed;
        this.size = size;
        
        for(int i=0; i<imagesToAnimateIndex.length; i++)
            this.imagesToAnimateIndex.add(imagesToAnimateIndex[i]);

    }
    
    public BufferedImage getImage() // returns the image of this level
    {
        return img;
    }
    
    public ArrayList<BufferedImage> getMultiImage() // returns an arry of images 
    {
        return imgs;
    }
    
    public int getAnimationSpeed() // returns the speed of the animation effect of the image
    {
        return animationSpeed;
    }
    
    public int getDistanceApart() // returns the distance each image should be drawn apart
    {
        return distanceApart;
    }
    
    public int getDirection() // returns the direction this/these images should be moving
    {
        return direction;
    }
    
    public int getSpeed() // returns the speed at which images should move in the specified direction
    {
        return speed;
    }
    
    public int getSize() // returns the number of images to be drawn on the canvas
    {
        return size;
    }
    
    public boolean getIsHarmful() //returns boolean: is this image harmful to frog?
    {
        return isHarmful;
    }
    
    public boolean getIsLandHarmful()
    {
        return isLandHarmful;
    }
    
    public ArrayList getImagesToAnimateIndex() // returns int arrylist: utilized in MultiImageRow. tells us if which image we should animate when we draw on the canvas
    {
        return imagesToAnimateIndex;  
    }
}
