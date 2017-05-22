import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InstructionScreen extends JPanel implements ActionListener {

	private Main w;

	private ImageIcon background;
	// private JayLayer sound;

	/**
	 * Only minorly changed stolen code
	 * 
	 * @param w
	 */
	public InstructionScreen(Main w) { // , Image bgImg
		this.w = w;
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();

		p.setBackground(new Color(0, 0, 0, 0)); // Panel is transparent
		p2.setBackground(new Color(0, 0, 0, 0));

		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		p.add(Box.createVerticalStrut(200)); // Move down by 300 pixels
		// p2.add(Box.createHorizontalStrut(200));

		background = new ImageIcon("image/Title Screen.png");

		/*
		 * JButton start = new JButton("Start", new
		 * ImageIcon("image/Start.png","Java")); start.setBackground(new
		 * Color(225, 127, 80)); start.setOpaque(false);
		 * start.setBorderPainted(false); JButton main = new
		 * JButton("Main Menu", new ImageIcon("image/Main.png","Java"));
		 * main.setBackground(new Color(225, 127, 80)); main.setOpaque(false);
		 * main.setBorderPainted(false);
		 */

		/*
		 * start.setFont(littleFont); start.addActionListener(this);
		 * 
		 * main.setFont(littleFont); main.addActionListener(this);
		 * 
		 * 
		 * p.add(start); p.add(p2);
		 * 
		 * p2.add(main); add(p);
		 */
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
		g.drawImage(new ImageIcon("image/Controls.png").getImage(), 10, 200, 300, 250, this);

		double ratioX = getWidth() / 800.0;
		double ratioY = getHeight() / 600.0;

		Graphics2D g2 = (Graphics2D) g;

		AffineTransform af = g2.getTransform();

		g2.scale(ratioX, ratioY);

		// g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
		// g.drawString("Brisk Barista", 260, 200);
		// g.setFont(new Font("Jokerman", Font.BOLD, 85));
		// g.drawString("Brisk Barista", 110, 150);
		// g.setFont(new Font("Jokerman", Font.BOLD, 85));
		// g.drawString("Brisk Barista", 130, 200);

		g2.setTransform(af);

	}

	public void actionPerformed(ActionEvent e) {

		Object o = e.getSource();
		String str = e.getActionCommand();

		if (str.equals("Start"))
			w.changePanel(1);
		else if (str.equals("Endless"))
			w.changePanel(2);
		else if (str.equals("Instructions"))
			w.changePanel(3);
		else if (str.equals("Leaderboard"))
			w.changePanel(4);
		else if (str.equals("Quit"))
			w.quit();

		// sound.setRandomizePlayOrder(true);
	}

}
