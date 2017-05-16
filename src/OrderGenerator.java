import processing.core.PApplet;
import processing.core.PImage;


public class OrderGenerator extends PApplet{
	
	private PImage espressoShot;
	private PImage mocha; 
	
	public final Ingredient espresso = new Ingredient("Espresso Shot", espressoShot);
/*
	public final Ingredient[] base = new Ingredient[] { new Ingredient("Chocolate Syrup", loadImage("/image/Mocha.png")),
			new Ingredient("Matcha", loadImage("/image/Matcha.png")), new Ingredient("Honey", loadImage("/image/Honey.png")), new Ingredient("Caramel Syrup", loadImage("/image/Caramel.png")),
			new Ingredient("Vanilla Syrup", loadImage("/image/Vanilla.png")) };

	public final Ingredient[] milk = new Ingredient[] { new Ingredient("Half-and-Half", loadImage("/image/HalfNHalf.png") ),			
			new Ingredient("Steamed Milk", loadImage("/image/SteamedMilk.png")), new Ingredient("Almond Milk", loadImage("/image/AlmondMilk.png")), new Ingredient("Soymilk", loadImage("/image/SoyMilk.png")),	
			new Ingredient("Coconut Milk", loadImage("/image/CoconutMilk.png"))};

	public final Ingredient[] topping = new Ingredient[] { new Ingredient("Whipping Cream", loadImage("/image/WhippedCream.png")),			
			new Ingredient("Cinnamon", loadImage("/image/Cinnamon.png")), new Ingredient("Chocolate Syrup", loadImage("/image/Mocha.png")), new Ingredient("Matcha", loadImage("/image/Matcha.png")),
			new Ingredient("Caramel Syrup", loadImage("/image/Caramel.png")), new Ingredient("Vanilla Syrup", loadImage("/image/Vanilla.png"))};

*/
	public OrderGenerator(){
		Order.initializeEspresso(espresso);
		//Order.initializeBase(base);
		//Order.initializeMilk(milk);
		//Order.initializeTopping(topping);
	}
	
	public void setup(){
		espressoShot = loadImage("/image/EspressoShot.png");
	}
}