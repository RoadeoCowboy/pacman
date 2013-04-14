import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * 
 * @author (Ai-Phuong Le) 
 * @version (12/2/2012)
 */

public class Inky extends Ghost
{
    static GreenfootImage baseImage = new GreenfootImage("inky.png");
    static GreenfootImage ghostImage = new GreenfootImage("ghost.png");
    
    GameBoard gb;
    private static Inky inky;
    private Inky(){
        super();   
        baseImage.scale(20,20);
        ghostImage.scale(20,20);
        gdx = 12; // 262
        gdy = 12; // 262
        setImage(baseImage);
    }    
    
    public static Inky getInky(){
        
        if(inky==null){
            inky = new Inky();
            isWeak = false;
        }
        return inky;
    }
    
    static int counter = -1;
    
    public void setStrategy(boolean isw){
        counter = 20;
        isWeak = isw;
        inky.setImage(Inky.ghostImage);
        inky.setMoveStrategy(new Run());
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
               inky.setImage(Inky.baseImage);
               inky.setMoveStrategy(new Chase());
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
