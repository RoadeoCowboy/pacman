import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Time here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Time extends ScoreboardElement
{
    private static Time instance;
    private Time() {
        this.getImage().clear();
    }

    public static Time getInstance() {
        if (instance == null) {
            instance = new Time();
        }
        return instance;
    }
    int time = 0;
    java.util.Timer timer = new java.util.Timer("Counter");
    boolean TimerON;
    
    public void finalize()
    {
        //do finalization here
       timer.cancel();
    } 
    public int getTime()
    {
        return time;
    }
    
    public void setTime(int t)
    {
        time = t;
    }
    
    public void initialize()
    {
        TimeTask keepTime = new TimeTask();
        timer.schedule(keepTime,1000,1000);
    }
    
    class TimeTask extends java.util.TimerTask {
     public void run() 
    {
        time++;
        //System.out.println(time);
    }
    
    }
    public void act() 
    {
        if(TimerON != true)
        {
            initialize();
            TimerON = true;
        }
        
        
    } 
    
    
}
