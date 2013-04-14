import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MoveStrategy here.
 * 
 * @author (Ai-Phuong Le) 
 * @version (12/2/2012)
 */
public interface MoveStrategy
{
    /**
     * Act - do whatever the MoveStrategy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public void move(Ghost go);    
  
}
