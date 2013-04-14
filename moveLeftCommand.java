import greenfoot.*;
/**
 * Write a description of class moveLeftCommand here.
 * 
 * David Chen 
 * @version (a version number or a date)
 * PacMan CMPE202
 */
public class moveLeftCommand implements Command
{
    // instance variables - replace the example below with your own
    PacMan receiver;
    // instance variables - replace the example below with your own
 

    /**
     * Constructor for objects of class moveLeftCommand
     */
  
    public moveLeftCommand(PacMan receiver)
    {
        this.receiver = receiver;
    }
    public void execute1()
    {
        receiver.left();
    }
}
