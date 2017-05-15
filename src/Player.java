import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Player extends PApplet {
	/*
	 * Player Represents the player Details: Position Controlled by mouse Order
	 * # Controlled by 1/2/3/4 keys Avatar Image Method: setPostition(int
	 * movement) changeOrder(int number) Order Hello
	 */

	private int x, y, w, h;
	private PImage player;
	private ArrayList<Order> orders;
	private ArrayList<Drink> drinks;
	private Order currentOrder;
	private Drink currentDrink;
	boolean currDrinkCompleted;
	private Level l;

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
	
	public Player(String filename, double x, double y, double w, double h) {
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

	public void setup() {
		player = loadImage("barista.png");
	}

	public void moveToLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void moveByAmount(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public boolean checkCompletion() {
		if (currentDrink.equals(currentOrder)
				&& currentDrink.getDrinkComponents().size() == currentOrder.getRecipe().size()) {
			currentOrder.setIsCompleted(true);
			return true;
		} else {
			return false;
		}
	}

	public void addIngredient(Ingredient i) {
		currentDrink.add(i);
	}

	public void updateCurrentOrder(int current){
		currentOrder = orders.get(current);
		currentDrink = drinks.get(current);
	}
	

	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public ArrayList<Drink> getDrinks() {
		return drinks;
	}
	
	public Drink getCurrentDrink() {
		return currentDrink;
	}



}

