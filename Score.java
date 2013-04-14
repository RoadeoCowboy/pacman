import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends ScoreboardElement
{
    private static Score instance;
    private Score() {
        this.getImage().clear();
    }

    public static Score getInstance() {
        if (instance == null) {
            instance = new Score();
        }
        return instance;
    }
    int score = 0;

    public void act() 
    {
        // Add your action code here.
        
    }  
    public void update()
    {
        observerState = GameBoard.getInstance().getState();
        if (observerState == "PacDot")
            score += 10;
        else if (observerState == "PowerPellet")
            score += 50;
        else if (observerState == "Cherry")
            score += 200;
        else if (observerState == "Strawberry")
            score += 400;
        else if (observerState == "Orange")
            score += 600;
        else if (observerState == "Apple")
            score += 800;
        else if (observerState == "Melon") 
            score += 1000;
        else if (observerState == "Galaxian")
            score += 1200;
        else if (observerState ==  "Bell")
            score += 1400;
        else if (observerState == "Key")
            score += 1600;
        else
            System.out.println(observerState);
    }
    
    public int getScore()
    {
        return score;
    }
}
