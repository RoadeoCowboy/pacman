import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pinky here.
 * 
 * @author (Ai-Phuong Le) 
 * @version (12/2/2012)
 */
public class Clyde extends Ghost
{ 
    static GreenfootImage baseImage = new GreenfootImage("clyde.png");
    static GreenfootImage ghostImage = new GreenfootImage("ghost.png");
    GameBoard gb;
    private static Clyde clyde;
    
    private Clyde(){
        super();   
        baseImage.scale(20,20);
        ghostImage.scale(20,20);
        gdx = 4; // 94
        gdy = 4; // 94
        setImage(baseImage);
        setMoveStrategy(new Chase());
    }    
    
    public static Clyde getClyde(){
        
        if(clyde==null){
            clyde = new Clyde();
            isWeak = false;
        }
        return clyde;
    }
    
static int counter = -1;
    
    public void setStrategy(boolean isw){
        counter = 20;
        isWeak = isw;
        clyde.setImage(Clyde.ghostImage);
        clyde.setMoveStrategy(new Run());
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
               clyde.setImage(Clyde.baseImage);
               clyde.setMoveStrategy(new Chase());
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
