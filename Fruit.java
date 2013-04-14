import greenfoot.*;

/**
 * A Fruit is Food, but has many types. Image icon set in constructor depending on type
 * 
 * @author Caleb Chow
 */
public class Fruit extends Food
{
    public enum FruitType { Cherry, Strawberry, Orange, Apple, Melon, Galaxian, Bell, Key }
	
	private FruitType mType;
	
	public Fruit(FruitType type)
	{
		mType = type;
		
		// Get file name for image of Fruit
		String imgFileName = "fruit_" + mType.toString().toLowerCase() + ".png";
		
		// Set image of Fruit
		setImage(imgFileName);
	}
	
	public FruitType getType()
	{
		return mType;
	}
}
