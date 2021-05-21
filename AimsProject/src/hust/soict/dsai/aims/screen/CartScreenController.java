package hust.soict.dsai.aims.screen;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.exception.RemoveException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartScreenController {

	private Cart cart;
	private Store store;

	@FXML
	MenuItem optionStore;

	@FXML
	MenuItem addBook;

	@FXML
	MenuItem addCD;

	@FXML
	MenuItem addDVD;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediacategory;

	@FXML
	private TableColumn<Media, Float> colMediaCost;

	@FXML
	private Button btnPLay;

	@FXML
	private Button btnRemove;

	@FXML
	private Label txtCost;

	@FXML
	private Button btnPlaceOrder;

	public CartScreenController(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
	}

	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());

		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> arg0, Media arg1, Media arg2) {
				if (arg2 != null) {
					updateButtonBar(arg2);
				}
			}	
		});

		txtCost.setText(cart.totalCost()+" $");	

		btnPlaceOrder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				JPanel container = new JPanel();
				container.setLayout(new FlowLayout(FlowLayout.CENTER));
				JOptionPane.showMessageDialog(container, cart.placeOrder());
				txtCost.setText(cart.totalCost()+" $");	
			}
		});

		optionStore.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				new StoreScreen(store, cart);
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(CartScreen.fxPanel);
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

		addBook.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				new AddBookToStoreScreen(store, cart);
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(CartScreen.fxPanel);
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

		addCD.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				new AddCompactDiscToStoreScreen(store, cart);
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(CartScreen.fxPanel);
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});

		addDVD.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				new AddDigitalVideoDiscToStoreScreen(store, cart);
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(CartScreen.fxPanel);
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});
	}

	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPLay.setVisible(true);
		} else {
			btnPLay.setVisible(false);
		}
	}

	@FXML
	void btnRemovePressed(ActionEvent event) throws RemoveException {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		JOptionPane.showMessageDialog(container, cart.removeMedia(media));
		txtCost.setText(cart.totalCost()+" $");	
	}

	@FXML
	void btnPlayPressed(ActionEvent event) throws PlayerException {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		JOptionPane.showMessageDialog(container, ((Playable) media).play());
		txtCost.setText(cart.totalCost()+" $");	
	}
}
