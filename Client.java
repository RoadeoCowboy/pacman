import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Client here.
 * 
 * David Chen
 * @version (a version number or a date)
 * CMPE202 PacMan Project
 */
public class Client extends Actor
{
    /**
     * Act - do whatever the Client wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Keyboard new_player1 = new Keyboard();
        //PacMan move = new PacMan();
        
        moveUpCommand up = new moveUpCommand(PacMan.getInstance());
        new_player1.setCommand(up);
        new_player1.invoke1();
        
        moveDownCommand down = new moveDownCommand(PacMan.getInstance());
        new_player1.setCommand(down);
        new_player1.invoke1();
        
        moveLeftCommand left = new moveLeftCommand(PacMan.getInstance());
        new_player1.setCommand(left);
        new_player1.invoke1();
        
        moveRightCommand right = new moveRightCommand(PacMan.getInstance());
        new_player1.setCommand(right);
        new_player1.invoke1();
        System.out.println("Hello World!");
    }   
    
}
