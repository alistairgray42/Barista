import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Player extends PApplet{
   /*
    * Player
Represents the player

Details: 
Position
Controlled by mouse
Order #
Controlled by 1/2/3/4 keys
Avatar
Image 
Method:
setPostition(int movement)
changeOrder(int number)
Order
Hello
    */
	
	private int x, y, w, h;
	private PImage player; 
	private ArrayList<Order> orders; 
	private Order currentOrder; 
	
	
	public Player(String filename, double x, double y, double w, double h){
		this.x = (int)x;
		this.y = (int)y;
		this.w = (int)w;
		this.h = (int)h;
		orders = new ArrayList<Order>();
		for(int i = 0; i < getLevel(); i++){
			orders.add(new Order()); 
		}
		setup();
	}
	public void setup(){
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
	
	public void updateCurrentOrder(int current){
		currentOrder = orders.get(current); 
	}

	
}
