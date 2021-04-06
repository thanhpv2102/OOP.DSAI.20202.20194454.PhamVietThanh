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
	
	protected void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED || qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED) {
			System.out.println("Cart full");
		} else {
			for (int i = 1; i <= dvdList.length; i++) {
				itemsOrdered[qtyOrdered + i - 1] = dvdList[i-1];
			}
			System.out.println("Successfully added " + dvdList.length + " items");
			qtyOrdered += dvdList.length;
		}
	}
	
	protected void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED || qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
			System.out.println("Cart full");
		} else {
			itemsOrdered[qtyOrdered] = dvd1;
			itemsOrdered[qtyOrdered+1] = dvd2;
			System.out.println("Successfully added 2 items");
			qtyOrdered += 2;
		}
	}
	
}
