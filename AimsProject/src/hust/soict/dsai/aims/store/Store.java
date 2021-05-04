package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_INSTOCK = 200;

	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_INSTOCK];
	private int qty = 0;
	
	public void addDVD(DigitalVideoDisc disc) {
		if (qty == MAX_NUMBERS_INSTOCK) {
			System.out.println("Store full");
		} else if (isInStore(disc)){
			System.out.println(disc.getTitle() + " already in store");
		} else {
			itemsInStore[qty] = disc;
			System.out.println("Successfully added " + itemsInStore[qty].getTitle());
			qty += 1;
		}
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		if (isInStore(disc)) {
			System.out.println("Successfully removed DVD " + disc.getTitle());
			java.util.List<DigitalVideoDisc> temp = new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsInStore));
			temp.remove(disc);
			itemsInStore = temp.toArray(itemsInStore);
			qty -= 1;
		} else {
			System.out.println(disc.getTitle() + " not in store");
		}
	}
	
	public void removeDVD(DigitalVideoDisc[] dvdList) {
		for (int i = 0; i < dvdList.length; i++) {
			if (isInStore(dvdList[i])) {
				System.out.println("Successfully removed DVD " + dvdList[i].getTitle());
				java.util.List<DigitalVideoDisc> temp = new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsInStore));
				temp.remove(dvdList[i]);
				itemsInStore = temp.toArray(itemsInStore);
				qty -= 1;
			} else {
				System.out.println(dvdList[i].getTitle() + " not in store");
			}
		}
	}

	public void addDVD(DigitalVideoDisc[] dvdList) {
		if (qty == MAX_NUMBERS_INSTOCK || qty + dvdList.length > MAX_NUMBERS_INSTOCK) {
			System.out.println("Store full");
		} else {
			int count = 0;
			for (int i = 0; i < dvdList.length; i++) {
				if (!isInStore(dvdList[i])) {
					itemsInStore[qty + count] = dvdList[i];
					count++;
				} else {
					System.out.println(dvdList[i].getTitle() + " already in store");
				}
			}
			System.out.println("Successfully added " + count + " items");
			qty += count;
		}
	}

	public void print() {
		System.out.println("***********************STORE***********************");
		System.out.println("Items:");
		for (int i = 0; i < qty; i++) {
			System.out.println((i+1) + ". " + itemsInStore[i].getDetail());
		}
		System.out.println("***************************************************");

	}
	
	private boolean isInStore(DigitalVideoDisc disc) {
		for (int i = 0; i < qty; i++) {
			if (itemsInStore[i].equals(disc)) {
				return true;
			}
		}
		return false;
	}
}
