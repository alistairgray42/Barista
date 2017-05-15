import java.util.ArrayList;
import java.util.logging.Level;

public class Order {

	public static final Ingredient espresso = new Ingredient("Espresso Shot");

	public static final Ingredient[] base = new Ingredient[] { new Ingredient("Chocolate Syrup"),
			new Ingredient("Matcha"), new Ingredient("Honey"), new Ingredient("Caramel Syrup"),
			new Ingredient("Vanilla Syrup") };

	public static final Ingredient[] milk = new Ingredient[] { new Ingredient("Half-and-Half"),
			new Ingredient("Steamed Milk"), new Ingredient("Almond Milk"), new Ingredient("Soymilk"),
			new Ingredient("Coconut Milk") };

	public static final Ingredient[] topping = new Ingredient[] { new Ingredient("Whipping Cream"),
			new Ingredient("Cinnamon"), new Ingredient("Chocolate Syrup"), new Ingredient("Matcha"),
			new Ingredient("Caramel Syrup"), new Ingredient("Vanilla Syrup") };

	private boolean hasIce;
	
	private boolean isCompleted;

	private ArrayList<Ingredient> recipe;

	public Order(int level) {
		isCompleted = false;
		
		//recipe = generateOrder1(level);
		recipe = generateOrder2();
		
		if (Math.random() <= 0.5) {
			hasIce = true;
		} else {
			hasIce = false;
		}
	}

	public ArrayList<Ingredient> getRecipe() {
		return recipe;
	}

	/**
	 * Randomly generates recipes with an increasing number and variety of ingredients as level increases
	 * @return ArrayList<Ingredient> representing the Order1's recipe
	 */
	private ArrayList<Ingredient> generateOrder1(int level) {
		ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();
		
		//expresso
		recipe.add(espresso);
		
		//base
		for (int i = 0; i < level; i++) {
			recipe.add(base[(int)(Math.random() * base.length)]);
		}
		//milk
		recipe.add(milk[(int)(Math.random() * milk.length)]);
		//toppings
		for (int i = 0; i < level; i++) {
			recipe.add(topping[(int)(Math.random() * topping.length)]);
		}

		return recipe;
	}
	
	private ArrayList<Ingredient> generateOrder2() {
		//Espresso Shot, Caramel Syrup, Almond Milk, Cinnamon
		ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();
		recipe.add(espresso);
		recipe.add(base[3]);
		recipe.add(milk[2]);
		recipe.add(topping[1]);
		return recipe; 
	}
	
	
	public String toString() {
		String a =  "recipe: ";
		for (int i = 0; i < recipe.size(); i++) {
			a += recipe.get(i).getIngredientName() + ", ";
		}
		a += "ice: " + hasIce + ", ";
		a += "isCompleted: " + isCompleted;
		return a;
	}
	
	public boolean getIsCompleted() {
		return isCompleted;
	}
	
	public void setIsCompleted(boolean c) {
		isCompleted = c;
	}
	
	public boolean getHasIce() {
		return hasIce;
	}

}
