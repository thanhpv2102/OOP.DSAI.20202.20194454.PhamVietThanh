package hust.soict.dsai.aims.exception;

import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InsertionException extends Throwable{

	public InsertionException(String error) {
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JOptionPane.showMessageDialog(container, error);
	}

}
