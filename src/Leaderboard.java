import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Leaderboard extends JPanel implements ActionListener
{

	private Main w;
	private String[] highscores = new String[5];
	private final String filename = "leaderboard.txt";
	
	public Leaderboard (Main w)
	{
		this.w = w;
		
		JPanel panel = new JPanel();
		
		JButton button = new JButton("Quit");
	    Font littleFont = new Font("Jokerman", Font.BOLD, 30);
	    button.setFont(littleFont);
		button.addActionListener(this);
	    
		panel.add(button);
		
		add(panel);
		
		
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		double ratioX = getWidth() / 800.0;
		double ratioY = getHeight() / 600.0;
		
		Graphics2D g2 = (Graphics2D)g;
		
		AffineTransform af = g2.getTransform();
		
		g2.scale(ratioX, ratioY);
		g.setFont(new Font("Jokerman", Font.BOLD, 85));
		g.drawString("Brisk Barista", 110, 150);
		g2.setTransform(af);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
