import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author (Ai-Phuong Le) 
 * @version (12/2/2012)
 */

public class Pinky extends Ghost
{
    static GreenfootImage baseImage = new GreenfootImage("pinky.png");
    static GreenfootImage ghostImage = new GreenfootImage("ghost.png");

    GameBoard gb;
    private static Pinky pinky;

    private Pinky(){
        super();   
        baseImage.scale(20,20);
        ghostImage.scale(20,20);
        gdx = 1;
        gdy = 1;
        setImage(baseImage);
    }    
    
    public static Pinky getPinky(){
        
        if(pinky==null){
            pinky = new Pinky();
            isWeak = false;
        }
        return pinky;
    }

    static int counter = -1;
    
    public void setStrategy(boolean isw){
        counter = 20;
        isWeak = isw;
        pinky.setImage(Pinky.ghostImage);
        pinky.setMoveStrategy(new Run());
    }
   


    
    /**
     * Act - do whatever the Pinky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    
    public void act() 
    {
       
        try {
           
            try {
           
            doMoveStrategy();
            if(counter > 0)
                counter --;
                
            else if(counter==0)
            {
               isWeak = false;
               pinky.setImage(Pinky.baseImage);
               pinky.setMoveStrategy(new Chase());
               counter--;
            }    
                
            if(!isWeak)  // set back to base
            {
               foundPacMan();  
               
            }    
           
           
           
        } 
        catch (Exception c) {}
           
        } 
        catch (Exception c) {}
    
    }   
   
}
