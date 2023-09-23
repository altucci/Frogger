package Canvas;

import Constants.Constants;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class Frame extends JApplet
{
    public GamePanel pane;
    //public BottomPanel bottomPane;
    
    @Override
    public void init()
    {        
//        bottomPane = new BottomPanel();
//        bottomPane.setBackground(Color.BLACK);
//        add(bottomPane, BorderLayout.SOUTH);
        
        pane = new GamePanel();
        pane.setFocusable(true);
        pane.requestFocus();
        pane.setFocusable(true);
        pane.start();
        pane.setFocusable(true);
        pane.requestFocus();
        pane.setFocusable(true);   
        add(pane);
        
        pane.setFocusable(true);
        pane.requestFocus();
    }
    
    public static void main(String[] args)
    {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(Constants.DIMENSION.width+14,Constants.DIMENSION.height+Constants.BOTTOMPANEL_DIMENSION.height+36);
        //mainFrame.setSize(Constants.DIMENSION.width,Constants.DIMENSION.height+Constants.BOTTOMPANEL_DIMENSION.height);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(3);
        
        Frame app = new Frame();
        mainFrame.add(app);
        app.setLocation(0,0);
        app.setSize(Constants.DIMENSION);
        app.init();
        app.pane.setFocusable(true);
        app.pane.requestFocus();
        mainFrame.validate();
    }
}
