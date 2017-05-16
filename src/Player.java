import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Player extends MovingImage {
	/*
	 * Player Represents the player Details: Position Controlled by mouse Order
	 * # Controlled by 1/2/3/4 keys Avatar Image Method: setPosition(int
	 * movement) changeOrder(int number) Order Hello
	 */
	private PImage player;
	private ArrayList<Order> orders;
	private ArrayList<Drink> drinks;
	private Order currentOrder;
	private Drink currentDrink;
	boolean currDrinkCompleted;
	private Level l;
	private double xVelocity = 0;
	private double yVelocity = 0;
	private double friction = .8;
	private double gravity = .4;
	private double jumpStrength = .6;
	
	public Player(PImage image, double x, double y, double w, double h) {
		super(image, x, y, w, h);
		l = new Level(1);
		orders = new ArrayList<Order>();
		drinks = new ArrayList<Drink>();
		player = image;
		/*
		 * for(int i = 0; i < getLevel(); i++){ orders.add(new Order()); }
		 */

		for(int i = 0; i < l.getLevel(); i++){
			orders.add(new Order(l.getLevel())); 
		}
		for (int i = 0; i < l.getLevel(); i++) {
			drinks.add(new Drink(orders.get(i).getHasIce()));
		}
	}

	public void walk(int dir) {
		if (xVelocity <= 10 && xVelocity >= -10)
			xVelocity += 2*dir;
	}
	
	public void jump()
	{
		yVelocity -= 2 * jumpStrength;
	}
	
	/**
	 * Move to a specific location on the screen
	 * @param x x-pos
	 * @param y y-pos
	 */
	public void moveToLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Move a certain amount left or right
	 * @param x move certain x units left or right
	 * @param y move certain y units up or down
	 */
	public void moveByAmount(int x, int y) {
		this.x += x;
		this.y += y;
	}

	/**
	 * Check to see whether the barista completed the current order
	 */
	public boolean checkCompletion() {
		if (currentDrink.equals(currentOrder)
				&& currentDrink.getDrinkComponents().size() == currentOrder.getRecipe().size()) {
			currentOrder.setIsCompleted(true);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Add ingredient to the drink the barista is currently making
	 * @param i Ingredient that the player touches and wants to add to the drink
	 */
	public void addIngredient(Ingredient i) {
		currentDrink.add(i);
	}

	/**
	 * Add more ingredients to the current drink
	 * @param current the current drink that the player is currently making in the list of orders
	 */
	public void updateCurrentOrder(int current){
		currentOrder = orders.get(current);
		currentDrink = drinks.get(current);
	}
	
	/**	
	 * Gives the ArrayList of orders
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	/**
	 * Gives the ArrayList of the drinks the barista has completed or is still making
	 */
	public ArrayList<Drink> getDrinks() {
		return drinks;
	}
	
	/**
	 * Gives the current drink that the barista is making
	 */
	public Drink getCurrentDrink() {
		return currentDrink;
	}

	public void act()
	{

		// ***********Y AXIS***********

		yVelocity += gravity; // GRAVITY
		if (y >= 465 && yVelocity >= 0) yVelocity = -20 * gravity;
		if (y <= 1) yVelocity = 20 * gravity;
		y += yVelocity;

		// ***********X AXIS***********

		xVelocity *= friction;
		if (x <= 1) xVelocity = 20 * gravity;
		if (x >= 749) xVelocity = -20 * gravity;
		x += xVelocity;

	}
	
	public Rectangle2D.Double bounds()
	{
		return new Rectangle2D.Double(x, y, width, height);
	}

}

