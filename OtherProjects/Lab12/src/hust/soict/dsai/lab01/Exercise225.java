/**
 * This is exercise 2.2.5
 */
import javax.swing.JOptionPane;
public class DoubleNumbers {
	public static void main(String[] args){
		double num1 = Double.parseDouble(JOptionPane.showInputDialog("Please input the first number: "));
		double num2 = Double.parseDouble(JOptionPane.showInputDialog("Please input the second number: "));
		
		double sum = num1 + num2;
		double difference;
		
		if (num1 > num2) {
			difference = num1 - num2;
		} else {
			difference = num2 - num1;
		}

		double product = num1*num2;
		double quotient = num1/num2;

		JOptionPane.showMessageDialog(null, "You input two numbers: " + Double.toString(num1) + " and " + Double.toString(num2) + "\n"
				+ "Their sum is: " + Double.toString(sum) + "\n"
				+ "Their difference is: " + Double.toString(difference) + "\n"
				+ "Their product is: " + Double.toString(product) + "\n"
				+ "Their quotient is: " + Double.toString(quotient), "Solution", JOptionPane.INFORMATION_MESSAGE);
	}
}