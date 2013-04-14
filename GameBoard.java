import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class gameboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBoard extends Actor implements Observer, Subject
{
     private static GameBoard instance;
    private GameBoard() {
        // Set up to observe GamePieces
        {
            // Set to observe all GamePieces
            subject = new GamePiece();
        
            // Attach observer to all GamePieces
            subject.attach(this);
        }
        
         //maze[][]={{1,1,1,1},{1,0,0,1},{1,0,0,1},{1,0,0,1}};
        // maze[0][]=[1,1,1,1];
        gi = new GreenfootImage( 420, 441);
        gi.clear();
        gi.setColor( java.awt.Color.BLACK ) ;
        gi.fill() ;
        //gi.setColor( java.awt.Color.BLACK ) ;
        World wr = getWorld();
       
       
        setImage(gi);
        //gi.scale(240,320);
        
        ppf.setOptions("gridSize=21");
        pdf.setOptions("gridSize=21");
        ff.setOptions("gridSize=21,fruit=cherry");
       
    }

    public static GameBoard getInstance() {
        if (instance == null) {
            instance = new GameBoard();
        }
        return instance;
    }
  
    protected String observerState;
    protected GamePiece subject;
    
    private static String subjectState;
    private static ArrayList<Observer> observers = new ArrayList<Observer>() ;
    GreenfootImage gi;
    
    static int maze[][]= {
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    {1,6,2,2,3,3,2,2,2,1,2,2,2,2,2,2,2,1,6,1},
    {1,0,1,1,0,1,1,1,0,1,0,1,1,0,1,1,2,1,0,1},
    {1,0,1,1,0,1,1,1,0,1,0,1,1,0,1,1,2,1,0,1},
    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,0,1},
    {1,0,1,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1},
    {1,0,7,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,3,1},
    {1,1,1,1,0,1,1,1,0,1,0,1,1,1,1,0,1,1,0,1},
    {0,0,0,1,0,1,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
    {0,0,0,1,0,1,1,1,0,0,0,1,1,0,1,5,1,1,0,1},
    {0,0,0,1,0,1,0,0,4,0,0,1,0,0,0,0,0,0,0,1},
    {1,1,1,1,0,1,0,1,1,0,1,1,0,1,1,0,1,1,1,1},
    {1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,0},
    {1,1,1,1,2,1,0,1,1,1,1,1,0,1,1,0,1,0,0,0},
    {0,0,0,1,2,1,0,0,0,0,0,0,0,0,1,0,1,1,1,1},
    {0,0,0,1,2,1,0,1,1,1,1,1,0,1,1,0,0,0,0,1},
    {1,1,1,1,2,2,2,2,2,1,2,2,2,2,2,0,1,1,0,1},
    {1,2,2,2,2,2,1,2,1,1,1,2,1,2,1,0,1,0,0,1},
    {1,2,1,1,1,1,1,2,1,2,1,2,1,2,1,0,1,0,1,1},
    {1,6,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,6,1},
    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    //{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}  
    };
    /* the coordinator */
    int x,y;
    /* Reset flag */
    boolean reset = true;
    
    PowerPelletFactory ppf = new PowerPelletFactory();
    PacDotFactory pdf = new PacDotFactory();
    FruitFactory ff = new FruitFactory();
               
   
    /**
     * Act - do whatever the gameboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    public void act() 
    {
         /* If reset is not true, don't draw the map again!*/
         if(reset){
                drawMap();
                reset = false;
         }
    }
   
    public void superpw(){
       World wr = getWorld();
       boolean isWeak = true;
       Pinky pinky = Pinky.getPinky();
       Clyde clyde = Clyde.getClyde();
       Blinky blinky= Blinky.getBlinky();
       Inky inky = Inky.getInky();
       
       pinky.setStrategy(isWeak);
       clyde.setStrategy(isWeak);
       blinky.setStrategy(isWeak);
       inky.setStrategy(isWeak);
       
    }
    
    /* Draw the map again*/
    public void drawMap(){
        x=10;y=10;
        World wr = getWorld();
         for(int i=0;i<21;i++){
             for(int j=0;j<20;j++){
             switch(maze[i][j]){
                  
                 case 1: wr.addObject(new Brick(),x+j*21,y+i*21);break;
                 case 2: wr.addObject(pdf.buildOrder(),x+j*21,y+i*21);break;
                 case 3: wr.addObject(ff.buildOrder(),x+j*21,y+i*21);break;
                 case 4: //wr.addObject(new Blinky(),x+j*21,y+i*21);break;
                 case 5: //wr.addObject(new Clyde(),x+j*21,y+i*21);break;
                 case 6: wr.addObject(ppf.buildOrder(),x+j*21,y+i*21);break;
                 case 7: //wr.addObject(new Pinky(),x+j*21,y+i*21);break;
                 default: break;
            }
            }
        }

    }
    
    public void update() {
        observerState = subject.getState();
        subjectState = observerState;
        // do nothing
        //showState();
        notifyObservers();
    }

    public void showState()
    {
        System.out.println( "Observer: " + this.getClass().getName() + " = " + observerState);
    }
    
    public void notifyObservers()
    {
        for (Observer obj  : observers)
        {
            obj.update();
        }
    }
     
    public String getState() {
        return subjectState ;
    }
     
    public void setState(String status) {
        subjectState = status ;
        notifyObservers();
    }
    
    public void attach(Observer obj) {
        observers.add(obj);
    }

    public void detach(Observer obj) {
        observers.remove(obj) ;
    }
}