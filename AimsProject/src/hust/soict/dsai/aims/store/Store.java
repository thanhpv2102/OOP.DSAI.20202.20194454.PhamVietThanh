package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_INSTOCK = 200;

	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_INSTOCK];
	private int qty = 0;
	
	public void addDVD(DigitalVideoDisc disc) {
		if (qty == MAX_NUMBERS_INSTOCK) {
			System.out.println("Store full");
		} else {
			itemsInStore[qty] = disc;
			System.out.println("Successfully added " + itemsInStore[qty].getTitle());
			qty += 1;
		}
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		System.out.println("Successfully removed DVD " + disc.getTitle());
		java.util.List<DigitalVideoDisc> temp = new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsInStore));
		temp.remove(disc);
		itemsInStore = temp.toArray(itemsInStore);
		qty -= 1;
	}

	public void addDVD(DigitalVideoDisc[] dvdList) {
		if (qty == MAX_NUMBERS_INSTOCK || qty + dvdList.length > MAX_NUMBERS_INSTOCK) {
			System.out.println("Store full");
		} else {
			for (int i = 1; i <= dvdList.length; i++) {
				itemsInStore[qty + i - 1] = dvdList[i-1];
			}
			System.out.println("Successfully added " + dvdList.length + " items");
			qty += dvdList.length;
		}
	}

	public void addDVD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qty == MAX_NUMBERS_INSTOCK || qty + 2 > MAX_NUMBERS_INSTOCK) {
			System.out.println("Store full");
		} else {
			itemsInStore[qty] = dvd1;
			itemsInStore[qty+1] = dvd2;
			System.out.println("Successfully added 2 items");
			qty += 2;
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
}
