package SoundSprites;

import java.text.DecimalFormat;
import javax.sound.sampled.*;
        
public class SoundSprite implements LineListener
{
    private String name, filename;
    private Clip clip = null;
    private boolean isLooping = false;
    private DecimalFormat df;
    
    public SoundSprite()
    {    
    }
    
    public void setFileName(String filename)
    {
        this.filename = filename;
    }
    
    public String getFileName()
    {
        return filename;
    }
    
    public void loadClip()
    {
        try
        {
            AudioInputStream stream = AudioSystem.getAudioInputStream(getClass().getResource(getFileName()));
            AudioFormat format = stream.getFormat();
            
            if((format.getEncoding() == AudioFormat.Encoding.ULAW) || (format.getEncoding() == AudioFormat.Encoding.ALAW))
            {
               AudioFormat newFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format.getSampleRate(),format.getSampleSizeInBits()*2,format.getChannels(),format.getFrameSize()*2,format.getFrameRate(), true); 
               stream = AudioSystem.getAudioInputStream(newFormat,stream);
               format = newFormat;
            }
            
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip)AudioSystem.getLine(info);
            clip.addLineListener(this);
            clip.open(stream);
            stream.close();
            
//            checkDuration();
        }
        catch(Exception e)
        { 
        }
    }
    
//    private void checkDuration()
//    {
//        double duration = clip.getMicrosecondLength()/1000000.0;
//        
//    }
    
    public void update(LineEvent lineEvent)
    {
        if(lineEvent.getType() == LineEvent.Type.STOP)
        {
            clip.stop();
            clip.setFramePosition(0);
            if(!isLooping)
            {
            }
            else
            {
                clip.start();
            }
        }
        
    }
    
    public void close()
    {
        if(clip != null)
        {
            clip.stop();
            clip.close();
        }
    }
    
    public void play(boolean toLoop)
    {
        if(clip !=  null)
        {
            isLooping = toLoop;
            clip.start();
        }
    }
    
    public void stop()
    {
        if(clip != null)
        {
            isLooping = false;
            clip.stop();
            clip.setFramePosition(0);
            
        }
    }
    
    public void pause()
    {
        if(clip != null)
            clip.stop();
    }
    
    public void resume()
    {
        if(clip != null)
            clip.start();
    }
}
