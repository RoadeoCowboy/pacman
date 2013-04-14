import greenfoot.*;
/**
 * Write a description of class moveUpCommand here.
 * 
 * David Chen
 * @version (a version number or a date)
 * PacMan CMPE202
 */
public class moveUpCommand implements Command
{
    // instance variables - replace the example below with your own
   private int x;
   PacMan receiver;
    /**
     * Constructor for objects of class moveUpCommand
     */
    public moveUpCommand(PacMan receiver)
    {
        this.receiver = receiver;
    }
    public void execute1()
    {
        receiver.up();
    }
}
