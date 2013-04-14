import greenfoot.*;

/**
 * A piece of Food is a GamePiece and can be eaten
 * 
 * @author Caleb Chow
 */
public abstract class Food extends GamePiece
{
    public enum FoodType { PowerPellet, PacDot, Fruit }
    
    public void eat()
    {
        // Remove from world
        if(this instanceof PacDot) 
            Greenfoot.playSound("Pacman_Waka_Waka.mp3");
        getWorld().removeObject(this);
        
        // Set the state
        if(this instanceof Fruit)
            setState(((Fruit)this).getType().toString());
        else
            setState(getClass().getName());
    }
}
