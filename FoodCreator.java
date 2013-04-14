import greenfoot.*;

/**
 * Creates Food based on the options set
 * 
 * @author Caleb Chow
 */
public abstract class FoodCreator extends Actor
{
    protected String mOptions;

    // Set options to customize the following orders
    public void setOptions(String options)
    {
        this.mOptions = options;
    }

    public abstract Food buildOrder();
}
