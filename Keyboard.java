import greenfoot.*;
/**
 * Write a description of class Keyboard here.
 * 
 * David Chen
 * @version (a version number or a date)
 * PacMan CMPE202
 */
public class Keyboard  
{
    // instance variables - replace the example below with your own
   private Command cmd;

    /**
     * Constructor for objects of class Keyboard
     */
    public Keyboard()
    {
    }
    public void setCommand(Command cmd)
   {
      this.cmd = cmd;
   }
   
    public void invoke1()
   {
      cmd.execute1();
   }
}
