import greenfoot.*;

/**
 * Creates a Fruit based on the options set
 * 
 * @author Caleb Chow
 */
public class FruitFactory extends FoodCreator
{
    // Scale factor relative to grid size
    private static final double SCALE_FACTOR = 0.7;
    
    public Food buildOrder()
    {
        // Defaults
        int gridSize = 16;
        Fruit.FruitType fruitType = Fruit.FruitType.Cherry;
        
        // Handle options
        String[] options = mOptions.split(",");
        for(String option : options)
        {
            String[] tokens = option.split("=");
            
            if(tokens[0].equals("gridSize")) // Use grid size to determine image size
            {
                gridSize = Integer.parseInt(tokens[1]);
            } else if(tokens[0].equals("fruit")) // Use fruit type set
            {
                for (Fruit.FruitType fruit : Fruit.FruitType.values())
                    if(fruit.toString().equalsIgnoreCase(tokens[1]))
                       fruitType = fruit;
            }
        }
        
        // Create Fruit while keeping image in scale and in the grid
        Fruit fruit = new Fruit(fruitType);
        int maxImageSize = (int) ((double) gridSize * SCALE_FACTOR);
        int height = fruit.getImage().getHeight();
        int width = fruit.getImage().getWidth();
        if(width == height)
            fruit.getImage().scale(maxImageSize, maxImageSize);
        else if(width > height)
            fruit.getImage().scale(maxImageSize, height * maxImageSize / width);
        else
            fruit.getImage().scale(width * maxImageSize / height, maxImageSize);
        
        return fruit;
    }
}
