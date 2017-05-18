import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.Font;
import java.awt.GraphicsEnvironment;


public class TitleScreen extends JPanel implements ActionListener {
	
	private Main w;
	/**
	 * Only minorly changed stolen code
	 * @param w
	 */
	public TitleScreen(Main w) {
		this.w = w;
		JPanel p = new JPanel();
		p.setBackground(new Color(0,0,0,0));  // Panel is transparent
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));	
		p.add(Box.createVerticalStrut(250));   // Move down by 300 pixels  
		
		ImageIcon icon = new ImageIcon("image/Latte.png","Java");
		JButton button = new JButton("Start", icon);
		
	    Font font = new Font("Jokerman", Font.BOLD, 65);
	   
		button.setFont(font);
		button.addActionListener(this);
		

		p.add(button);
		add(p);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		double ratioX = getWidth() / 800.0;
		double ratioY = getHeight() / 600.0;
		
		Graphics2D g2 = (Graphics2D)g;
		
		AffineTransform af = g2.getTransform();
		
		g2.scale(ratioX,ratioY);
		
		g.setFont(new Font("Jokerman", Font.BOLD, 85));
		g.drawString("Brisk Barista", 140, 220);
		
		g2.setTransform(af);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		w.changePanel();
	}
}

