import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author (Ai-Phuong Le) 
 * @version (12/2/2012)
 */

public abstract class Ghost extends Actor //implements GamePiece
{
    public int gdx;
    public int gdy;
 
    public static boolean isWeak;   
    private MoveStrategy moveStrategy;
    GameBoard game;
    
    public Ghost()
    {  
        isWeak = false;
        moveStrategy = new Chase();
    }    

    
    public int getDy()
    {
        return gdy;
    }
    
    public void setDy(int i)
    {
        gdy = i;    
    }
    
    public int getDx()
    {
        return gdx;
    }
    
    public void setDx(int i)
    {
        gdx = i;    
    }
    
    public boolean setMoveStrategy(MoveStrategy s)
    {
        moveStrategy = s;
        return true;
    }
    
    public void doMoveStrategy()
    {
        try{
            moveStrategy.move(this);
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }    
    } 
    
    public boolean foundPacMan()
    {
        Actor actor = (PacMan) getOneObjectAtOffset(0,0, PacMan.class);
        if(actor != null)
        { 
            PacMan pacman = PacMan.getInstance();
            getWorld().removeObject(pacman);
            getWorld().addObject(new GameOver(),200,240);
            Greenfoot.stop();
            return true;
        }    
        else
            return false;
    } 
    
    public void update()
    {
        // pacman eats special pellet
        if(game.getState().equalsIgnoreCase("powerOn"))
        {
            // ghost should stay away from pacman
            isWeak = true;
            //setMoveStrategy(new Run());
        }    
        else
        {
            isWeak = false;
            //setMoveStrategy(new Chase());
        }   
        
    }   
      
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void eat()
    {
        // Remove from world
        if(isWeak)
            getWorld().removeObject(this);
    }
}
