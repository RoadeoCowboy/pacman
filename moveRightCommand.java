import greenfoot.*;
/**
 * Write a description of class moveRightCommand here.
 * 
 * David Chen
 * @version (a version number or a date)
 * PacMan CMPE202
 */
public class moveRightCommand implements Command
{
    // instance variables - replace the example below with your own
    PacMan receiver;
    /**
     * Act - do whatever the moveRightCommand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    public moveRightCommand(PacMan receiver)
    {
        this.receiver = receiver;
    }
    
    public void execute1()
    {
        receiver.right();
    }
}
