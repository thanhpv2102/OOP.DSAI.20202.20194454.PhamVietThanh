package cart_management;

import java.util.ArrayList;
import java.util.Arrays;

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
		System.out.println("Successfully removed DVD " + disc.getTitle());
		java.util.List<DigitalVideoDisc> temp = new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsOrdered));
		temp.remove(disc);
		itemsOrdered = temp.toArray(itemsOrdered);
		qtyOrdered -= 1;
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
	
	protected void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i+1) + ". " + itemsOrdered[i].getDetail());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");
		
	}
	
	protected void searchByID(int id) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.println(itemsOrdered[i].getDetail());
				return;
			}
		}
		System.out.println("No match");
	}
	
	protected void searchByTitle(String title) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].search(title)) {
				itemsOrdered[i].getDetail();
				return;
			}
		}
		System.out.println("No match");
	}
}
