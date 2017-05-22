
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
	
	private ImageIcon background;
	//private JayLayer sound;
	
	
	/**
	 * Only minorly changed stolen code
	 * @param w
	 */
	public TitleScreen(Main w) { //, Image bgImg
		this.w = w;
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		
		p.setBackground(new Color(0,0,0,0));  // Panel is transparent
		p2.setBackground(new Color(0,0,0,0));
		
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));	
		p2.setLayout(new BoxLayout(p2,BoxLayout.X_AXIS));	
		p.add(Box.createVerticalStrut(200));   // Move down by 300 pixels  
		//p2.add(Box.createHorizontalStrut(200));
		
		background = new ImageIcon("image/Title Screen.png");

		JButton button = new JButton("Start", new ImageIcon("image/StartButton.png","Java"));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setBackground(new Color(225, 127, 80));
		button.setOpaque(false);
		button.setBorderPainted(false);
		
		JButton endless = new JButton("Endless", new ImageIcon("image/EndlessButton.png","Java"));
		endless.setBackground(new Color(225, 127, 80));
		endless.setOpaque(false);
		endless.setBorderPainted(false);
		JButton instructions = new JButton("Instructions", new ImageIcon("image/InstructionsButton.png","Java"));
		instructions.setBackground(new Color(225, 127, 80));
		instructions.setOpaque(false);
		instructions.setBorderPainted(false);
		JButton quit = new JButton("Quit", new ImageIcon("image/QuitButton.png","Java"));
		quit.setBackground(new Color(225, 127, 80));
		quit.setOpaque(false);
		quit.setBorderPainted(false);
		JButton leaderboard = new JButton("Leaderboard", new ImageIcon("image/LeaderboardButton.png","Java"));
		leaderboard.setBackground(new Color(225, 127, 80));
		leaderboard.setOpaque(false);
		leaderboard.setBorderPainted(false);

	    Font font = new Font("Jokerman", Font.BOLD, 65);
	    Font littleFont = new Font("Jokerman", Font.BOLD, 0);
		button.setFont(littleFont);
		button.addActionListener(this);
		
		endless.setFont(littleFont);
		endless.addActionListener(this);
		
		instructions.setFont(littleFont);
		instructions.addActionListener(this);
		
		leaderboard.setFont(littleFont);
		leaderboard.addActionListener(this);
		
		quit.setFont(littleFont);
		quit.addActionListener(this);
		
		p.add(button);
		p.add(p2);

		p2.add(endless);
		p2.add(instructions);
		p2.add(leaderboard);
		p2.add(quit);

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
		g.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
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
	//	g.setFont(new Font("Jokerman", Font.BOLD, 85));
	//	g.drawString("Brisk Barista", 110, 150);
	//	g.setFont(new Font("Jokerman", Font.BOLD, 85));
	//	g.drawString("Brisk Barista", 130, 200);
		
		g2.setTransform(af);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		String str = e.getActionCommand();
		
		if (str.equals("Start")) w.changePanel(1);
		else if (str.equals("Endless")) w.changePanel(2);
		else if (str.equals("Instructions")) w.changePanel(3);
		else if (str.equals("Leaderboard")) w.changePanel(4);
		else if (str.equals("Quit")) w.quit();

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

