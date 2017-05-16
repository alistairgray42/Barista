import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

//(new ImageIcon(filename)).getImage();
public class TitleScreen extends JPanel implements ActionListener {
	
	private Main w;
//	private Image background;
	/**
	 * Only minorly changed stolen code
	 * @param w
	 */
	public TitleScreen(Main w) { //, Image bgImg
		this.w = w;
	//	background = bgImg;
		JPanel p = new JPanel();
		p.setBackground(new Color(0,0,0,0));  // Panel is transparent
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));	
		p.add(Box.createVerticalStrut(300));   // Move down by 300 pixels  
		
		JButton button = new JButton("Start");
		button.addActionListener(this);
		p.add(button);
		add(p);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	//	g.drawImage(background, 0, 0, this);
		//JLabel contentPane = new JLabel();
		//contentPane.setIcon(new ImageIcon("/Barista/image/CashRegistar.png"));
		//contentPane.setLayout(new BorderLayout());
		//g.setContentPane(contentPane);
		
		double ratioX = getWidth() / 800.0;
		double ratioY = getHeight() / 600.0;
		
		Graphics2D g2 = (Graphics2D)g;
		
		AffineTransform af = g2.getTransform();
		
		g2.scale(ratioX,ratioY);
		
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
		g.drawString("Brisk Barista", 260, 200);
		
		g2.setTransform(af);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel();
	}
}

