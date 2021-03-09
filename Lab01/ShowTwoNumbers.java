import javax.swing.JOptionPane;

public class ShowTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = "You just enter: ";
		
		String num1 = JOptionPane.showInputDialog(null, "Please input first number", "Input first number",
				JOptionPane.INFORMATION_MESSAGE);
		String num2 = JOptionPane.showInputDialog(null, "Please input second number", "Input second number",
				JOptionPane.INFORMATION_MESSAGE);
		
		result += num1 + " and " + num2;
		
		JOptionPane.showMessageDialog(null, result, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

}
