package hust.soict.dsai.aims.screen;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.InvalidDataException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends JFrame{

	private Store store;
	private Cart cart;

	public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;

		Container cp = getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));

		JMenu menu = new JMenu("Options");

		JMenu smUpdateStore = new JMenu("Update Store");

		JMenuItem addBook = new JMenuItem("Add Book");
		JMenuItem addCD = new JMenuItem("Add CD");
		JMenuItem addDVD = new JMenuItem("Add DVD");

		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);

		menu.add(smUpdateStore);
		JMenuItem optionStore = new JMenuItem("View store");
		menu.add(optionStore);

		JMenuItem optionCart = new JMenuItem("View cart");
		menu.add(optionCart);

		optionCart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CartScreen(cart, store);
				setVisible(false);
			}
		});

		addBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddBookToStoreScreen(store, cart);
				setVisible(false);
			}
		});

		addCD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCompactDiscToStoreScreen(store, cart);
				setVisible(false);
			}
		});

		addDVD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddDigitalVideoDiscToStoreScreen(store, cart);
				setVisible(false);
			}
		});

		optionStore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreScreen(store, cart);
				setVisible(false);
			}
		});

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		cp.add(menuBar);

		cp.add(new JLabel("Title:"));
		JTextField title = new JTextField();
		cp.add(title);

		cp.add(new JLabel("Category:"));
		JTextField category = new JTextField();
		cp.add(category);

		cp.add(new JLabel("Cost:"));
		JTextField cost = new JTextField();
		cp.add(cost);

		cp.add(new JLabel("---------------------------"));

		JTextField director = new JTextField();
		JTextField dvdLength = new JTextField();

		cp.add(new JLabel("Director:"));
		cp.add(director);

		cp.add(new JLabel("Length:"));	
		cp.add(dvdLength);

		cp.add(new JLabel("---------------------------"));

		JButton confirm = new JButton("Confirm add to store");
		cp.add(confirm);

		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DigitalVideoDisc dvd = new DigitalVideoDisc(title.getText(), category.getText(), director.getText(), Integer.parseInt(dvdLength.getText()), Float.parseFloat(cost.getText()));
					JOptionPane.showMessageDialog(cp, store.addMedia(dvd));
				} catch (NumberFormatException | InvalidDataException e2) {
					if (e2 instanceof NumberFormatException) {
						JOptionPane.showMessageDialog(cp, "Invalid number");
					}
				}
				title.setText("");
				category.setText("");
				cost.setText("");
				dvdLength.setText("");
				director.setText("");
			}
		});

		setVisible(true);
		setTitle("Add DVD" + " to store");
		setSize(400, 400);
	}
}
