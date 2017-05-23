import javax.swing.*;

import processing.awt.PSurfaceAWT;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;

public class Main {

	private JFrame window;
	private JPanel cardPanel;
	
	private TitleScreen panel1;    
	private GameArea panel2;
	private InstructionScreen panel3;
	private Leaderboard panel4;
	
	private PSurfaceAWT.SmoothCanvas processingCanvas;
	
	/**
	 * Mostly pillaged code to set up a CardLayout with title and game
	 */
	public Main() {
		
		/* In the CardPanel:
		 * 1: title
		 * 2: game
		 * : endless
		 * 3: instructions
		 * 4: endscreen/leaderboard
		 */
		
		panel2 = new GameArea(this);
		panel2.runMe();
		
		PSurfaceAWT surf = (PSurfaceAWT) panel2.getSurface();
		processingCanvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		
		window = (JFrame)processingCanvas.getFrame();
		window.setTitle("Brisk Barista");

		window.setBounds(0,0,800,600);
		window.setMinimumSize(new Dimension(800,600));//
		window.setMaximumSize(new Dimension(800, 600));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    window.getContentPane().removeAll();
	    
		panel1 = new TitleScreen(this); 
	    	    
	    cardPanel.add(panel1,"1"); 
	    cardPanel.add(processingCanvas,"2"); 
	    
	    panel3 = new InstructionScreen(this);
	    cardPanel.add(panel3, "3"); 
	    
	    panel4 = new Leaderboard(this);
	    cardPanel.add(panel4, "4");
	    
	    window.setLayout(new BorderLayout());
	    
	    window.add(cardPanel, 0);
	    window.revalidate();//
	}
	
	public static void main(String[] args)
	{
		Main m = new Main();
	}
  
	public void changePanel(int times) 
	{
		if (times == 0) ((CardLayout)cardPanel.getLayout()).first(cardPanel);
		for (int i = 0; i < times; i++) ((CardLayout)cardPanel.getLayout()).next(cardPanel);
		processingCanvas.requestFocus();
	}
	
	public void toggleEndless()
	{
		panel2.setEndless(!panel2.getEndless());
	}
	
	protected void quit()
	{
		window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
	}
  
}