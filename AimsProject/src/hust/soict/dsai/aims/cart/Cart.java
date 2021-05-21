package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.exception.RemoveException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public String addMedia(Media media) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			return ("Cart full");
		} else {
			itemsOrdered.add(media);
			return ("Successfully added " + media.getTitle());
		}
	}

	public String removeMedia(Media media) throws RemoveException{
		if (itemsOrdered.size() == 0) {
			return ("Cart empty");
		} else if (!isInCart(media)){
			throw new RemoveException(media.getTitle() + " not in cart");
		} else {
			itemsOrdered.remove(itemsOrdered.indexOf(media));
			return ("Successfully removed " + media.getTitle());
		}
	}
	
	public String removeMedia(String title) throws RemoveException{
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				itemsOrdered.remove(i);
				return ("Successfully removed " + title);
			}
		}
		throw new RemoveException(title + " not in cart");
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

	public String placeOrder() {
		if (isEmpty()) {
			return ("Cart is empty");
		} else {
			for (int i = itemsOrdered.size() - 1; i >= 0 ; i--) {
				itemsOrdered.remove(i);
			}
			return ("Order placed successfully");
		}
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
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
}
