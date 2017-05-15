public class Ingredient {
	public final String ingredient; 
	
	public Ingredient(String ingredient) {
		this.ingredient = ingredient;
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