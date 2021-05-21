package hust.soict.dsai.aims.screen;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.InsertionException;
import hust.soict.dsai.aims.exception.InvalidDataException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends JFrame{

	private Store store;
	private Cart cart;

	public AddCompactDiscToStoreScreen(Store store, Cart cart) {
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

		cp.add(new JLabel("---------"));

		cp.add(new JLabel("Artist:"));
		JTextField artist = new JTextField();
		cp.add(artist);

		cp.add(new JLabel("Director:"));
		JTextField director = new JTextField();
		cp.add(director);

		cp.add(new JLabel("---------------------------"));

		JTextField trackTitle = new JTextField();
		JTextField trackLength = new JTextField();
		JButton btnTrack = new JButton("Add track to CD");

		cp.add(new JLabel("Track title:"));	
		cp.add(trackTitle);
		cp.add(new JLabel("Track length:"));
		cp.add(trackLength);

		cp.add(btnTrack);

		cp.add(new JLabel("---------------------------"));

		cp.add(new JLabel("List of Track:"));
		DefaultListModel<Track> model = new DefaultListModel();
		JList<Track> listTrack = new JList(model);
		cp.add(listTrack);

		btnTrack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addElement(new Track(Integer.parseInt(trackLength.getText()), trackTitle.getText()));
				trackTitle.setText("");
				trackLength.setText("");
			}
		});

		cp.add(new JLabel("---------------------------"));

		JButton confirm = new JButton("Confirm add to store");
		cp.add(confirm);

		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					CompactDisc cd = new CompactDisc(title.getText(), category.getText(), artist.getText(), director.getText(), Float.parseFloat(cost.getText()));
					for (int i = 0; i < model.getSize(); i++) {			
						JOptionPane.showMessageDialog(cp, cd.addTrack(model.get(i)));
					}
					JOptionPane.showMessageDialog(cp, store.addMedia(cd));
				} catch (NumberFormatException | InsertionException | InvalidDataException e2) {
					if (e2 instanceof NumberFormatException) {
						JOptionPane.showMessageDialog(cp, "invalid number");
					}
				}
				title.setText("");
				category.setText("");
				cost.setText("");
				artist.setText("");
				director.setText("");
				trackLength.setText("");
				trackTitle.setText("");
				model.removeAllElements();
			}
		});

		setVisible(true);
		setTitle("Add CD"  + " to store");
		setSize(400, 600);
	}
}

