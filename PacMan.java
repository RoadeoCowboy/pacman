import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pac_Man here.
 * 
 * @author Marc Valente For State Pattern move 
 * @author David Chen For Command Pattern input
 * @version (a version number or a date)
 */
public class PacMan extends GamePiece
{
        GreenfootImage gi;
        int dx = 9;
        int dy = 14;
        int x; 
        int y;
        World wr;
        String key;

        Direction facingDownState;
        Direction facingUpState;
        Direction facingLeftState;
        Direction facingRightState;
        Direction currentDirectionState;
        
        private static PacMan pacman;
        
        public static PacMan getInstance(){
            if(pacman==null){
                pacman = new PacMan();
            }
            return pacman;
        }
        
        public PacMan(){
            facingDownState = new DownState(this);
            facingUpState = new UpState(this);
            facingLeftState = new LeftState(this);
            facingRightState = new RightState(this);
            currentDirectionState = facingRightState;
            gi = getImage();
            gi.scale(20, 20);

        }
        
        public void setDirection(Direction thisWay){
            currentDirectionState = thisWay;
        }
        public Direction getFacingDownState(){
            return facingDownState;
        }
        public Direction getFacingUpState(){
            return facingUpState;
        }
        public Direction getFacingLeftState(){
            return facingLeftState;
        }
        public Direction getFacingRightState(){
            return facingRightState;
        }
        
        public void up()
        {
      //      if (dy>0&&GameBoard.maze[dy - 1][dx] != 1 )
       //     {
       //      System.out.println("Direction is up.");
        //      dy = dy - 1;
             currentDirectionState.moveUp();
         //   }
        }
        
        public void down()
        {
        //     if (dy<21&&GameBoard.maze[dy + 1][dx] != 1)
        //     {
            //System.out.println("Direction is down.");
     //       dy = dy + 1;
            currentDirectionState.moveDown();
        //}
        }
        
        public void left()
        {
        //    if (dx>0&&GameBoard.maze[dy][dx - 1] != 1)
        //    {
             //System.out.println("Direction is left.");
      //       dx = dx - 1;
             currentDirectionState.moveLeft();
        //    }
        }
        
        public void right()
        {
            //System.out.println("Direction is right.");
        //    if(dx<20&&GameBoard.maze[dy][dx + 1] != 1)
        //    {
             currentDirectionState.moveRight();
       //     dx = dx + 1;
        //    }
        }
        
        public void eatFood()
        {
         Food food = (Food)getOneIntersectingObject(Food.class);
           food.eat();
        }
        
      
    
    /**
     * Act - do whatever the Pac_Man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
              wr = getWorld();
        x = this.getX();
        y = this.getY();
       key = Greenfoot.getKey();
   
  //      if(Greenfoot.isKeyDown("up"))
  //      {
  //          up();
  //          dy = dy - 1;
  //          setLocation(x, y);
  //      }
  //     if(Greenfoot.isKeyDown("down"))
   //     {
   //       down();
   //        dy = dy + 1;
   //         setLocation(x, y); 
   //    }
   //     if(Greenfoot.isKeyDown("left"))
   //     {
   //         left();
   //          dx = dx - 1;
   //         setLocation(x, y); 
  //      }
  //      if(Greenfoot.isKeyDown("right"))
   //     {
   //         right();
   //          dx = dx + 1;
    //        setLocation(x, y); 
    //    }
    if (dx<20&&GameBoard.maze[dy][dx + 1] != 1 && (key=="right")) {
            x = x + 21;
            dx = dx + 1;
            right();
           // System.out.println(dx+" "+dy+"xxxx"+GameBoard.maze[dy][dx+1]);
          
        } else if (dy<21&&GameBoard.maze[dy + 1][dx] != 1
                && (key=="down")) {
           y = y + 21;
           dy = dy + 1;
           down();
          
        } else if (dx>0&&GameBoard.maze[dy][dx - 1] != 1
                && (key=="left")) {
           x = x - 21;
            dx = dx - 1;
            left();
        
        } else if (dy>0&&GameBoard.maze[dy - 1][dx] != 1 && (key=="up")) {
           y = y - 21;
           dy = dy - 1;
           up();
       }
        
        setLocation(x, y);
                 
        // Eat Food: PacDots, PowerPellets, Fruits
        Food food = (Food)getOneIntersectingObject(Food.class);
        if(food != null) {
            if(food.getClass() == PowerPellet.class)
                GameBoard.getInstance().superpw();
            food.eat();
        }
            
        // Eat ghosts
        Ghost ghost = (Ghost)getOneIntersectingObject(Ghost.class);
        if(ghost != null) {
            ghost.eat();
        }
   
    }    
}
