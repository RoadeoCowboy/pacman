import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreboardElement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreboardElement extends Actor implements Observer
{
    String observerState;
    GameBoard concreteSubject = GameBoard.getInstance();
    
    public void act() 
    {
        // Add your action code here.
        
    }  
    
    public void update(){}
    public void showState()
    {
        System.out.println( "Observer: " + this.getClass().getName() + " = " + observerState);
    }
    
}
