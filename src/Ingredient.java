import processing.core.PImage;

public class Ingredient{
	private String name;
	private String picName;
	private PImage pic;
	
	public Ingredient(String name)
	{
		this.name = name;
	}
	
	public Ingredient(String name, String filename)
	{
		this.name = name;
		picName = filename;
	}
	
	public Ingredient(String name, PImage pic)
	{
		this.name = name;
		this.pic = pic;
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
	
	public String toString() {
		return name;
	}
	
	public PImage getPic()
	{
		return pic;
	}
}