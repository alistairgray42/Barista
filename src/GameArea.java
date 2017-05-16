

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import processing.core.PApplet;
import processing.core.PImage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class GameArea extends PApplet
{

	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	private Rectangle screenRect;
	private Player player;
	private ArrayList<Integer> keys;
	private ArrayList<PImage> assets;
	private ArrayList<FallingIngredient> ingredients;
	public GameArea() {
		super();
		assets = new ArrayList<PImage>();
		keys = new ArrayList<Integer>();
		ingredients = new ArrayList<FallingIngredient>();
	}
	
	/*public void setup(){
		
	}*/
	/*public static void PlaySound() {
	    InputStream in;
	    try {
	        in = new FileInputStream(new File("audio/JazzMusic.mp3"));
	        AudioStream audios = new AudioStream(in);
	        AudioPlayer.player.start(audios);
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e);

	    }

	}*/

	public void newPlayer() {
		player = new Player(assets.get(0), 100, 100, 50, 50);
	}
	
	public void runMe() {
		runSketch();
	}

	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		//size(0,0,PApplet.P3D);
		assets.add(loadImage("Barista.png"));
		
		newPlayer();
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
		rect(0,550,800,50);
		
		for (int i = 1; i < ingredients.size(); i++)
		{
			FallingIngredient f = ingredients.get(i);
			image(assets.get(i), (float)f.getX(), (float)f.getY(), FallingIngredient.WIDTH, FallingIngredient.HEIGHT);
		}

		popMatrix();

		// modifying stuff
		
		if (isPressed(KeyEvent.VK_LEFT))
			player.walk(-1);
		if (isPressed(KeyEvent.VK_RIGHT))
			player.walk(1);
		if (isPressed(KeyEvent.VK_UP))
			player.jump();
		player.act();

		if (!screenRect.intersects(player.bounds()))
			newPlayer();
		image(assets.get(0), (float)player.getX(), (float)player.getY(), (float)player.width, (float)player.height);

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

	public void addIngredient(FallingIngredient f)
	{
		assets.add(f.getImage());
	}
	
}

