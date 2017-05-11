import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import processing.core.PApplet;

public class Player implements MouseListener {
   /*
    * Player
Represents the player

Details: 
Position
Controlled by mouse
Order #
Controlled by 1/2/3/4 keys
Avatar
Image 
Method:
setPostition(int movement)
changeOrder(int number)
Order

    */
	
	private int x, y, w, h;
	
	
	public Player(String filename, double x, double y, double w, double h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h; 
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
