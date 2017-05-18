import java.awt.geom.Rectangle2D;

import processing.core.PImage;

public class FallingIngredient extends MovingImage
{
	private Ingredient ingredient;
	
	private double yVelocity;
	
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	
	public FallingIngredient(String name, PImage image, int x, int y)
	{
		super(image, x, y, WIDTH, HEIGHT);
		ingredient = new Ingredient(name, image);
		yVelocity = -2;
	}
	
	public PImage getImage()
	{
		return getPic();
	}
	
	public void act()
	{
		y -= yVelocity;
	}
	
	public void speed(double multiplier)
	{
		yVelocity *= multiplier;
	}
}
