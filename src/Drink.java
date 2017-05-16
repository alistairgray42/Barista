import java.util.ArrayList;

public class Drink {
	private ArrayList<Ingredient> drinkComponents;
	boolean hasIce;
	
	public Drink(boolean i) {
		drinkComponents = new ArrayList<Ingredient>();
		hasIce = i;
	}

	/**
	 * Adds an Ingredient to the drink and checks if the updated drink follows the order's recipe so far
	 * @pre this Drink object (before adding the Ingredient) must follow the order's recipe so far
	 * @param i Ingredient to be added
	 * @return true if the drink equals the order's recipe so far, false if otherwise.
	 */
	public void add(Ingredient i) {
		drinkComponents.add(i);
	}
	
	public boolean equals(Order o) {
		if (drinkComponents.isEmpty()) {
			return true;
		}
		return drinkComponents.get(drinkComponents.size() - 1).equals(o.getRecipe().get(drinkComponents.size()-1)) && hasIce == o.getHasIce();
	}
	
	public ArrayList<Ingredient> getDrinkComponents() {
		return drinkComponents;
	}
	
	
	public String toString() {
		String a = "Ingredients: ";
		for (int i = 0; i < drinkComponents.size(); i++) {
			a += drinkComponents.get(i) + ", ";
		}
		a += "hasIce: " + hasIce;
		return a;
	}
	
}