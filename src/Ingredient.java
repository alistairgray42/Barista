import processing.core.PImage;

public class Ingredient{//fff
	private final String ingredient; 
	private PImage imageIngredient; 
	
	public Ingredient(String ingredient, PImage imageIngredient) {
		this.ingredient = ingredient;
		this.imageIngredient = imageIngredient;
		
	}
	/**
	 * @param other Ingredient object to be compared to this Ingredient object
	 * @return true if other Ingredient object equals this Ingredient object
	 */
	public boolean equals(Ingredient other) {
		return this.ingredient.equals(other.ingredient);
	}

	public String getIngredientName() {
		return ingredient;
	}
	
	public String toString() {
		return ingredient;
	}
}