import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
/**
 * 
 * @author Jennifer Zhou
 * @version 5/15/2017
 *
 */
public class Player extends PApplet {


	private int x, y, w, h;
	private PImage player;
	private ArrayList<Order> orders;
	private ArrayList<Drink> drinks;
	private Order currentOrder;
	private Drink currentDrink;
	boolean currDrinkCompleted;
	private Level l;
	
	/**
	 * Create a default player with Level 1.
	 */

	public Player() {
		l = new Level(1);
		orders = new ArrayList<Order>();

		drinks = new ArrayList<Drink>();
		for (int i = 0; i < 4; i++) {
			orders.add(l.getOrders().get(i));
		}
		for (int i = 0; i < 4; i++) {
			drinks.add(new Drink(orders.get(i).getHasIce()));
		}
		
		currentOrder = orders.get(0);
		currentDrink = drinks.get(0);
	}
	
	/**
	 * @param level level that the game is on
	 * @postcondition the orders ArrayList will be initialized with orders of a specific difficulty
	 */
	public Player(double level) {
		this.l = new Level((int)level);
		this.x = (int) x; 
		this.y = (int) y;
		this.w = (int) w;
		this.h = (int) h;
		orders = new ArrayList<Order>();
		/*
		 * for(int i = 0; i < getLevel(); i++){ orders.add(new Order()); }
		 */

		for(int i = 0; i < l.getLevel(); i++){
			orders.add(new Order(l.getLevel())); 
		}

		setup();
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



}

