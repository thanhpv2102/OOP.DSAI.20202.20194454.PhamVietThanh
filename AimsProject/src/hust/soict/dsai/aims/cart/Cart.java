package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;

	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("Cart full");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			System.out.println("Successfully added " + itemsOrdered[qtyOrdered].getTitle());
			qtyOrdered += 1;
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		System.out.println("Successfully removed DVD " + disc.getTitle());
		java.util.List<DigitalVideoDisc> temp = new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsOrdered));
		temp.remove(disc);
		itemsOrdered = temp.toArray(itemsOrdered);
		qtyOrdered -= 1;
	}

	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] != null) {
				cost += itemsOrdered[i].getCost();
			}
		}

		return cost;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
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

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED || qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
			System.out.println("Cart full");
		} else {
			itemsOrdered[qtyOrdered] = dvd1;
			itemsOrdered[qtyOrdered+1] = dvd2;
			System.out.println("Successfully added 2 items");
			qtyOrdered += 2;
		}
	}


	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i+1) + ". " + itemsOrdered[i].getDetail());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");

	}

	public void searchByID(int id) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.println(itemsOrdered[i].getDetail());
				return;
			}
		}
		System.out.println("No match");
	}

	public void searchByTitle(String title) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].search(title)) {
				itemsOrdered[i].getDetail();
				return;
			}
		}
		System.out.println("No match");
	}
}
