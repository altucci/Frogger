package Canvas;

import Constants.*;
import FrogMotion.*;
import Rows.*;
import SoundSprites.*;
import Sprites.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable 
{
    private Dimension dimension;
    private Thread animation;
    private long AnnimationTimeInterval = 15;
    private long beginTime, endTime, totalTimeNew, totalTimeOld;
    private final long maxTime = 30L;
    private volatile boolean youDied, timeExpired, gameResetCheck, gamePaused, gamePausedCheck, levelCompleted, returnToHomeScreen, changeDistDifference;
    private volatile boolean repaintMessage;
    private boolean[] frogWins;
    private int lives, currentLevel, distDifference, score;
    private BufferedImage Background, StartScreen;
    final private SoundSprite backgroundMusic = new SoundSprite();
    final private SoundSprite ribbitSound = new SoundSprite();
    final private RowConstants myRows = new RowConstants();
    final private ImageConstants images = new ImageConstants();
    private ArrayList<Row> rows = new ArrayList<>();
    
    final private byte UP = 1, RIGHT = 2, DOWN = 3, LEFT = 4, NOT_MOVING = 0;
    private byte direction;
    private Sprite frog;
    private BufferedImage frogStillUpImg, frogJumpUpImg, frogStillRightImg, frogJumpRightImg, frogStillDownImg, frogJumpDownImg, frogStillLeftImg, frogJumpLeftImg;
    private int MaxWidth, MaxHeight;
    private String timeText;
    private String scoreText;
    
    public GamePanel()
    {  
        initializePanel();
    }
    
    public GamePanel(BottomPanel BPanel)
    {                  
        initializePanel();
    }
    
    final public void initializePanel()
    {
        setFocusable(true);
        
        gameResetCheck = true;
        gamePausedCheck = true;
        
        addKeyListener(new KeyStrokes());   
        
        dimension = new Dimension();    
        setDimension(Constants.DIMENSION);      
        
        ribbitSound.setFileName("/Sounds/FrogRibbit.wav");
        ribbitSound.loadClip();
        
        frogWins = new boolean[5];
        
        StartScreen = images.startScreen;
        
        loadBackgroundMusic(0);
        loadFrog();
        
        reset();
        
        setFocusable(true);
    }
    
    public void loadLevel(int lev)
    {
        loadBackgroundMusic(lev);
        loadRows(lev);
        loadBackground(lev);
    }       
    
    public void loadBackgroundMusic(int lev)
    {
        switch(lev)
        {
            case 1 -> {
                backgroundMusic.close();
                backgroundMusic.setFileName("/Sounds/FroggerBackgroundMusic1.wav");
                backgroundMusic.loadClip();
                backgroundMusic.play(true);
            }
            case 2 -> {
                
            }
            case 3 -> {
                
            }
            case 4 -> {
                
            }
            case 5 -> {
                
            }
            default -> {
                backgroundMusic.close();
                backgroundMusic.setFileName("/Sounds/FroggerBackgroundMusic1.wav");
                backgroundMusic.loadClip();
                backgroundMusic.play(true);
            }
        }
    }
    
    public void loadBackground(int lev)
    {
        Background = switch (lev) {
            case 1 -> images.background;
            case 2 -> images.background;
            case 3 -> images.background;
            case 4 -> images.background;
            case 5 -> images.background;
            default -> images.startScreen;
        };        
    }   
    
    public void loadRows(int lev)
    {
        rows = myRows.getRowsForLevel(lev);
    }    
    
    public void loadFrog()
    {
        frogStillUpImg = images.frogstillup;
        frogStillDownImg = images.frogstilldown;
        frogStillLeftImg = images.frogstillleft;
        frogStillRightImg = images.frogstillright;
        
        frogJumpUpImg = images.frogjumpup;
        frogJumpDownImg = images.frogjumpdown;
        frogJumpLeftImg = images.frogjumpleft;
        frogJumpRightImg = images.frogjumpright;
        
        frog = new FrogSprite((int)((Constants.DIMENSION.width/2)-(frogStillUpImg.getHeight()/2)), Constants.DIMENSION.height-frogStillUpImg.getHeight(), 4, 4, frogStillUpImg, this);
        
        ((FrogSprite)frog).start();
    }
    
    public void start()
    {
        if(this.animation == null)
        {
            this.animation = new Thread(this);
            this.animation.start();
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    @Override
    public void run()
    {
        while(true)
        {
            if (canContinuePlaying())
            {                
                calculateTime();
                
                update();
                
                repaint();
                
                try
                {
                    Thread.sleep(AnnimationTimeInterval);
                }
                catch(Exception ex)
                {

                }
            }
            
            if (repaintMessage)
            {
                repaint();
                
                repaintMessage = false;
            }
        }
    }
    
    public void update()
    {
        updateFrogMovements();
        updateRowMovements();
    }

    public void updateFrogMovements()
    {
        if (((FrogSprite)frog).isFinishedJumping())
        {
            switch (direction) {
                case RIGHT -> {
                    ((ImageSprite)frog).setImage(frogStillRightImg);
                    ((Sprite_2D)frog).setLocx(((Sprite_2D)frog).getLocx()+8);//(int)((1/6)*frogStillRightImg.getHeight()));
                    ribbitSound.play(false);
                }
                case DOWN -> {
                    ((ImageSprite)frog).setImage(frogStillDownImg);
                    ((Sprite_2D)frog).setLocy(((Sprite_2D)frog).getLocy()+8);//(int)((1/6)*frogStillDownImg.getHeight()));
                    ribbitSound.play(false);
                }
                case LEFT -> {
                    ((ImageSprite)frog).setImage(frogStillLeftImg);
                    ((Sprite_2D)frog).setLocx(((Sprite_2D)frog).getLocx()-8);//(int)((1/6)*frogStillLeftImg.getHeight()));
                    ribbitSound.play(false);
                }
                case UP -> {
                    ((ImageSprite)frog).setImage(frogStillUpImg);
                    ((Sprite_2D)frog).setLocy(((Sprite_2D)frog).getLocy()-8);//(int)((1/6)*frogStillUpImg.getHeight()));
                    ribbitSound.play(false);
                }
            }
            
            changeDistDifference = true;
            
            ((FrogSprite)frog).finalizeJump();
            
            ((FrogSprite)frog).setFinishedJumping(false);
        }
        
        if (!((FrogSprite)frog).isJumping())
        {
            detectCollisions();
        }
    }
    
    public void updateRowMovements() // updates the x, y coordinates of where images should be drawn
    {
        for(int i = 0; i<rows.size(); i++)
        {
            rows.get(i).update();
        }        
    }

    @Override
    public void paintComponent(Graphics g) 
    {
        g.setColor(Color.lightGray);
        g.drawImage(Background, 0, 0, this);

        animateRowMovements(g);
        animateFrogMovements(g);
                
        drawBottomPanel(g);
        
        drawFrogWins(g);
        
        drawMessages(g);
    }
    
    public void drawBottomPanel(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 624, 720, 6);
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 630, 720, 480);
        
        g.setFont(new java.awt.Font("OCR A Extended", 1, 18));
        g.setColor(Color.WHITE);
        g.drawString("Lives:", 18, 660);
        g.drawString("Time:", 312, 660);
        
        g.setFont(new java.awt.Font("OCR A Extended", 1, 24));
        g.setColor(Color.YELLOW);
        g.drawString(timeText, 384, 660);
        
        g.setFont(new java.awt.Font("OCR A Extended", 1, 18));
        g.setColor(Color.WHITE);
        g.drawString("Score:", 504, 660);
        
        g.setFont(new java.awt.Font("OCR A Extended", 1, 24));
        g.setColor(Color.RED);
        g.drawString(scoreText, 584, 660);
        
        for (int i = 0;i < (lives - 1);i++)
        {
            g.drawImage(frogStillUpImg, 96 + (i*48), 630, this);
        }
    }
    
    public void drawFrogWins(Graphics g)
    {
        for (int i = 0;i < 5;i++)
        {
            if (frogWins[i] == true)
            {
                g.drawImage(frogStillDownImg, 48 + (i * 144), 0, this);
            }
        }
    }
    
    public void drawMessages(Graphics g)
    {
        if (isGameReset())
        {
            g.setFont(new java.awt.Font("OCR A Extended", 1, 24));
            g.drawImage(StartScreen, 0, 0, this);
            g.setColor(Color.YELLOW);
            //g.drawString("Created By Albert Tucci and Nien Ly", ((int)(MaxWidth/2))-300, ((int)(MaxHeight/2))+56);
            g.drawString("Created by:  Al Tucci", ((int)(MaxWidth/2))-200, ((int)(MaxHeight/2))+56);
            g.setColor(Color.WHITE);            
            g.drawString("Press Spacebar to Start", ((int)(MaxWidth/2))-200, ((int)(MaxHeight/2))+104);
            g.drawString("Press Enter to Pause", ((int)(MaxWidth/2))-200, ((int)(MaxHeight/2))+152);
            g.drawString("Press Backspace to Reset", ((int)(MaxWidth/2))-200, ((int)(MaxHeight/2))+200);
        }
        else if (isGameOver())
        {
            g.setFont(new java.awt.Font("OCR A Extended", 1, 64));
            g.setColor(Color.RED);
            g.fillRect(((int)(MaxWidth/2))-275, ((int)(MaxHeight/2))-80, 550, 100);
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER!!!", ((int)(MaxWidth/2))-250, ((int)(MaxHeight/2))-10);
        }
        else if (isLevelCompleted())
        {
            g.setFont(new java.awt.Font("OCR A Extended", 1, 64));
            g.setColor(Color.WHITE);
            g.fillRect(((int)(MaxWidth/2))-350, ((int)(MaxHeight/2))-80, 700, 100);
            g.setColor(Color.RED);
            g.drawString("LEVEL " + String.valueOf(currentLevel) + " COMPLETE!", ((int)(MaxWidth/2))-340, ((int)(MaxHeight/2))-10);
        }
        else if (isFrogDead())
        {
            g.setFont(new java.awt.Font("OCR A Extended", 1, 64));
            g.setColor(Color.WHITE);
            g.fillRect(((int)(MaxWidth/2))-200, ((int)(MaxHeight/2))-80, 425, 100);
            g.setColor(Color.RED);
            g.drawString("YOU DIED!", ((int)(MaxWidth/2))-175, ((int)(MaxHeight/2))-10);
        }
        else if (isTimeExpired())
        {
            g.setFont(new java.awt.Font("OCR A Extended", 1, 64));
            g.setColor(Color.WHITE);
            g.fillRect(((int)(MaxWidth/2))-200, ((int)(MaxHeight/2))-80, 425, 100);
            g.setColor(Color.RED);
            g.drawString("TIMES UP!", ((int)(MaxWidth/2))-175, ((int)(MaxHeight/2))-10);
        }
        else if (isGamePaused())
        {
            g.setFont(new java.awt.Font("OCR A Extended", 1, 64));
            g.setColor(Color.RED);
            g.drawString("PAUSE", ((int)(MaxWidth/2))-100, ((int)(MaxHeight/2))-10);
        }
    }
    
    public void animateRowMovements(Graphics g)
    {
        BufferedImage img;        
        int x;
        int y;
        
        for(int i=0; i<rows.size(); i++)   
        {
            for (int j=0; j<rows.get(i).getNumOfImages(); j++)
            {
                if(rows.get(i).getRowType().equals("MultiImageRow") && ((MultiImageRow)rows.get(i)).animateThisImage(j))
                    img = ((MultiImageRow)rows.get(i)).getCurrentMultiImage();
                else
                    img = rows.get(i).getCurrentImage(); 
                
                x = rows.get(i).getPointX(j);
                y = rows.get(i).getPointY(j);
                g.drawImage(img, x, y, this);
            }
        }
    }
    
    public void animateFrogMovements(Graphics g)
    {
        frog.paint(g);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public void calculateTime()
    {
        endTime = System.nanoTime();

        totalTimeNew = maxTime - ((Math.round(((endTime - beginTime) / 1000000000) * 100)) / 100);

        if (totalTimeNew != totalTimeOld)
        {                
            totalTimeOld = totalTimeNew;
            
            int temp1 = (int)totalTimeNew/60;
            int temp2 = (int)totalTimeNew%60;
            
            timeText = "";
            
            if (temp2 < 10)
            {
                timeText = String.valueOf(temp1) + ":0" + String.valueOf(temp2);
            }
            else
            {
                timeText = String.valueOf(temp1) + ":" + String.valueOf(temp2);
            }
        }
    }
    
    private boolean canContinuePlaying()
    {
        return !(isGameReset() || isGameOver() || isFrogDead() || isLevelCompleted() || isGamePaused() || isTimeExpired());
    }
    
    private boolean hitWall()
    {
        int x = ((Sprite_2D)frog).getLocx();
        int y = ((Sprite_2D)frog).getLocy();
        
        return ((x + 9) < 0 || (x+((ImageSprite)frog).getImageWidth() - 9) > MaxWidth || (y + 9) < 0 || (y+((ImageSprite)frog).getImageHeight() - 9) > MaxHeight);
    }
    
    public void resetLives()
    {
        lives = 5;
    }
    
    private void detectCollisions()
    {
        boolean check = true;
        
        int frogX = ((Sprite_2D)frog).getLocx();
        
        if (hitWall())
        {
            youDied = true;
            
            if (lives == 1)
                lives--;
            
            return;
        }

        int frogRow = ((FrogSprite)frog).getRow();

        if (frogRow == -1)
        {
            return;
        }
        
        if (frogRow == -2)
        {
            for (int i = 0;check && i < 5;i++)
            {
                if (((frogX + (((FrogSprite)frog).getImageWidth()/2)) >= (48 + (i * 144))) && ((frogX + (((FrogSprite)frog).getImageWidth()/2)) <= (96 + (i * 144))))
                {
                    frogWins[i] = true;
                    
                    score += (10 * totalTimeNew);
                    
                    ((Sprite_2D)frog).setPosition((Constants.DIMENSION.width/2)-(((ImageSprite)frog).getImageWidth()/2), Constants.DIMENSION.height-((ImageSprite)frog).getImageHeight());
                    
                    if (allGoalsReached())
                    {
                        score += (100 * currentLevel);
                        //score += ((500 * currentLevel) * lives);
                        
                        if (lives < 5)
                        {
                            //lives++;
                        }
                        
                        levelCompleted = true;
                    }
                    
                    scoreText = String.valueOf(score);
                    
                    totalTimeNew = -1L;
                    totalTimeOld = -1L;
                    timeText = "0:30";
                    beginTime = System.nanoTime();
            
                    check = false;
                }
            }
            
            if (check)
            {
                youDied = true;
                
                if (lives == 1)
                    lives--;
            }
        }
        else if (frogRow < 5)
        {
            for (int i = 0;check && i < rows.get(frogRow).getNumOfImages();i++)
            {
                if (((frogX + ((FrogSprite)frog).getImageWidth() - 9) > rows.get(frogRow).getPointX(i)) && ((frogX + 9) < (rows.get(frogRow).getPointX(i) + rows.get(frogRow).getCurrentImage().getWidth())))
                {
                    youDied = true;
                    
                    if (lives == 1)
                        lives--;
                    
                    check = false;
                }
            }
        }
        else
        {
            for (int i = 0;check && i < rows.get(frogRow).getNumOfImages();i++)
            {
                if (((frogX + ((FrogSprite)frog).getImageWidth() - 24) >= rows.get(frogRow).getPointX(i)) && ((frogX + 24) <= (rows.get(frogRow).getPointX(i) + rows.get(frogRow).getCurrentImage().getWidth())))
                {
                    if (rows.get(frogRow).getRowType().equals("MultiImageRow"))
                    {
                        int currentImageFrogSitsOnIndex = ((MultiImageRow)rows.get(frogRow)).getCurrentImageIndex();
                        int invisibleImageIndex = ((MultiImageRow)rows.get(frogRow)).getImageArraySize()-1;
                        
                        if (currentImageFrogSitsOnIndex == invisibleImageIndex && ((MultiImageRow)rows.get(frogRow)).animateThisImage(i))//  <---  this is where the sinking logic would go.
                        {
                            youDied = true;
                            
                            if (lives == 1)
                                lives--;
                        }
                        else
                        {
                            if (changeDistDifference)
                            {
                                distDifference = (frogX - rows.get(frogRow).getPointX(i));

                                changeDistDifference = false;
                            }
                            
                            ((Sprite_2D)frog).setLocx(rows.get(frogRow).getPointX(i) + distDifference);
                        }
                    }
                    else
                    {                    
                        if (changeDistDifference)
                        {
                            distDifference = (frogX - rows.get(frogRow).getPointX(i));

                            changeDistDifference = false;
                        }
                        
                        ((Sprite_2D)frog).setLocx(rows.get(frogRow).getPointX(i) + distDifference);
                    }

                    check = false;
                }   
            }
            
            if (check)
            {
                youDied = true;
                
                if (lives == 1)
                    lives--;
            }
        }        
    }
    
    private void tryAgain()
    {
        direction = NOT_MOVING; 
        
        ((ImageSprite)frog).setImage(frogStillUpImg);
        
        ((Sprite_2D)frog).setPosition((Constants.DIMENSION.width/2)-(((ImageSprite)frog).getImageWidth()/2), Constants.DIMENSION.height-((ImageSprite)frog).getImageHeight());
        
        lives--;
        
        totalTimeNew = -1L;
        totalTimeOld = -1L;
        timeText = "0:30";
        beginTime = System.nanoTime();
        
        gamePaused = false;
        levelCompleted = false;
        youDied = false;
        timeExpired = false;
    }
    
    private boolean allGoalsReached()
    {
        for (int i = 0;i < 5;i++)
        {
            if (frogWins[i] == false)
            {
                return false;
            }
        }
        
        return true;
        
        /*
        //For testing LEVEL COMPLETE logic
        for (int i = 0;i < 5;i++)
        {
            if (frogWins[i] == true)
            {
                return true;
            }
        }
        
        return false;
        */
    }
    
    private void resetFrogWins()
    {
        for (int i = 0;i < 5;i++)
        {
            frogWins[i] = false;
        }
    }

    private void startNewGame()
    {
        direction = NOT_MOVING;
        
        ((ImageSprite)frog).setImage(frogStillUpImg);
        
        ((Sprite_2D)frog).setPosition((Constants.DIMENSION.width/2)-(((ImageSprite)frog).getImageWidth()/2), Constants.DIMENSION.height-((ImageSprite)frog).getImageHeight());
                
        resetFrogWins();
        
        resetLives();
        
        AnnimationTimeInterval = 35;
        
        score = 0;        
        scoreText = "0";
        
        totalTimeNew = -1L;
        totalTimeOld = -1L;
        timeText = "0:30";
        beginTime = System.nanoTime();
        
        currentLevel = 1;
        loadLevel(1);
        
        changeDistDifference = false;
        levelCompleted = false;
        youDied = false;
        timeExpired = false;
        gamePaused = false;
        returnToHomeScreen = false;
        repaintMessage = false;
    }

    private void startNextLevel()
    {
        direction = NOT_MOVING;
        
        ((ImageSprite)frog).setImage(frogStillUpImg);
        
        ((Sprite_2D)frog).setPosition((Constants.DIMENSION.width/2)-(((ImageSprite)frog).getImageWidth()/2), Constants.DIMENSION.height-((ImageSprite)frog).getImageHeight());
                
        resetFrogWins();
        
        lives++;
        
        double fConversion = 0.8;
        AnnimationTimeInterval = (long)((double)AnnimationTimeInterval * fConversion);
        
        totalTimeNew = -1L;
        totalTimeOld = -1L;
        timeText = "0:30";
        beginTime = System.nanoTime();
        
        loadLevel(++currentLevel);      //<--- This is not working for me.
        levelCompleted = false;
        //changeDistDifference = false;
        //youDied = false;
        timeExpired = false;
        //gamePaused = false;
        //returnToHomeScreen = false;
        //repaintMessage = false;
    }
    
    public boolean isLevelCompleted()
    {
        return levelCompleted;
    }
    
    public boolean isGamePaused()
    {
        return gamePaused;
    }
    
    private boolean isGameReset()
    {
        return returnToHomeScreen;
    }
    
    public void pause()
    {
        if (gamePaused)
        {
            beginTime = System.nanoTime() - (endTime - beginTime);

            gamePaused = false;
        }
        else
        {
            repaintMessage = true;
            
            gamePaused = true;
        }
    }
    
    private void reset()
    {
        startNewGame();
        
        returnToHomeScreen = true;
        
        repaintMessage = true;
    }
    
    public boolean isFrogDead()
    {
        return youDied;
    }
    
    private boolean isTimeExpired()
    {
        if (totalTimeNew == 0 && !timeExpired)
        {
            if (lives == 1)
                lives--;
            
            repaintMessage = true;
            
            timeExpired = true;
        }
        
        return totalTimeNew == 0;
    }
    
    public boolean isGameOver()
    {
        return (lives == 0);
    }

    public Dimension getDimension() {
        
        return dimension;
    }

    public void setDimension(Dimension dim) {
        
        dimension = dim;
        
        if (dimension != null)
        {
            MaxWidth = dimension.width;
        
            MaxHeight = dimension.height;
        }
    }
    
    private class KeyStrokes extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent ke) {
            
            if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE)
            {
                if (gameResetCheck)
                {
                    reset();

                    gameResetCheck = false;
                }
            }
            else if (ke.getKeyCode() == KeyEvent.VK_SPACE)
            {
                if (!isGameOver())
                {
                    if (isGameReset())
                    {
                        startNewGame();
                    }
                    else if (isLevelCompleted())
                    {
                        startNextLevel();
                    }
                    else if (isFrogDead())
                    {
                        tryAgain();
                    }
                    else if (isTimeExpired())
                    {
                        tryAgain();
                    }
                }
            }
            else if (!(isGameOver() || isLevelCompleted() || isFrogDead() || isTimeExpired() || ((FrogSprite)frog).isJumping()))
            {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    if (gamePausedCheck)
                    {
                        pause();
                        
                        gamePausedCheck = false;
                    }
                }
                
                if (!(isGamePaused()))
                {
                    switch (ke.getKeyCode()) {
                        case KeyEvent.VK_RIGHT -> {
                            direction = RIGHT;
                            ((ImageSprite)frog).setImage(frogJumpRightImg);
                            ((Sprite_2D)frog).initMotion(new MotionRight());
                            ((FrogSprite)frog).setJumping(true);
                        }
                        case KeyEvent.VK_DOWN -> {
                            direction = DOWN;
                            ((ImageSprite)frog).setImage(frogJumpDownImg);
                            ((Sprite_2D)frog).initMotion(new MotionDown());
                            ((FrogSprite)frog).setJumping(true);
                        }
                        case KeyEvent.VK_LEFT -> {
                            direction = LEFT;
                            ((ImageSprite)frog).setImage(frogJumpLeftImg);
                            ((Sprite_2D)frog).initMotion(new MotionLeft());
                            ((FrogSprite)frog).setJumping(true);
                        }
                        case KeyEvent.VK_UP -> {
                            direction = UP;
                            ((ImageSprite)frog).setImage(frogJumpUpImg);
                            ((Sprite_2D)frog).initMotion(new MotionUp());
                            ((FrogSprite)frog).setJumping(true);
                        }
                        default -> {
                        }
                    }
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            
            if (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE)
            {
                gameResetCheck = true;
            }
            else if (ke.getKeyCode() == KeyEvent.VK_ENTER)
            {
                gamePausedCheck = true;
            }
        }
    }
}