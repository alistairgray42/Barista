import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jay.jaysound.JayLayer;
import jay.jaysound.JayLayerListener;

import java.awt.geom.AffineTransform;
import java.awt.Font;

//(new ImageIcon(filename)).getImage();
public class TitleScreen extends JPanel implements ActionListener, JayLayerListener {
	
	private Main w;
	//private JayLayer sound;
	
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
		p.add(Box.createVerticalStrut(250));   // Move down by 300 pixels  
		
		ImageIcon icon = new ImageIcon("image/Latte.png","Java");
		JButton button = new JButton("Start", icon);
		
	    Font font = new Font("Jokerman", Font.BOLD, 65);
	   
		button.setFont(font);
		button.addActionListener(this);
		

		p.add(button);
		add(p);
		
		/*
		sound = new JayLayer("audio/","audio/",false);
		sound.addPlayList();
		sound.addSong(0, "JazzMusic.mp3");
		sound.addJayLayerListener(this);
		*/
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
		
		//g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 45));
		//g.drawString("Brisk Barista", 260, 200);
		g.setFont(new Font("Jokerman", Font.BOLD, 85));
		g.drawString("Brisk Barista", 130, 200);
		
		g2.setTransform(af);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel();
		//sound.setRandomizePlayOrder(true);
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

