package Rows;

import java.awt.Point;
import RowProperties.RowProperties;
import Constants.Constants;

public class SingleImageRow extends Row
{
    public SingleImageRow(int rLocation)
    {
        rowType = "SingleImageRow";
        rowLocation = rLocation;
    }
    
    public SingleImageRow(int rLocation, RowProperties rowPropertiestObject)
    {
        rowType = "SingleImageRow";
        rowLocation = rLocation; 
        distanceDrawnApart = rowPropertiestObject.getDistanceApart();
        movementDirection = rowPropertiestObject.getDirection();
        movementSpeed = rowPropertiestObject.getSpeed();
        numOfImages = rowPropertiestObject.getSize();
        harmfulness = rowPropertiestObject.getIsHarmful();
        landHarmfulness = rowPropertiestObject.getIsLandHarmful();
        currentImage = rowPropertiestObject.getImage();
        points = new Point[numOfImages];
        xBoundry = Constants.DIMENSION.width;
        initialize();
    }
    
    public boolean getHarmfulness()
    {
        return harmfulness;
    }
    
    public boolean getLandHarmfulness()
    {
        return landHarmfulness;
    }
}
