/**
 * Write a description of class RightState here.
 * 
 * @author Marc Valente
 * @version (a version number or a date)
 */
public class RightState extends DirectionState 
{
    public RightState(PacMan pac) {
        super(pac);
        // TODO Auto-generated constructor stub
    }
    public void moveLeft() {
        pman.turn(180);
        pman.setDirection(pman.getFacingLeftState());
        //pman.setLocation(pman.getX() - 1, pman.getY());
      //  pman.x = pman.x - 21;
            
    }
    public void moveDown() {
        pman.turn(90);
        pman.setDirection(pman.getFacingDownState());
        //pman.setLocation(pman.getX(), pman.getY() + 1);
     //   pman.y = pman.y + 21;     
    }
    public void moveUp() {
        pman.turn(-90);
        pman.setDirection(pman.getFacingUpState());
     //   pman.setLocation(pman.getX(), pman.getY() - 1);
   //     pman.y = pman.y - 21;

    }
    public void moveRight(){
     //   pman.setLocation(pman.getX() + 1, pman.getY());
   //    pman.x = pman.x + 21;

       }
}
