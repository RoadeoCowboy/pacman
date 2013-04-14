import greenfoot.*;

/**
 * Creates a PacDot
 * 
 * @author Caleb Chow
 */
public class PacDotFactory extends FoodCreator
{
    // Scale factor relative to grid size
    private static final double SCALE_FACTOR = 0.3;
    
    public Food buildOrder()
    {
        // Defaults
        int gridSize = 16;
        
        // Handle options
        String[] options = mOptions.split(",");
        for(String option : options)
        {
        	String[] tokens = option.split("=");
        	
        	if(tokens[0].equals("gridSize")) // Use grid size to determine image size
        	{
        		gridSize = Integer.parseInt(tokens[1]);
        	}
        }
        
        // Create PacDot
        PacDot pacDot = new PacDot();
        int imageSize = (int) ((double) gridSize * SCALE_FACTOR);
        pacDot.getImage().scale(imageSize, imageSize);
        
        return pacDot;
    }
}
