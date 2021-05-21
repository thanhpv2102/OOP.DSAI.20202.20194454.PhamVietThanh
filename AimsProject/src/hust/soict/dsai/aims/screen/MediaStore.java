package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
	 private Media media;
	 public MediaStore(Media media, Cart cart) {
		 this.media = media;
		 this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		 
		 JLabel title = new JLabel(media.getTitle());
		 title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		 title.setAlignmentX(CENTER_ALIGNMENT);
		 
		 JLabel cost = new JLabel("" + media.getCost() + " $");
		 cost.setAlignmentX(CENTER_ALIGNMENT);
		 
		 JPanel container = new JPanel();
		 container.setLayout(new FlowLayout(FlowLayout.CENTER));
		 
		 JButton btnAddToCart = new JButton("Add to cart");
		 container.add(btnAddToCart);
		 
		 btnAddToCart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(container, cart.addMedia(media));
			}
		});
		 
		 JButton btnPlay = new JButton("Play");
		 
		 if (media instanceof Playable) {
			 container.add(btnPlay);
			 btnPlay.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							if (media instanceof CompactDisc) {
								JOptionPane.showMessageDialog(container, ((CompactDisc) media).play());
							} else {
								JOptionPane.showMessageDialog(container, ((DigitalVideoDisc) media).play());
							}
						} catch (PlayerException e1) {
							e1.printStackTrace();
						}
					}
				});
		 }
		 
		 this.add(Box.createVerticalGlue());
		 this.add(title);
		 this.add(cost);
		 this.add(Box.createVerticalGlue());
		 this.add(container);
		 
		 this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	 
		 
	 }
}
