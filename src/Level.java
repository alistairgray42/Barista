import java.util.ArrayList;

public class Level {
	
	private int level;
	private ArrayList<Order> orders = new ArrayList<Order>();

	public Level(int level) {
		this.level = level;
		for (int i = 0; i < 8; i++) {
			orders.add(new Order(level));
		}
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	
	public int getLevel() {
		return level;
	}

	public void incrementLevel() {
		level++;
	}
	
	/**
	 * Retrives the next Order1 from the list of Order1s to be completed and deletes this Order1 from the list.   
	 * @return a reference to the next Order1 to be competed or null if there are no more Order1s to be completed
	 */
	public Order getNextOrder1() {
		if (orders.isEmpty()) {
			return null;
		}
		else {
			return orders.remove(0);
		}
	}
}