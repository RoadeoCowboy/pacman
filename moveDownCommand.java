import greenfoot.*;
/**
 * Write a description of class moveDownCommand here.
 * 
 * David Chen
 * @version (a version number or a date)
 * PacMan CMPE202
 */
public class moveDownCommand implements Command
{
    // instance variables - replace the example below with your own
    PacMan receiver;

    /**
     * Constructor for objects of class moveDownCommand
     */
    public moveDownCommand(PacMan receiver)
    {
        this.receiver = receiver;
    }
    
    public void execute1()
    {
        receiver.right();
    }
}
