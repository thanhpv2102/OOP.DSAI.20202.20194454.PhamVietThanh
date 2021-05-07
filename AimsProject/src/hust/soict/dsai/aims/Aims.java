package hust.soict.dsai.aims;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	
	static Store store = new Store();
	static Cart cart = new Cart();

	static int choice = 0;
	static String title = "";
	static Media chosen = null;
	static int id = 0;
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//reload main menu when exit a sub menu
		while (true) {
			showMenu();
			choice = scanner.nextInt();
			switch (choice) {
			//1. View store
			case 1:
				store.view();
				storeMenu();
				choice = scanner.nextInt();
				switch (choice) {
				//1. See a media’s details
				case 1:
					System.out.println("Enter title:");
					scanner.nextLine();
					title = scanner.nextLine();
					chosen = store.viewDetail(title);
					if (chosen != null) {
						choice = scanner.nextInt();
						switch (choice) {
						case 1:
							cart.addMedia(chosen);
							break;
						case 2:
							if (chosen instanceof DigitalVideoDisc) {
								((DigitalVideoDisc) chosen).play();
							} else {
								((CompactDisc) chosen).play();
							}
							break;
						case 0:
							break;
						}
					}
					break;
				//2. Add a media to cart
				case 2:
					System.out.println("Enter title:");
					scanner.nextLine();
					title = scanner.nextLine();
					chosen = store.viewMedia(title);
					if (chosen != null) {
						cart.addMedia(chosen);
					}
					break;
				//3. Play a media
				case 3:
					System.out.println("Enter title:");
					scanner.nextLine();
					title = scanner.nextLine();
					chosen = store.viewMedia(title);
					if (chosen != null) {
						if (chosen instanceof DigitalVideoDisc) {
							((DigitalVideoDisc) chosen).play();
						} else if (chosen instanceof CompactDisc){
							((CompactDisc) chosen).play();
						} else {
							System.out.println(title + " not playable");
						}
					}
					break;
				//4. See current cart
				case 4:
					cart.view();
					cartMenu();
					choice = scanner.nextInt();
					switch(choice) {
					//1. Filter medias in cart
					case 1:
						System.out.println("--------------------------------");
						System.out.println("1. Filter by ID");
						System.out.println("2. Filter by title");
						System.out.println("0. Exit");
						System.out.println("Please choose a number:");
						choice = scanner.nextInt();
						switch(choice) {
						case 1:
							System.out.println("Enter ID:");
							scanner.nextLine();
							id = Integer.parseInt(scanner.nextLine());
							cart.filterID(id);
							break;
						case 2:
							System.out.println("Enter title:");
							scanner.nextLine();
							title = scanner.nextLine();
							cart.filterTitle(title);
							break;
						case 0:
							break;
						}
						break;
					//2. Sort medias in cart
					case 2:
						System.out.println("--------------------------------");
						System.out.println("1. Sort by title");
						System.out.println("2. Sort by cost");
						System.out.println("0. Exit");
						System.out.println("Please choose a number:");
						choice = scanner.nextInt();
						switch(choice) {
						case 1:
							cart.sortByTitle();
							break;
						case 2:
							cart.sortByCost();
							break;
						case 0:
							break;
						}
						break;
					//3. Remove media from cart
					case 3:
						System.out.println("Enter title:");
						scanner.nextLine();
						title = scanner.nextLine();
						cart.removeMedia(title);
						break;
					//4. Play a media
					case 4:
						System.out.println("Enter title:");
						scanner.nextLine();
						title = scanner.nextLine();
						chosen = cart.viewMedia(title);
						if (chosen != null) {
							if (chosen instanceof DigitalVideoDisc) {
								((DigitalVideoDisc) chosen).play();
							} else if (chosen instanceof CompactDisc){
								((CompactDisc) chosen).play();
							} else {
								System.out.println(title + " not playable");
							}
						}
						break;
					//5. Place order
					case 5:
						if (cart.isEmpty()) {
							System.out.println("cant place order: cart empty");
						} else {
							cart.placeOrder();
						}
						break;
					//0. Exit
					case 0:
						break;
					}
					break;
				//0. Exit
				case 0:
					break;
				}
				break;
			//2. Update store
			case 2:
				store.view();
				System.out.println("--------------------------------");
				System.out.println("1. Add items to store");
				System.out.println("2. Remove item from store");
				System.out.println("0. Exit");
				System.out.println("Please choose a number:");
				choice = scanner.nextInt();
				switch(choice) {
				//1. Add items to store
				case 1:
					//I dont write function for user to add, this is faster to test sort and filter function in cart
					CompactDisc cd = new CompactDisc("A", "A", "A", "A", 7f); 
					CompactDisc cd2 = new CompactDisc("A", "B", "B", "B", 6f);
					DigitalVideoDisc dvd = new DigitalVideoDisc("D", "B", "B", 87, 4f);
					DigitalVideoDisc dvd2 = new DigitalVideoDisc("C", "B", "B", 87, 4f);
					Book book = new Book("B", "C", 5f);
					
					store.addMedia(book);
					store.addMedia(dvd2);
					store.addMedia(dvd);
					store.addMedia(cd2);
					store.addMedia(cd);
					break;
				//2. Remove item from store
				case 2:
					store.view();
					System.out.println("Enter title:");
					scanner.nextLine();
					title = scanner.nextLine();
					store.removeMedia(title);
					break;
				case 0:
					break;
				}
				break;
			//3. See current cart
			case 3:
				cart.view();
				cartMenu();
				choice = scanner.nextInt();
				switch(choice) {
				//1. Filter medias in cart
				case 1:
					System.out.println("--------------------------------");
					System.out.println("1. Filter by ID");
					System.out.println("2. Filter by title");
					System.out.println("0. Exit");
					System.out.println("Please choose a number:");
					choice = scanner.nextInt();
					switch(choice) {
					case 1:
						System.out.println("Enter ID:");
						scanner.nextLine();
						id = Integer.parseInt(scanner.nextLine());
						cart.filterID(id);
						break;
					case 2:
						System.out.println("Enter title:");
						scanner.nextLine();
						title = scanner.nextLine();
						cart.filterTitle(title);
						break;
					case 0:
						break;
					}
					break;
				//2. Sort medias in cart
				case 2:
					System.out.println("--------------------------------");
					System.out.println("1. Sort by title");
					System.out.println("2. Sort by cost");
					System.out.println("0. Exit");
					System.out.println("Please choose a number:");
					choice = scanner.nextInt();
					switch(choice) {
					case 1:
						cart.sortByTitle();
						break;
					case 2:
						cart.sortByCost();
						break;
					case 0:
						break;
					}
					break;
				//3. Remove media from cart
				case 3:
					System.out.println("Enter title:");
					scanner.nextLine();
					title = scanner.nextLine();
					cart.removeMedia(title);
					break;
				//4. Play a media
				case 4:
					System.out.println("Enter title:");
					scanner.nextLine();
					title = scanner.nextLine();
					chosen = cart.viewMedia(title);
					if (chosen != null) {
						if (chosen instanceof DigitalVideoDisc) {
							((DigitalVideoDisc) chosen).play();
						} else if (chosen instanceof CompactDisc){
							((CompactDisc) chosen).play();
						} else {
							System.out.println(title + " not playable");
						}
					}
					break;
				//5. Place order
				case 5:
					if (cart.isEmpty()) {
						System.out.println("cant place order: cart empty");
					} else {
						cart.placeOrder();
					}
					break;
				//0. Exit
				case 0:
					break;
				}
				break;
			//0. Exit
			case 0:
				System.exit(0);
			}
		}
	}

	public static void showMenu() {
		System.out.println("--------------------------------");
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("--------------------------------");
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void cartMenu() {
		System.out.println("--------------------------------");
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
}
