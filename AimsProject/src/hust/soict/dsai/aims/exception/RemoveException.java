package hust.soict.dsai.aims.exception;

import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RemoveException extends Throwable{

	public RemoveException(String error) {
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JOptionPane.showMessageDialog(container, error);
	}

}
