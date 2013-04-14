import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends ScoreboardElement
{
    int level = 1;
     private static Level instance;
    private Level() {
        this.getImage().clear();
    }

    public static Level getInstance() {
        if (instance == null) {
            instance = new Level();
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
    public int getLevel()
    {
        return level;
    }
}
