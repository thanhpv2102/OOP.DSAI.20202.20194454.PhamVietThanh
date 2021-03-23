/**
 *This is the exercise 2.2.6
 *
 */
import javax.swing.JOptionPane;
import java.lang.Math;

public class EqSolver {
	public static void main(String[] args) {
		String[] options = {"Linear equation with one variable",
			 "System of linear equations with two variables", 
			 "Second-degree equation with one variable"};
		String cont = "Yes";
		while (cont == "Yes") {
			String userChoice = (String)JOptionPane.showInputDialog(null, "What kind of problem do you want to solve?",
				 "Select problem", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (userChoice == options[0]) {
				double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input coefficient a: (ax + b = 0)",
				 	"Input equation", JOptionPane.INFORMATION_MESSAGE));
				double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input coefficient b: (ax + b = 0)",
				 	"Input equation", JOptionPane.INFORMATION_MESSAGE));

				if (a == 0) {
					if (b==0) {
						JOptionPane.showMessageDialog(null, "The equation \n"
							+ "\t" + Double.toString(a) + "x + " + Double.toString(b) + " = 0" + "\n"
							+ "has infinitely many solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "The equation \n"
							+ "\t" + Double.toString(a) + "x + " + Double.toString(b) + " = 0" + "\n"
							+ "has no solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "The equation \n"
							+ "\t" + Double.toString(a) + "x + " + Double.toString(b) + " = 0" + "\n"
							+ "has unique solution: " + "x = " + Double.toString(-b/a), "Solution", JOptionPane.INFORMATION_MESSAGE);
				}
			} else if (userChoice == options[1]) {
				double a11 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input coefficient a11: (a11.x1 + a12.x2 = b1)",
				 	"Input the first equation", JOptionPane.INFORMATION_MESSAGE));
				double a12 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input coefficient a12: (a11.x1 + a12.x2 = b1)",
				 	"Input the first equation", JOptionPane.INFORMATION_MESSAGE));
				double b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input coefficient b1: (a11.x1 + a12.x2 = b1)",
				 	"Input the first equation", JOptionPane.INFORMATION_MESSAGE));
				double a21 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input coefficient a21: (a21.x1 + a22.x2 = b2)",
				 	"Input the second equation", JOptionPane.INFORMATION_MESSAGE));
				double a22 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input coefficient a22: (a21.x1 + a22.x2 = b2)",
				 	"Input the second equation", JOptionPane.INFORMATION_MESSAGE));
				double b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input coefficient b2: (a21.x1 + a22.x2 = b2)",
				 	"Input the second equation", JOptionPane.INFORMATION_MESSAGE));
				double determinant = a11*a22 - a21*a12;

				if (determinant == 0) {
					double d1 = a11*b2 - a21*b1;
					if (d1 == 0) {
						JOptionPane.showMessageDialog(null, "The system of equation: \n"
							+ "\t" + Double.toString(a11) + ".x1 + " + Double.toString(a12) + "x2 = " + Double.toString(b1) + "\n"
							+ "\t" + Double.toString(a21) + ".x1 + " + Double.toString(a22) + "x2 = " + Double.toString(b2) + "\n"
							+ "has infinitely many solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "The system of equation: \n"
							+ "\t" + Double.toString(a11) + ".x1 + " + Double.toString(a12) + "x2 = " + Double.toString(b1) + "\n"
							+ "\t" + Double.toString(a21) + ".x1 + " + Double.toString(a22) + "x2 = " + Double.toString(b2) + "\n"
							+ "has no solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
					}
				} else if (a11 != 0) {
					a22 -= a12*(a21/a11);
					b2 -= b1*(a21/a11);
					double x2 = b2/a22;
					double x1 = (b1 - a12*x2)/a11;
					JOptionPane.showMessageDialog(null, 
						"The system of equation: \n"
						+ "\t" + Double.toString(a11) + ".x1 + " + Double.toString(a12) + "x2 = " + Double.toString(b1) + "\n"
						+ "\t" + Double.toString(a21) + ".x1 + " + Double.toString(a22) + "x2 = " + Double.toString(b2) + "\n"
						+ "has unique solution: \n"
						+ "\t" + "x1 = " + Double.toString(x1) + "\n"
						+ "\t" + "x2 = " + Double.toString(x2) + "\n", "Solution", JOptionPane.INFORMATION_MESSAGE); 
				} else if (a11 == 0) {
					double x2 = b1/a12;
					double x1 = (b2 - a22*x2)/a21;
					JOptionPane.showMessageDialog(null, 
						"The system of equation: \n"
						+ "\t" + Double.toString(a11) + ".x1 + " + Double.toString(a12) + "x2 = " + Double.toString(b1) + "\n"
						+ "\t" + Double.toString(a21) + ".x1 + " + Double.toString(a22) + "x2 = " + Double.toString(b2) + "\n"
						+ "has unique solution: \n"
						+ "\t" + "x1 = " + Double.toString(x1) + "\n"
						+ "\t" + "x2 = " + Double.toString(x2) + "\n", "Solution", JOptionPane.INFORMATION_MESSAGE); 
				}
			} else if (userChoice == options[2]) {
				double aa = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input coefficient a: (a.x1^2 + b.x + c = 0)",
				 	"Input equation", JOptionPane.INFORMATION_MESSAGE));
				double bb = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input coefficient b: (a.x1^2 + b.x + c = 0)",
				 	"Input equation", JOptionPane.INFORMATION_MESSAGE));
				double cc = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input coefficient c: (a.x1^2 + b.x + c = 0)",
				 	"Input equation", JOptionPane.INFORMATION_MESSAGE));
				double delta = bb*bb - 4*aa*cc;

				if (aa == 0) {
					JOptionPane.showMessageDialog(null, "a = 0, you can try linear equation instead", null, JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (delta < 0) {
						JOptionPane.showMessageDialog(null, "The equation \n"
							+ "\t" + Double.toString(aa) + "x^2 + " + Double.toString(bb) + "x + " + Double.toString(cc) + " = 0" + "\n"
							+ "has no solution", "Solution", JOptionPane.INFORMATION_MESSAGE);
					} else if (delta == 0) {
						double xx = -bb/(2*aa);
						JOptionPane.showMessageDialog(null, "The equation \n"
							+ "\t" + Double.toString(aa) + "x^2 + " + Double.toString(bb) + "x + " + Double.toString(cc) + " = 0" + "\n"
							+ "has solution: " + "x = " + Double.toString(xx), "Solution", JOptionPane.INFORMATION_MESSAGE);
					} else {
						double xx1 = (-bb - Math.sqrt(delta))/(2*aa);
						double xx2 = (-bb + Math.sqrt(delta))/(2*aa);
						JOptionPane.showMessageDialog(null, "The equation \n"
							+ "\t" + Double.toString(aa) + "x^2 + " + Double.toString(bb) + "x + " + Double.toString(cc) + " = 0" + "\n"
							+ "has solution: " + "\n"
							+ "\t" + "x1 = " + Double.toString(xx1) + "\n"
							+ "\t" + "x2 = " + Double.toString(xx2), "Solution", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
			cont = (JOptionPane.showConfirmDialog(null, "Do you want continue solving problems?") == JOptionPane.YES_OPTION)? "Yes": "No";
		}
	}
}