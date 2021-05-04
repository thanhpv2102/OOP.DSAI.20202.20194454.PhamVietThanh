package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		//Create a new store
		Store store = new Store();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);

		store.addDVD(dvd1);
		
		//adding duplicate DVD will show warning and not add that DVD.
		DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3};
		store.addDVD(dvdList);

		
		store.removeDVD(dvd3);
		//removing item not in array will show warning
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("YEYEYE",
				"Animation", 18.99f);
		store.removeDVD(dvd4);
		//Test the print method
		store.print();

	}

}
