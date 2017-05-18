import processing.core.PImage;
public class Ingredient{
	private String name;
	private String imgName;
	private PImage img;
	
	public Ingredient(String name, String filename)
	{
		this.name = name;
		imgName = filename;
	}
	
	public Ingredient(String name, PImage pic)
	{
		this.name = name;
		this.img = pic;
	}
	
	/**
	 * @param other Ingredient object to be compared to this Ingredient object
	 * @return true if other Ingredient object equals this Ingredient object
	 */
	public boolean equals(Ingredient other) {
		return this.name.equals(other.name);
	}

	public String getIngredientName() {
		return name;
	}
	
	public String getFilename() {
		return imgName;
	}
	
	public String toString() {
		return name;
	}
	
	public PImage getPic()
	{
		return img;
	}
}