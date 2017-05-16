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
	public Order getOrder(int num){
		return orders.get(num); 
	}
	
	/**
	 * Retrieves the next Order from the list of Orders to be completed and deletes this Order from the list.   
	 * @return a reference to the next Order to be competed or null if there are no more Orders to be completed
	 */
	public Order getNextOrder() {
		if (orders.isEmpty()) {
			return null;
		}
		else {
			return orders.remove(0);
		}
	}
}