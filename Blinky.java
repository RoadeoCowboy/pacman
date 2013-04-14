import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author (Ai-Phuong Le) 
 * @version (12/2/2012)
 */

public class Blinky extends Ghost
{ 
    static GreenfootImage baseImage = new GreenfootImage("blinky.png");
    static GreenfootImage ghostImage = new GreenfootImage("ghost.png");

    GameBoard gb;
    private static Blinky blinky;
    private Blinky(){
        super();   
        baseImage.scale(20,20);
        ghostImage.scale(20,20);
        gdx = 8; // 178
        gdy = 8; // 178
        setImage(baseImage);
    }    
    
    public static Blinky getBlinky(){
        
        if(blinky==null){
            blinky = new Blinky();
            isWeak = false;
        }
        return blinky;
    }
    
static int counter = -1;
    
    public void setStrategy(boolean isw){
        counter = 20;
        isWeak = isw;
        blinky.setImage(Blinky.ghostImage);
        blinky.setMoveStrategy(new Run());
    }
    
    /**
     * Act - do whatever the Pinky wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
  
    public void act() 
    {
       
        try {
           
            doMoveStrategy();
            if(counter > 0)
                counter --;
                
            else if(counter==0)
            {
               isWeak = false;
               blinky.setImage(Blinky.baseImage);
               blinky.setMoveStrategy(new Chase());
               counter--;
            }    
                
            if(!isWeak)  // set back to base
            {
               foundPacMan();  
               
            }    
           
           
           
        } 
        catch (Exception c) {}
    
    }   
   
}
