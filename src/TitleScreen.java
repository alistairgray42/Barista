import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class TitleScreen extends JPanel implements ActionListener {
	
	Main w;
	
	public TitleScreen(Main w) {
		this.w = w;
		JButton button = new JButton("Press me!");
		button.addActionListener(this);
		add(button);
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel();
	}
	
}