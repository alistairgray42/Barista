import java.awt.geom.Rectangle2D;

import processing.core.PImage;

public class FallingIngredient extends MovingImage
{
	//
	private Ingredient ingredient;
	private PImage image;
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	public FallingIngredient(String name, PImage image, int x, int y)
	{
		super(image, x, y, WIDTH, HEIGHT);
		ingredient = new Ingredient(name);
	}
	
	public PImage getImage()
	{
		return image;
	}
}
