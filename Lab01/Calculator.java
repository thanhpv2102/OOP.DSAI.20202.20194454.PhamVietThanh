import javax.swing.JOptionPane;

public class Calculator {

	public static void main(String[] args) {
		double num1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input first num", "Input",
				JOptionPane.INFORMATION_MESSAGE));
		double num2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Input second num", "Input",
				JOptionPane.INFORMATION_MESSAGE));
		
		double sum = num1 + num2;
		double difference = Math.abs(num1 - num2);
		double product = num1 * num2;
		double quotient = num1 / num2;
		
		String result = "Sum: " + String.valueOf(sum) + "\n" +
				"Difference: " + String.valueOf(difference) + "\n" +
				"Product: " + String.valueOf(product) + "\n" +
				"Quotient: " + String.valueOf(quotient) + "\n";
		JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

}
