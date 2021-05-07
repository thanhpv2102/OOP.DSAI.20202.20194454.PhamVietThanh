package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	public void addMedia(Media media) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("Cart full");
		} else {
			itemsOrdered.add(media);
			System.out.println("Successfully added " + media.getTitle());
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.size() == 0) {
			System.out.println("Cart empty");
		} else if (!isInCart(media)){
			System.out.println(media.getTitle() + " not in cart");
		} else {
			itemsOrdered.remove(itemsOrdered.indexOf(media));
			System.out.println("Successfully removed " + media.getTitle());
		}
	}
	
	public void removeMedia(String title) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				itemsOrdered.remove(i);
				System.out.println("Successfully removed " + title);
				return;
			}
		}
		System.out.println(title + " not in cart");
	}

	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			cost += itemsOrdered.get(i).getCost();
		}
		return cost;
	}

	private boolean isInCart(Media media) {
		if (itemsOrdered.contains(media)) {
			return true;
		}
		return false;
	}

	public void view() {
		System.out.println("-------------ITEMS IN CART-------------");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(itemsOrdered.get(i).toString());
		}
		System.out.println("---------------------------------------");
	}

	public boolean isEmpty() {
		return (itemsOrdered.size() == 0);
	}

	public void placeOrder() {
		for (int i = itemsOrdered.size() - 1; i >= 0 ; i--) {
			itemsOrdered.remove(i);
		}
		System.out.println("order placed successfully");
	}

	public void filterTitle(String title) {
		System.out.println("-------------FILTER TITLE-------------");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				System.out.println(itemsOrdered.get(i).toString());
			}
		}
		System.out.println("--------------------------------------");
	}

	public void filterID(int id) {
		System.out.println("-------------FILTER ID-------------");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				System.out.println(itemsOrdered.get(i).toString());
			}
		}
		System.out.println("-----------------------------------");
	}

	public void sortByTitle() {
		itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
		System.out.println("-------------SORT BY TITLE-------------");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(itemsOrdered.get(i).toString());
		}
		System.out.println("---------------------------------------");
	}

	public void sortByCost() {
		itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
		System.out.println("-------------SORT BY COST-------------");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(itemsOrdered.get(i).toString());
		}
		System.out.println("--------------------------------------");
	}
	
	public Media viewMedia(String title) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				return itemsOrdered.get(i);
			}
		}
		System.out.println(title + " not in cart");
		return null;
	}
}
