package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		Cart cart = new Cart();
		new StoreScreen(store, cart);
	}

}
