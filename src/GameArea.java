

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
<<<<<<< HEAD
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
=======
import java.awt.event.KeyListener;
>>>>>>> branch 'master' of https://github.com/alistairgray42/Barista.git
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
	
	public GameArea() {
		super();
		assets = new ArrayList<PImage>();
		keys = new ArrayList<Integer>();
<<<<<<< HEAD
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		obstacles = new ArrayList<Shape>();
		obstacles.add(new Rectangle(0,550,800,50));
		obstacles.add(new Rectangle(0,500,5,50));
		obstacles.add(new Rectangle(795,500,5,50));
		//PlaySound(); 
		//obstacles.add(new Rectangle(0,250,100,50));
		//obstacles.add(new Rectangle(700,250,100,50));
		//obstacles.add(new Rectangle(375,300,50,100));
		//obstacles.add(new Rectangle(300,250,200,50));
=======
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
>>>>>>> branch 'master' of https://github.com/alistairgray42/Barista.git
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

	public void spawnNewMario() {
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
		rect(0,550,800,50);


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
			spawnNewMario();
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


}

