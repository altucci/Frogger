package Constants;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import HelpfulFunctions.ImageManipulator;

public class ImageConstants 
{
    public BufferedImage background, startScreen;
    public BufferedImage frogjumpup, frogjumpdown, frogjumpleft, frogjumpright;
    public BufferedImage frogstillup, frogstilldown, frogstillleft, frogstillright;
    public BufferedImage runner1, runner2;
    public BufferedImage runner1_1, runner1_2, runner1_3, runner1_4;
    public BufferedImage runner2_1, runner2_2, runner2_3, runner2_4;
    public BufferedImage bluecar1, bluecar2;
    public BufferedImage yellowcar1, yellowcar2;
    public BufferedImage blackcar1, blackcar2;
    public BufferedImage invisibleImage;
    public BufferedImage barrelSink1, barrelSink2, barrelSink3, barrelSink4;
    public BufferedImage logSink1,logSink2,logSink3,logSink4;
    public BufferedImage logLong1, logLong2;
    public ArrayList<BufferedImage> LogSink = new ArrayList<BufferedImage>();
    public ArrayList<BufferedImage> BarrelSink = new ArrayList<BufferedImage>();
    public ArrayList<BufferedImage> Runner1 = new ArrayList<BufferedImage>();
    public ArrayList<BufferedImage> Runner2 = new ArrayList<BufferedImage>();
    
    public ImageConstants()
    {
        try
        {
            startScreen = ImageIO.read(getClass().getResource("/Images/froggerBackgroundFinal2_mod2.png"));
            background = ImageIO.read(getClass().getResource("/Images/froggerBackgroundFinal_mod2.png"));
            
            runner1 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/4runner/4runner_4_1.png")), new Color(57,61,72));
            runner2 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/4runner/4runner_4_2.png")), new Color(57,61,72));
            runner1_1 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/4runner/4runner_0_1_4.png")), new Color(102,102,102));
            runner1_2 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/4runner/4runner_0_1_3.png")), new Color(102,102,102));
            runner1_3 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/4runner/4runner_0_1_2.png")), new Color(102,102,102));
            runner1_4 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/4runner/4runner_0_1_1.png")), new Color(102,102,102));
            runner2_1 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/4runner/4runner_0_2_4.png")), new Color(102,102,102));
            runner2_2 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/4runner/4runner_0_2_3.png")), new Color(102,102,102));
            runner2_3 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/4runner/4runner_0_2_2.png")), new Color(102,102,102));
            runner2_4 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/4runner/4runner_0_2_1.png")), new Color(102,102,102));
            
            bluecar1 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/BlueCar1.png")), new Color(255,0,255));
            bluecar2 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/BlueCar2.png")), new Color(255,0,255));
            yellowcar1 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/YellowCar1.png")), new Color(255,0,255));
            yellowcar2 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/YellowCar2.png")), new Color(255,0,255));
            blackcar1 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/BlackCar1.png")), new Color(254,0,254));
            blackcar2 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/BlackCar2.png")), new Color(254,0,254));
            
            frogjumpup = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/FrogJump.png")), new Color(255,0,255));
            frogstillup = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/FrogStill.png")), new Color(255,0,255));
            
            frogstillright = ImageManipulator.rotate(frogstillup, 90);            
            frogjumpright = ImageManipulator.rotate(frogjumpup, 90);
            frogstilldown = ImageManipulator.rotate(frogstillright, 90);
            frogjumpdown = ImageManipulator.rotate(frogjumpright, 90);
            frogstillleft = ImageManipulator.rotate(frogstilldown, 90);
            frogjumpleft = ImageManipulator.rotate(frogjumpdown, 90);
            
            barrelSink1 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/BarrelSink1.png")), new Color(255,0,255));
            barrelSink2 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/BarrelSink2.png")), new Color(255,0,255));
            barrelSink3 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/BarrelSink3.png")), new Color(255,0,255));
            barrelSink4= ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/BarrelSink4.png")), new Color(255,0,255));
            
            logLong1 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/LogLong1.png")), new Color(255,0,255));
            logLong2 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/LogLong2.png")), new Color(255,0,255));
            
            logSink1 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/LogSink1.png")), new Color(255,0,255));
            logSink2 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/LogSink2.png")), new Color(255,0,255));
            logSink3 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/LogSink3.png")), new Color(255,0,255));
            logSink4 = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/LogSink4.png")), new Color(255,0,255));
            
            invisibleImage = ImageManipulator.makeColorTransparent(ImageIO.read(getClass().getResource("/Images/invisible.png")), new Color(255,0,255));
            
            initArrays();
        }        
        catch(Exception e){}
    }
    
    public void initArrays()
    {
        BarrelSink.add(barrelSink1);
        BarrelSink.add(barrelSink2);
        BarrelSink.add(barrelSink3);
        BarrelSink.add(barrelSink4);
        BarrelSink.add(invisibleImage);
        
        LogSink.add(logSink1);
        LogSink.add(logSink2);
        LogSink.add(logSink3);
        LogSink.add(logSink4);
        LogSink.add(invisibleImage);
        
        Runner1.add(runner1_1);
        Runner1.add(runner1_2);
        Runner1.add(runner1_3);
        Runner1.add(runner1_4);
        
        Runner2.add(runner2_1);
        Runner2.add(runner2_2);
        Runner2.add(runner2_3);
        Runner2.add(runner2_4);
    }
}
