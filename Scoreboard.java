import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor implements ScoreboardInterface
{
    public static int FONT_SIZE = 12;
    public static int WIDTH = 420;
    public static int HEIGHT = 50;
    public static int LOCX = 210;
    public static int LOCY = 466;
    
    Message m = new Message(WIDTH,HEIGHT);
    int time;
    int score;
    int level;
    int lives;
    String msg;
    public void act() 
    {
        this.getImage().clear();
        update();
        display();
    }    
    public void update()
    {
        java.util.List<Lives> LivesList = this.getWorld().getObjects(Lives.class);//give coin to inspector
        lives = LivesList.get(0).getLives();
        java.util.List<Score> ScoreList = this.getWorld().getObjects(Score.class);//give coin to inspector
        score = ScoreList.get(0).getScore();
        java.util.List<Level> LevelList = this.getWorld().getObjects(Level.class);//give coin to inspector
        level = LevelList.get(0).getLevel();

        java.util.List<Time> TimeList = this.getWorld().getObjects(Time.class);//give coin to inspector
        int t = TimeList.get(0).getTime();
        if(t > time + 1)//if the game was paused
        {
            TimeList.get(0).setTime(time);
        }
        else
            time = t;
        //score = (Score)(this.getWorld().getObjects(Score.class).get(0)).getScore();
        //lives = this.getWorld().getObjects(Lives.class).get(0).getLives();
        msg = "Lives: " + lives + "    Level: " + level + "    Score: " + score + "    Time: " + time;
    }
    
    public void hide()
    {
        
    }
    public void display()
    {  
        World world = getWorld();
        if ( m.getWorld() != null )
        {
            world.removeObject( m );
        }
        world.addObject( m, LOCX, LOCY );
        m.setText( msg,30,30) ;
    }
}
