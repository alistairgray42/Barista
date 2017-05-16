import processing.core.PImage;

public class Ingredient{//fff
	private final String name;
	private final String filename;
	
	public Ingredient(String name, String filename)
	{
		this.name = name;
		this.filename = filename;
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
		return filename;
	}
	
	public String toString() {
		return name;
	}
}