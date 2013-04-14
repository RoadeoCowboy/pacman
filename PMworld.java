import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * version 3 12/3/2012 Katie:  added codes from Ghosts and their components
 * 
 * @author (Waka Waka) 
 * @version 
 */
public class PMworld extends World
{

    
      
    /**
     * Constructor for objects of class pmworld.
     * 
     */
    public PMworld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(420, 490, 1);
        addObject(GameBoard.getInstance(),210,220);
        addObject(Time.getInstance(),31,60);
        addObject(Lives.getInstance(),136,60);
        addObject(Score.getInstance(),31,31);
        addObject(Level.getInstance(),136,94);
        addObject(new Scoreboard(), 100,100);
        setPaintOrder(GameOver.class);
        
        //initialize scoreboard observer pattern
        GameBoard.getInstance().attach(Time.getInstance());
        GameBoard.getInstance().attach(Score.getInstance());
        GameBoard.getInstance().attach(Level.getInstance());
        GameBoard.getInstance().attach(Lives.getInstance());
        
        
        addObject(Pinky.getPinky(),31,31);  // 6 = (1,1)
        addObject(PacMan.getInstance(),199,304); // {9,14}
       
        addObject(Clyde.getClyde(),94  ,94);  //   5 = (9, 15 ) = 199  ,325
        addObject(Inky.getInky(),262, 262);    // (14 ,6 ) = 136 ,52
        addObject(Blinky.getBlinky(),178,178);  // 4 = ( 8 , 10) = 178,220 
    }
}
