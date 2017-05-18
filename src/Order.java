//changed

import java.util.ArrayList;
import java.util.logging.Level;

public class Order {

	public static final Ingredient espresso = new Ingredient("Espresso Shot", "EspressoShot.png");

	public static final Ingredient[] base = new Ingredient[] { new Ingredient("Chocolate Syrup", "Mocha.png"),
			new Ingredient("Matcha", "Matcha.png"), new Ingredient("Honey", "Honey.png"),
			new Ingredient("Caramel Syrup", "Caramel.png"), new Ingredient("Vanilla Syrup", "Vanilla.png") };

	public static final Ingredient[] milk = new Ingredient[] { new Ingredient("Half-and-Half", "HalfNHalf.png"),
			new Ingredient("Steamed Milk", "SteamedMilk.png"), new Ingredient("Almond Milk", "AlmondMilk.png"),
			new Ingredient("Soymilk", "SoyMilk.png"), new Ingredient("Coconut Milk", "CoconutMilk.png") };

	public static final Ingredient[] topping = new Ingredient[] { new Ingredient("Whipping Cream", "WhippedCream.png"),
			new Ingredient("Cinnamon", "Cinnamon.png"), new Ingredient("Chocolate Syrup", "Mocha.png"),
			new Ingredient("Matcha", "Matcha.png"), new Ingredient("Caramel Syrup", "Caramel.png"),
			new Ingredient("Vanilla Syrup", "Vanilla.png") };

	private boolean hasIce;

	private boolean isCompleted;

	private ArrayList<Ingredient> recipe;

	private int completion;
	private int length;

	public Order(int level) {
		isCompleted = false;

		recipe = generateOrder(level);
		completion = 0;
		
		if (Math.random() <= 0.5) {
			hasIce = true;
		} else {
			hasIce = false;
		}
	}

	/*
	 * public static void initializeEspresso(Ingredient ingredient){ >>>>>>>
	 * branch 'master' of https://github.com/alistairgray42/Barista.git espresso
	 * = ingredient; }
	 * 
	 * public static void initializeBase(Ingredient[] ingredient){ base =
	 * ingredient; }
	 * 
	 * public static void initializeMilk(Ingredient[] ingredient){ milk =
	 * ingredient; }
	 * 
	 * public static void initializeTopping(Ingredient[] ingredient){ topping =
	 * ingredient; }
	 */

	/**
	 * Randomly generates recipes with an increasing number and variety of
	 * ingredients as level increases
	 * 
	 * @return ArrayList<Ingredient> representing the Order1's recipe
	 */
	private ArrayList<Ingredient> generateOrder(int level) {
		ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();

		// expresso
		recipe.add(espresso);

		// base
		for (int i = 0; i < level; i++)
			recipe.add(base[(int) (Math.random() * base.length)]);

		// milk
		recipe.add(milk[(int) (Math.random() * milk.length)]);

		// toppings
		for (int i = 0; i < level; i++)
			recipe.add(topping[(int) (Math.random() * topping.length)]);

		return recipe;
	}

	/*
	 * private ArrayList<Ingredient> generateOrder2() { //Espresso Shot, Caramel
	 * Syrup, Almond Milk, Cinnamon ArrayList<Ingredient> recipe = new
	 * ArrayList<Ingredient>(); recipe.add(espresso); recipe.add(base[3]);
	 * recipe.add(milk[2]); recipe.add(topping[1]); length = 4; return recipe; }
	 */

	public String toString() {
		String a = "recipe: ";
		for (int i = 0; i < recipe.size(); i++) {
			a += recipe.get(i).getIngredientName() + ", ";
		}
		a += "ice: " + hasIce + ", ";
		a += "isCompleted: " + isCompleted;
		return a;
	}

	public void setIsCompleted(boolean c) {
		isCompleted = c;
	}

	public boolean isCompleted() 
	{
		return (completion >= length);
	}

	public boolean getHasIce() {
		return hasIce;
	}

	public ArrayList<Ingredient> getRecipe() {
		return recipe;
	}

	public Ingredient getNextIngredient() {
		if (isCompleted())
			return null;
		return recipe.get(completion);
	}

	public int getLength() {
		return length;
	}

	public static Order randomOrder(int level) {
		Order o = new Order(level);
		o.recipe = o.generateOrder(level);
		return o;
	}
}
