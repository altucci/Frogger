package Constants;
import RowProperties.*;
import Rows.MultiImageRow;
import Rows.Row;
import Rows.SingleImageRow;
import java.util.ArrayList;

public class RowConstants 
{        
    public final ImageConstants images = new ImageConstants();
    public ArrayList<Row> Level1_Rows = new ArrayList<Row>();
    public ArrayList<Row> Level2_Rows = new ArrayList<Row>();
    public ArrayList<Row> Level3_Rows = new ArrayList<Row>();
    public ArrayList<Row> Level4_Rows = new ArrayList<Row>();
    public ArrayList<Row> Level5_Rows = new ArrayList<Row>();
    
    public RowConstants()
    {
        Level1_Rows.add(new SingleImageRow(528, new RowProperties(images.bluecar2, true, false, 120, 2, 1, 4)));
        Level1_Rows.add(new SingleImageRow(480, new RowProperties(images.yellowcar1, true, false, 129, 1, 2, 4)));
        Level1_Rows.add(new SingleImageRow(432, new RowProperties(images.blackcar2, true, false, 85, 2, 8, 2)));
        Level1_Rows.add(new SingleImageRow(384, new RowProperties(images.yellowcar2, true, false, 196, 2, 2, 3)));
        Level1_Rows.add(new SingleImageRow(336, new RowProperties(images.runner1, true, false, 125, 1, 3, 4)));
        //Level1_Rows.add(new MultiImageRow(336, new RowProperties(images.Runner1, true, false, 120, 1, 7, 1, 1, 0)));
        Level1_Rows.add(new MultiImageRow(240, new RowProperties(images.LogSink, false, true, 110, 2, 3, 3, 30, 2)));
        Level1_Rows.add(new SingleImageRow(192, new RowProperties(images.barrelSink1, false, true, 129, 1, 2, 4)));
        Level1_Rows.add(new SingleImageRow(144, new RowProperties(images.logSink1, false, true, 100, 1, 4, 3)));
        Level1_Rows.add(new MultiImageRow(96, new RowProperties(images.BarrelSink, false, true, 80, 2, 6, 2, 30, 0)));
        Level1_Rows.add(new SingleImageRow(48, new RowProperties(images.logLong2, false, true, 50, 1, 2, 1)));
        
        Level2_Rows.add(new SingleImageRow(528, new RowProperties(images.bluecar2, true, false, 120, 2, 1, 4)));
        Level2_Rows.add(new SingleImageRow(480, new RowProperties(images.yellowcar1, true, false, 129, 1, 2, 4)));
        Level2_Rows.add(new SingleImageRow(432, new RowProperties(images.bluecar2, true, false, 85, 2, 8, 2)));
        Level2_Rows.add(new SingleImageRow(384, new RowProperties(images.yellowcar2, true, false, 196, 2, 2, 3)));
        Level2_Rows.add(new SingleImageRow(336, new RowProperties(images.blackcar1, true, false, 125, 1, 3, 4)));
        Level2_Rows.add(new MultiImageRow(240, new RowProperties(images.BarrelSink, false, true, 110, 2, 3, 3, 30, 2)));
        Level2_Rows.add(new SingleImageRow(192, new RowProperties(images.barrelSink1, false, true, 129, 1, 2, 4)));
        Level2_Rows.add(new SingleImageRow(144, new RowProperties(images.logSink1, false, true, 100, 1, 4, 3)));
        Level2_Rows.add(new MultiImageRow(96, new RowProperties(images.LogSink, false, true, 80, 2, 6, 2, 30, 0)));
        Level2_Rows.add(new SingleImageRow(48, new RowProperties(images.logLong2, false, true, 50, 1, 2, 1)));
        
        Level3_Rows.add(new SingleImageRow(528, new RowProperties(images.bluecar2, true, false, 120, 2, 1, 4)));
        Level3_Rows.add(new SingleImageRow(480, new RowProperties(images.blackcar1, true, false, 129, 1, 2, 4)));
        Level3_Rows.add(new SingleImageRow(432, new RowProperties(images.yellowcar2, true, false, 85, 2, 8, 2)));
        Level3_Rows.add(new SingleImageRow(384, new RowProperties(images.bluecar2, true, false, 196, 2, 2, 3)));
        Level3_Rows.add(new SingleImageRow(336, new RowProperties(images.blackcar1, true, false, 125, 1, 3, 4)));
        Level3_Rows.add(new MultiImageRow(240, new RowProperties(images.BarrelSink, false, true, 110, 2, 3, 3, 30, 2)));
        Level3_Rows.add(new SingleImageRow(192, new RowProperties(images.barrelSink1, false, true, 129, 1, 2, 4)));
        Level3_Rows.add(new SingleImageRow(144, new RowProperties(images.logSink1, false, true, 100, 1, 4, 3)));
        Level3_Rows.add(new MultiImageRow(96, new RowProperties(images.BarrelSink, false, true, 80, 2, 6, 2, 30, 0)));
        Level3_Rows.add(new SingleImageRow(48, new RowProperties(images.logLong2, false, true, 50, 1, 2, 1)));
        
        Level4_Rows.add(new SingleImageRow(528, new RowProperties(images.blackcar2, true, false, 120, 2, 1, 4)));
        Level4_Rows.add(new SingleImageRow(480, new RowProperties(images.bluecar2, true, false, 129, 2, 2, 4)));
        Level4_Rows.add(new SingleImageRow(432, new RowProperties(images.yellowcar2, true, false, 85, 2, 8, 2)));
        Level4_Rows.add(new SingleImageRow(384, new RowProperties(images.blackcar1, true, false, 196, 1, 2, 3)));
        Level4_Rows.add(new SingleImageRow(336, new RowProperties(images.bluecar2, true, false, 125, 2, 3, 4)));
        Level4_Rows.add(new MultiImageRow(240, new RowProperties(images.LogSink, false, true, 110, 2, 3, 3, 30, 2)));
        Level4_Rows.add(new SingleImageRow(192, new RowProperties(images.logSink1, false, true, 129, 2, 2, 4)));
        Level4_Rows.add(new SingleImageRow(144, new RowProperties(images.barrelSink1, false, true, 100, 1, 4, 3)));
        Level4_Rows.add(new MultiImageRow(96, new RowProperties(images.LogSink, false, true, 80, 2, 6, 2, 30, 0)));
        Level4_Rows.add(new SingleImageRow(48, new RowProperties(images.logLong2, false, true, 50, 2, 2, 1)));
        
        Level5_Rows.add(new SingleImageRow(528, new RowProperties(images.bluecar1, true, false, 120, 1, 1, 4)));
        Level5_Rows.add(new SingleImageRow(480, new RowProperties(images.yellowcar1, true, false, 129, 1, 2, 4)));
        Level5_Rows.add(new SingleImageRow(432, new RowProperties(images.yellowcar1, true, false, 85, 1, 8, 2)));
        Level5_Rows.add(new SingleImageRow(384, new RowProperties(images.bluecar1, true, false, 196, 1, 2, 3)));
        Level5_Rows.add(new SingleImageRow(336, new RowProperties(images.blackcar1, true, false, 125, 1, 3, 4)));
        Level5_Rows.add(new MultiImageRow(240, new RowProperties(images.BarrelSink, false, true, 110, 2, 3, 3, 30, 2)));
        Level5_Rows.add(new MultiImageRow(192, new RowProperties(images.BarrelSink, false, true, 110, 2, 4, 3, 30, 2)));
        Level5_Rows.add(new MultiImageRow(144, new RowProperties(images.LogSink, false, true, 110, 2, 2, 3, 30, 2)));
        Level5_Rows.add(new MultiImageRow(96, new RowProperties(images.BarrelSink, false, true, 110, 2, 2, 3, 30, 2)));
        Level5_Rows.add(new MultiImageRow(48, new RowProperties(images.LogSink, false, true, 110, 2, 6, 3, 30, 2)));
    }

    public ArrayList<Row> getRowsForLevel(int lev)
    {
        ArrayList<Row> Temp_Rows = new ArrayList<Row>();
        
        switch(lev)
        {
            case 1:
                Temp_Rows = Level1_Rows;
                break;
            case 2:
                Temp_Rows = Level2_Rows;
                break;
            case 3:
                Temp_Rows = Level3_Rows;
                break;
            case 4:
                Temp_Rows = Level4_Rows;
                break;
            case 5:
                Temp_Rows = Level5_Rows;
                break;
            default:
                Temp_Rows = Level1_Rows;
                break;
        }
        
        return Temp_Rows;
    }
}
