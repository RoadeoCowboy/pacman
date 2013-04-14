import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lives extends ScoreboardElement
{
    int lives = 1;
    private static Lives instance;
    private Lives() {
        this.getImage().clear();
    }

    public static Lives getInstance() {
        if (instance == null) {
            instance = new Lives();
        }
        return instance;
    }
    public void act() 
    {
        // Add your action code here.
        this.getImage().clear();
    }    
    public void update()
    {
        
    }
    
    public int getLives()
    {
        return lives;
    }
}
