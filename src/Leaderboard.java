import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Leaderboard extends JPanel implements ActionListener
{

	private Main w;
	private ArrayList<String> highscores = new ArrayList<String>(5);
	private final String filename = "leaderboard.txt";
	

	private ImageIcon background;
	// private JayLayer sound;

	/**
	 * Only minorly changed stolen code
	 * 
	 * @param w
	 */
	public Leaderboard(Main w) { // , Image bgImg
		this.w = w;
		JPanel p = new JPanel();

		p.setBackground(new Color(0, 0, 0, 0)); // Panel is transparent

		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.add(Box.createHorizontalStrut(600)); // Move down by 300 pixels

		background = new ImageIcon("image/Title Screen2.png");

		JButton quit = new JButton("Quit");
		quit.setBackground(new Color(225, 127, 80));
		quit.setOpaque(true);
		quit.setBorderPainted(false); 

		quit.setFont(new Font("Jokerman", Font.BOLD, 30));
		quit.addActionListener(this);
		p.add(quit);
		add(p);
		
		try
		{
			Scanner in = new Scanner(new FileReader(filename));
			for (int i = 0; i < 5 && in.hasNextLine(); i++)
			{
				highscores.add(in.nextLine());
			}
			in.close();
		}
		catch (IOException io)
		{
			
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		
		g.setFont(new Font("Jokerman", Font.BOLD, 25));
		
		for (int i = 0; i < highscores.size() && i < 5; i++)
		{
			g.drawString(i + "). " + highscores.get(i), 140, 200 + 30 * i);
		}

		double ratioX = getWidth() / 800.0;
		double ratioY = getHeight() / 600.0;

		Graphics2D g2 = (Graphics2D) g;

		AffineTransform af = g2.getTransform();

		g2.scale(ratioX, ratioY);
		g2.setTransform(af);

	}

	public void actionPerformed(ActionEvent e) {

		w.changePanel(0);
	}

}
