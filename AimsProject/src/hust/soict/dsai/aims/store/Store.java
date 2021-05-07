package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_INSTOCK = 200;

	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media media) {
		if (itemsInStore.size() == MAX_NUMBERS_INSTOCK) {
			System.out.println("Store full");
		} else if (isInStore(media)){
			System.out.println(media.getTitle() + " already in store");
		} else {
			itemsInStore.add(media);
			itemsInStore.get(itemsInStore.size() - 1).setId(itemsInStore.size());
			System.out.println("Successfully added " + media.getTitle());
		}
	}

	public void removeMedia(Media media) {
		if (isInStore(media)) {
			System.out.println("Successfully removed " + media.getTitle());
			itemsInStore.remove(itemsInStore.indexOf(media));
		} else {
			System.out.println(media.getTitle() + " not in store");
		}
	}
	
	public void removeMedia(String title) {
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equals(title)) {
				itemsInStore.remove(i);
				System.out.println("Successfully removed " + title);
				return;
			}
		}
		System.out.println(title + " not in store");
	}

	private boolean isInStore(Media media) {
		if (itemsInStore.contains(media)) {
			return true;
		}
		return false;
	}

	public void view() {
		System.out.println("-------------ITEMS IN STORE-------------");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(itemsInStore.get(i).toString());
		}
		System.out.println("----------------------------------------");
	}

	public Media viewDetail(String title) {
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equals(title)) {
				System.out.println("-------------ITEM-------------");
				System.out.println(itemsInStore.get(i).toString());
				System.out.println("------------------------------");
				System.out.println("1. Add item to cart");
				if (itemsInStore.get(i) instanceof CompactDisc || itemsInStore.get(i) instanceof DigitalVideoDisc) {
					System.out.println("2. Play media");
				}
				System.out.println("0. Exit");
				System.out.println("Please choose a number:");
				return itemsInStore.get(i);
			}
		}
		System.out.println(title + " not in store");
		return null;
	}

	public Media viewMedia(String title) {
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equals(title)) {
				return itemsInStore.get(i);
			}
		}
		System.out.println(title + " not in store");
		return null;
	}
}
