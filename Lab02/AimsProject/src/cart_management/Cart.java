package cart_management;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	protected void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("Cart full");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			System.out.println("Successfully added " + itemsOrdered[qtyOrdered].getTitle());
			qtyOrdered += 1;
		}
	}
	
	protected void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = MAX_NUMBERS_ORDERED - 1; i >= 0; i--) {
			if (itemsOrdered[i] != null && itemsOrdered[i].equals(disc)) {
				System.out.println("Successfully removed DVD " + itemsOrdered[i].getTitle());
				itemsOrdered[i] = null;
			}
		}
	}
	
	protected float totalCost() {
		float cost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] != null) {
				cost += itemsOrdered[i].getCost();
			}
		}
		
		return cost;
	}
	
}
