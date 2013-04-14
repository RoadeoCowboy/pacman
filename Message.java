import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{
    GreenfootImage gi;

    public Message(int width, int height)
    {
        gi = new GreenfootImage( width, height);
        setImage(gi);        
    }

    public void setText( String msg, int x, int y)
    {
        gi.clear();
        gi.setColor( java.awt.Color.BLACK );
        gi.fill() ;
        java.awt.Font font = gi.getFont();
        gi.setFont(gi.getFont().deriveFont(java.awt.Font.BOLD, 18));
        font = gi.getFont();
        gi.setColor( java.awt.Color.YELLOW );
        gi.drawString( msg, x, y );  
    }

    public void act() 
    {
        
    }    
}
