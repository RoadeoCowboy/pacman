import greenfoot.*; 

/**
 * 
 * @author (Ai-Phuong Le) 
 * @version (12/2/2012)
 */

public class Chase implements MoveStrategy 
{   
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;

    Ghost ghost;
    private int direction;
    GameBoard gb;
    
    int maze[][]= {
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,2,2,2,3,3,2,2,2,1,2,2,2,2,2,2,2,1,0,1},
    {1,0,1,1,0,1,1,1,0,1,0,1,1,0,1,1,0,1,0,1},
    {1,0,1,1,0,1,1,1,0,1,0,1,1,0,1,1,0,1,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
    {1,0,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1},
    {1,0,7,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,3,1},
    {1,1,1,1,0,1,1,1,0,1,0,1,1,1,1,0,1,1,0,1},
    {0,0,0,1,0,1,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
    {0,0,0,1,0,1,1,1,0,0,0,1,1,0,1,5,1,1,0,1},
    {0,0,0,1,0,1,0,0,4,0,0,1,0,0,0,0,0,0,0,1},
    {1,1,1,1,0,1,0,1,1,0,1,1,0,1,1,0,1,1,1,1},
    {0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0},
    {1,1,1,1,2,1,0,1,1,1,1,1,0,1,1,0,1,0,0,0},
    {0,0,0,1,2,1,0,0,0,0,0,0,0,0,1,0,1,1,1,1},
    {0,0,0,1,2,1,0,1,1,1,1,1,0,1,1,0,0,0,0,0},
    {1,1,1,1,2,2,2,2,2,1,2,2,2,2,2,0,1,1,0,1},
    {1,2,2,2,2,2,1,2,1,1,1,2,1,2,1,0,1,0,0,1},
    {1,2,1,1,1,1,1,2,1,2,1,2,1,2,1,0,1,0,1,1},
    {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}  
    };
    int x = 200; 
    int y = 300;
    int dx=1;
    int dy=1;
    
    /**
     * Constructor for objects of class Chase
     */
    public Chase()
    {
        direction = EAST;
    }


    public void turnRandom()
    {
        
        while(true)
        {
            int turns = Greenfoot.getRandomNumber(4);
           
            if( turns != direction)
            {    
                direction = turns;
                break;
            }   
        }
        
    }   
  
    public boolean canMove()
    {
       
        switch(direction) {
            case SOUTH :
                if(maze[dx+1][dy]!=1)
                { 
                    return true;
                }
                break;
            case EAST :
                if(maze[dx][dy+1]!=1)
                {
                    return true;
                }   
                break;
            case NORTH :
                if(maze[dx-1][dy]!=1) 
                {
                   return true;
                } 
                break;
            case WEST :
                if(maze[dx][dy-1]!=1)
                {
                    return true;
                }  
                break;
            default:  break;    
        }
        
        return false;
        
    }    
    
    public void step()
    {
       
        if(!canMove())
            return;
        
        switch(direction) {
            case SOUTH :
                y=y+21;
                dx= dx + 1;
                ghost.setLocation(x,y);
                break;
            case EAST :
                x=x+21;
                dy=dy+1;
                ghost.setLocation(x,y);
                break;
            case NORTH :
                y=y-21;
                dx=dx-1;
                ghost.setLocation(x,y);
                break;
            case WEST :
                x=x-21;
                dy=dy-1;
                ghost.setLocation(x,y);
                break;
              
        }    
       
    }    

   
   public void move(Ghost go)
    {
        ghost = go;
        
        x=ghost.getX();
        y=ghost.getY();
        dx = ghost.getDx();
        dy = ghost.getDy();
      
        if(canMove())
            step();
        else
            turnRandom();
     
        ghost.setDx(dx);
        ghost.setDy(dy);
    }    
}
