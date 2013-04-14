import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ConfirmBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    private GreenfootImage gi;
    private MouseInfo mouse;
    public GameOver(){
    
        gi = getImage();
        gi.scale(100,100);
        gi.drawString("Game Over!",15,50);
        Greenfoot.playSound("Pacman_Dies.mp3");
    }
    /**
     * Act - do whatever the ConfirmBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //mouse = Greenfoot.getMouseInfo();
        
        if(Greenfoot.mouseClicked(this)){
        Greenfoot.start();
        getWorld().removeObject(this);
        }
        // Add your action code here.
    }    
}
