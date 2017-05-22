
import javax.swing.*;

import processing.awt.PSurfaceAWT;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Main {

	private JFrame window;
	
	private JPanel cardPanel;
	
	private TitleScreen panel1;    
	private GameArea panel2;
	
	private PSurfaceAWT.SmoothCanvas processingCanvas;
	
	/**
	 * Mostly pillaged code to set up a CardLayout with title and game
	 */
	public Main() {
		panel2 = new GameArea();
		panel2.runMe();
		
		PSurfaceAWT surf = (PSurfaceAWT) panel2.getSurface();
		processingCanvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		window = (JFrame)processingCanvas.getFrame();
		window.setTitle("1337 Baristing");

		window.setBounds(0,0,800,600);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    //
	    window.getContentPane().removeAll();
	    
		panel1 = new TitleScreen(this); //(new ImageIcon("/Barista/image/CashRegistar.png")).getImage()   
	    panel2 = new GameArea();
	    	    
	    cardPanel.add(panel1,"1");
	    cardPanel.add(processingCanvas,"2");
	    
	    window.setLayout(new BorderLayout());
	    
	    window.add(cardPanel, 0);
	    window.revalidate();
	}
	

	public static void main(String[] args)
	{
		Main m = new Main();
		
		OrderGenerator o = new OrderGenerator(); 
	}
  
	public void changePanel() {
		((CardLayout)cardPanel.getLayout()).next(cardPanel);
		processingCanvas.requestFocus();
	}
  
}