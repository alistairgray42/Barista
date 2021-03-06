import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import processing.core.PApplet;
import processing.core.PImage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jay.jaysound.JayLayer;
import jay.jaysound.JayLayerListener;

import java.awt.geom.AffineTransform;
import java.awt.Font;

public class GameArea extends PApplet implements JayLayerListener, ActionListener {

	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	public static final int PANEL_WIDTH = 200;

	private Rectangle2D.Double screenRect;
	private Player player;
	private ArrayList<Integer> keys;
	private ArrayList<PImage> assets;
	private ArrayList<FallingIngredient> ingredients;

	private Ingredient[] base;//
	private Ingredient[] milk;
	private Ingredient[] topping;
	private Ingredient espresso;

	private int score;
	private int level;
	
	private Main main;
	
	private JayLayer sound;
	String[] soundEffects;
//	private JayLayer soundEffects;
	private boolean[] completed = {false, false, false, false};
	
	private boolean endless;
	private PImage background;


	public GameArea(Main main) {
		super();
		endless = false;
		assets = new ArrayList<PImage>();
		keys = new ArrayList<Integer>();
		ingredients = new ArrayList<FallingIngredient>();

		score = 0;
		level = 1;
		
		sound = new JayLayer("audio/","audio/",false);
		soundEffects = new String[]{"CollectingIngredients.wav","Jumping.wav","Fail.mp3"};
		
		this.main = main;
//		soundEffects = new JayLayer("audio/","audio/",false);
	}
	/*
	 * public static void PlaySound() { InputStream in; try { in = new
	 * FileInputStream(new File("audio/JazzMusic.mp3")); AudioStream audios =
	 * new AudioStream(in); AudioPlayer.player.start(audios); } catch (Exception
	 * e) { JOptionPane.showMessageDialog(null, e);
	 * 
	 * }
	 * 
	 * }
	 */

	public void newPlayer() {
		player = new Player(assets.get(0), 100, 100, 70, 70);
		player.getOrders().add(Order.randomOrder(1));
		player.getOrders().add(Order.randomOrder(1));
		player.getOrders().add(Order.randomOrder(1));
		player.getOrders().add(Order.randomOrder(1));
		
		player.getOrders().get(0).resetTime();
		player.getOrders().get(1).resetTime();
		player.getOrders().get(2).resetTime();
		player.getOrders().get(3).resetTime();

		player.getDrinks().add(new Drink(false));
		player.getDrinks().add(new Drink(false));
		player.getDrinks().add(new Drink(false));
		player.getDrinks().add(new Drink(false));

	}

	public void runMe() {
		runSketch();
	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {
		// size(0,0,PApplet.P3D);

		espresso = new Ingredient("Espresso Shot", loadImage("image/EspressoShot.png"));

		base = new Ingredient[] { 
				new Ingredient("Chocolate Syrup", loadImage("image/Mocha.png")),
				//new Ingredient("Matcha", loadImage("image/Matcha.png")),
				new Ingredient("Honey", loadImage("image/Honey.png")),
				new Ingredient("Caramel Syrup", loadImage("image/Caramel.png")),
				new Ingredient("Vanilla Syrup", loadImage("image/Vanilla.png")) 
				};

		milk = new Ingredient[] {
				//new Ingredient("Half-and-Half", loadImage("image/HalfNHalf.png")),
				//new Ingredient("Steamed Milk", loadImage("image/SteamedMilk.png")),
				new Ingredient("Almond Milk", loadImage("image/AlmondMilk.png")),
				new Ingredient("Soymilk", loadImage("image/SoyMilk.png")),
				new Ingredient("Coconut Milk", loadImage("image/CoconutMilk.png")) 
				};

		topping = new Ingredient[] { 
				new Ingredient("Whipping Cream", loadImage("image/WhippedCream.png")),
				new Ingredient("Cinnamon", loadImage("image/Cinnamon.png")),
				new Ingredient("Chocolate Syrup", loadImage("image/Mocha.png")),
				//new Ingredient("Matcha", loadImage("image/Matcha.png")),
				new Ingredient("Caramel Syrup", loadImage("image/Caramel.png")),
				new Ingredient("Vanilla Syrup", loadImage("image/Vanilla.png")) 
				};

		assets.add(loadImage("image/Barista.png"));
		assets.add(loadImage("image/check.png"));
		assets.add(loadImage("image/x.png"));

		newPlayer();
				
		sound.addPlayList();
		sound.addSong(0, "JazzMusic.mp3");
		sound.changePlayList(0);
		sound.addJayLayerListener(this);
		sound.nextSong();
		
//		soundEffects.addSoundEffect("CollectingCoins.wav"); 
//		soundEffects.addSoundEffect("Jumping.wav");
//		soundEffects.addJayLayerListener(this); 
		
		background = loadImage("image/Background.png");
	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {

		// drawing stuff

		image(background, 0, 0, DRAWING_WIDTH, DRAWING_HEIGHT);

		pushMatrix();

		float ratioX = (float) width / DRAWING_WIDTH;
		float ratioY = (float) height / DRAWING_HEIGHT;

		screenRect = new Rectangle2D.Double(0, 0, width, height);

		scale(ratioX, ratioY);
		
		fill(225, 127, 80);
		rect(600, 0, 200, 800);

		for (int i = 0; i < ingredients.size(); i++) {
			FallingIngredient f = ingredients.get(i);
			image(f.getPic(), (float) f.getX(), (float) f.getY(), FallingIngredient.WIDTH, FallingIngredient.HEIGHT);
			f.draw(this);
			f.act();
			if (!f.intersects(screenRect))
				ingredients.remove(i);
			else if (f.intersects(player.getBounds())) {
				player.addIngredient(f.getIngredient());
				ingredients.remove(i);
				if (player.checkCompletion())
				{
					if (completed[0] && completed[1] && completed[2] && completed[3])
					{
						level++;

						player.getOrders().add(Order.randomOrder(level));
						player.getOrders().add(Order.randomOrder(level));
						player.getOrders().add(Order.randomOrder(level));
						player.getOrders().add(Order.randomOrder(level));
						
						player.getOrders().get(0).resetTime();
						player.getOrders().get(1).resetTime();
						player.getOrders().get(2).resetTime();
						player.getOrders().get(3).resetTime();
					}
					score += level * 2000;
					if (!endless) score += player.getOrders().get(player.getCurrentOrder()).checkTime();
					completed[player.getCurrentOrder()] = true;
				}
			}
			
			if (!endless && player.getOrders().get(player.getCurrentOrder()).getTime() <= 0) fail();
		}

		popMatrix();

		// modifying stuff

		if (isPressed(KeyEvent.VK_LEFT))
			player.walk(-1);
		if (isPressed(KeyEvent.VK_RIGHT))
			player.walk(1);
		if (isPressed(KeyEvent.VK_UP)) {
			player.jump();
		//	soundEffects.playSoundEffect(1);
		}
		if (isPressed(49)) {
			player.updateCurrentOrder(0);
			player.updateCurrentDrink(0);
		}
		if (isPressed(50)) {
			player.updateCurrentOrder(1);
			player.updateCurrentDrink(1);
		}
		if (isPressed(51)) {
			player.updateCurrentOrder(2);
			player.updateCurrentDrink(2);
		}
		if (isPressed(52)) {
			player.updateCurrentOrder(3);
			player.updateCurrentDrink(3);
		}
		if (isPressed(81))
			player.clearCurrentDrink();
		player.act();

		if (!screenRect.intersects(player.bounds()))
			newPlayer();

		while (ingredients.size() < 8)
			addRandomIngredient();

		image(assets.get(0), (float) player.getX(), (float) player.getY(), (float) player.width, (float) player.height);

		fill(100);
		text("Order #:", 605, 20);
		text(player.getCurrentOrder() + 1, 680, 20);
		if (completed[player.getCurrentOrder()]) image(assets.get(1), 700f, 5f, 20f, 20f);
		
		/* 
		 * text("Next Ingredient: ", 605, 40);
		 * text(player.getOrders().get(player.getCurrentOrder()).
		 * getNextIngredient().getIngredientName(), 705, 40);
		 */
		Order currentOrder = player.getOrders().get(player.getCurrentOrder());
		Drink currentDrink = player.getDrinks().get(player.getCurrentDrink());

		for (int i = 0; i < currentOrder.getLength(); i++)
		{
			text(currentOrder.getRecipe().get(i).getIngredientName(), 615, 40 + 20 * i);
		}

		//if (currentOrder.getLength() >= currentDrink.getLength())
			for (int i = 0; i < currentDrink.getLength(); i++) {
				if (i >= currentOrder.getLength()) break;
				else if (currentOrder.getRecipe().get(i).getIngredientName() == currentDrink.getDrinkComponents().get(i)
						.getIngredientName()) {
					image(assets.get(1), 605f, 30f + 20 * i, 10f, 10f);
					//soundEffects.playSoundEffect(0);
				}
				else
					image(assets.get(2), 605f, 30f + 20 * i, 10f, 10f);
			}

		for (int i = 0; i < currentDrink.getLength() && i < 8; i++) {
			text(currentDrink.getDrinkComponents().get(i).getIngredientName(), 605, 160 + 20 * i);
		}
		text("Score: ", 605, 400);
		text(score, 680, 400);
		
		if (!endless)
		{
			text("Time: ", 605, 500);
			text(player.getOrders().get(player.getCurrentOrder()).checkTime(), 680, 500);
		}
		
		
		text("Level: ", 605, 450);
		text(level, 680, 450);
	}

	public void actionPerformed(ActionEvent evt)
	{
		//TODO: this you fewl
	}
	
	public void keyPressed() {
		keys.add(keyCode);
	}

	public void keyReleased() {
		while (keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}

	public void addIngredient(FallingIngredient f) {
		assets.add(f.getImage());
		ingredients.add(f);
	}

	private void addRandomIngredient() {
		int i1 = (int) (4 * Math.random());
		int i2;
		if (i1 == 0) i2 = (int) (4 * Math.random());
		else if (i1 == 1) i2 = (int) (3 * Math.random());
		else if (i1 == 2) i2 = (int) (5 * Math.random());
		else i2 = 0;

		int x = (int) (580 * Math.random()) + 10;
		//4,3,5
		FallingIngredient f;
		if (i1 == 0)
			f = new FallingIngredient(base[i2].getIngredientName(), base[i2].getPic(), x, 0);
		else if (i1 == 1)
			f = new FallingIngredient(milk[i2].getIngredientName(), milk[i2].getPic(), x, 0);
		else if (i1 == 2)
			f = new FallingIngredient(topping[i2].getIngredientName(), topping[i2].getPic(), x, 0);
		else
			f = new FallingIngredient("Espresso Shot", espresso.getPic(), x, 0);
		f.speed(.75 + .5 * Math.random());
		addIngredient(f);
	}

	public void setEndless(boolean that)
	{
		endless = that;
	}
	
	public boolean getEndless()
	{
		return endless;
	}
	
	private void fail()
	{
		try
		{
			int[] ints = new int[5];
			String[] strs = new String[5];
			Scanner in = new Scanner(new FileReader("leaderboard.txt"));
			for (int i = 0; i < 5 && in.hasNextLine(); i++)
			{
				String s = in.nextLine();
				ints[i] = Integer.parseInt(s.substring(s.indexOf(",") + 2));
				strs[i] = s.substring(0, s.indexOf(","));
				if (ints[i] < score)
				{
					for (int j = 4; j > i; j++)
					{
						ints[j] = ints[j - 1];
						strs[j] = strs[j - 1];
					}
					ints[i] = score;
					strs[i] = "player";
				}
			}
			in.close();
			
			FileWriter fw = new FileWriter("leaderboard.txt");
			for (int i = 0; i < 5 && strs[i] != null; i++)
			{
				fw.write(strs[i] + ", " + ints[i]);
			}
			fw.close();
			
		}
		catch (IOException io)
		{
			
		}
		
		main.changePanel(2);
	}
	
	@Override
	public void musicStarted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void musicStopped() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playlistEnded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void songEnded() {
		// TODO Auto-generated method stub
		
	}

}
