import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Jared Muise)
 * Teacher Mr.Hardman
 * Lab #2 GifLab
 * Date Last Modified: March 23/2017
 */
public class MyWorld extends World
{
    private long startTime;
    private GreenfootSound soundFile = new GreenfootSound("Black Goku and Zamasu talk about their Zero Mortals Plan.wav");
    
    
    private final int IMAGE_COUNT = 40;
    
    private GreenfootImage[] images = new GreenfootImage[IMAGE_COUNT];
    
    private int slowness = 4;
    private int gifSpeedCounter = 0;
    private int actCycle = 0;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(407, 226, 1); 
        for( int i = 0; i < images.length; i++ )
        {
           images[i] = new GreenfootImage( "frame_" + i + "_delay-0.1s.gif");
           
        }
        
        setBackground(images[0]);
        
    }
    
    /**
     * Act plays the gif at a constant loop.
     * Also plays the sound that matches the start of the gif.
     * 
     * @params There are no parametres 
     * 
     * @return There is nothing to retrun.
     */
    public void act()
    {
        setBackground(images[actCycle%images.length]);
        
        if(gifSpeedCounter == slowness)
        {
           actCycle ++;
           gifSpeedCounter = 0;
        }
        else
        {
            gifSpeedCounter ++;
            
        }
        
        if( actCycle % images.length == 0 )
        {
            soundFile.stop();
            soundFile.play();
            startTime = System.currentTimeMillis();
            Started();
        }
        
    }
    
    /**
     * slowness makes it that you can set the slowness of the gif to very slow
     * or very fast.
     */
    public void setSlowness(int slow)
    {
        slowness = slow;
    }
    
    public void Started()
    {
        soundFile.play();
    }
   
}
