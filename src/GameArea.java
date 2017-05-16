

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class GameArea extends PApplet {

	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	private Rectangle screenRect;

	private Mario mario;
	private ArrayList<Shape> obstacles;

	private ArrayList<Integer> keys;
	
	private ArrayList<PImage> assets;
	
	public final Ingredient espresso = new Ingredient("Espresso Shot", loadImage("EspressoShot.png"));

	public final Ingredient[] base = new Ingredient[] { new Ingredient("Chocolate Syrup", loadImage("Mocha.png")),
			new Ingredient("Matcha", loadImage("Matcha.png")), new Ingredient("Honey", loadImage("Honey.png")), new Ingredient("Caramel Syrup", loadImage("Caramel.png")),
			new Ingredient("Vanilla Syrup", loadImage("Vanilla.png")) };

	public final Ingredient[] milk = new Ingredient[] { new Ingredient("Half-and-Half", loadImage("HalfNHalf.png") ),			
			new Ingredient("Steamed Milk", loadImage("SteamedMilk.png")), new Ingredient("Almond Milk", loadImage("AlmondMilk.png")), new Ingredient("Soymilk", loadImage("SoyMilk.png")),	
			new Ingredient("Coconut Milk", loadImage("CoconutMilk.png"))};

	public final Ingredient[] topping = new Ingredient[] { new Ingredient("Whipping Cream", loadImage("WhippedCream.png")),			
			new Ingredient("Cinnamon", loadImage("Cinnamon.png")), new Ingredient("Chocolate Syrup", loadImage("Mocha.png")), new Ingredient("Matcha", loadImage("Matcha.png")),
			new Ingredient("Caramel Syrup", loadImage("Caramel.png")), new Ingredient("Vanilla Syrup", loadImage("Vanilla.png"))};

	public GameArea() {
		super();
		assets = new ArrayList<PImage>();
		keys = new ArrayList<Integer>();
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		obstacles = new ArrayList<Shape>();
		obstacles.add(new Rectangle(0,550,800,50));
		obstacles.add(new Rectangle(0,500,5,50));
		obstacles.add(new Rectangle(795,500,5,50));
		Order.initializeEspresso(espresso);
		Order.initializeBase(base);
		Order.initializeMilk(milk);
		Order.initializeTopping(topping);
		//obstacles.add(new Rectangle(0,250,100,50));
		//obstacles.add(new Rectangle(700,250,100,50));
		//obstacles.add(new Rectangle(375,300,50,100));
		//obstacles.add(new Rectangle(300,250,200,50));
	}

	public void spawnNewMario() {
		mario = new Mario(assets.get(0), DRAWING_WIDTH/2-Mario.MARIO_WIDTH/2,50);
	}
	
	public void runMe() {
		runSketch();
	}

	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		//size(0,0,PApplet.P3D);
		assets.add(loadImage("Barista.png"));
		
		spawnNewMario();
	}

	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() {

		// drawing stuff

		background(0,255,255);   

		pushMatrix();

		float ratioX = (float)width/DRAWING_WIDTH;
		float ratioY = (float)height/DRAWING_HEIGHT;

		scale(ratioX, ratioY);

		fill(100);
		for (Shape s : obstacles) {
			if (s instanceof Rectangle) {
				Rectangle r = (Rectangle)s;
				rect(r.x,r.y,r.width,r.height);
			}
		}

		mario.draw(this);

		popMatrix();


		// modifying stuff

		
		if (isPressed(KeyEvent.VK_LEFT))
			mario.walk(-1);
		if (isPressed(KeyEvent.VK_RIGHT))
			mario.walk(1);
		if (isPressed(KeyEvent.VK_UP))
			mario.jump();

		mario.act(obstacles);

		if (!screenRect.intersects(mario))
			spawnNewMario();
		
	}


	public void keyPressed() {
		keys.add(keyCode);
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}


}

