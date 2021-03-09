import javax.swing.JOptionPane;

public class SolveEquation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a, b, c, a11, a12, a21, a22, b1, b2;
		//ax + b = 0
		
		a = Double.parseDouble(JOptionPane.showInputDialog("Input a for ax + b = 0"));
		b = Double.parseDouble(JOptionPane.showInputDialog("Input b for ax + b = 0"));
		if (a == 0) {
			if (b == 0) {
				JOptionPane.showMessageDialog(null, "There are infinitely many solutions");
			} else {
				JOptionPane.showMessageDialog(null, "There is no solution");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Solution: " + String.valueOf(- b / a));
		}
		
		//System of two linear equations
		a11 = Double.parseDouble(JOptionPane.showInputDialog("Input a11 for the first equation"));
		a12 = Double.parseDouble(JOptionPane.showInputDialog("Input a12 for the first equation"));
		b1 = Double.parseDouble(JOptionPane.showInputDialog("Input b1 for the first equation"));
		a21 = Double.parseDouble(JOptionPane.showInputDialog("Input a21 for the second equation"));
		a22 = Double.parseDouble(JOptionPane.showInputDialog("Input a22 for the second equation"));
		b2 = Double.parseDouble(JOptionPane.showInputDialog("Input b2 for the second equation"));
				
		double x1, x2;
		
		if (a12 * a21 / a11 - a22 == 0) {
			if (b1 * a21 / a11 - b2 == 0) {
				JOptionPane.showMessageDialog(null, "There are infinitely many solutions");
			} else {
				JOptionPane.showMessageDialog(null, "There is no solution");
			}
		} else {
			x2 = (b1 * a21 / a11 - b2) / (a12 * a21 / a11 - a22);
			x1 = (b1 - a12*x2) / a11;
			JOptionPane.showMessageDialog(null, "Solution: \nx1: " + String.valueOf(x1) + 
					"\nx2: " + String.valueOf(x2));
		}
		
		//ax^2 + bx + c = 0
		a = Double.parseDouble(JOptionPane.showInputDialog("Input a for the equation"));
		b = Double.parseDouble(JOptionPane.showInputDialog("Input b for the equation"));
		c = Double.parseDouble(JOptionPane.showInputDialog("Input b for the equation"));
		
		double delta = b*b - 4*a*c;
		if (delta < 0) {
			JOptionPane.showMessageDialog(null, "There is no solution");
		} else if (delta == 0) {
			JOptionPane.showMessageDialog(null, "Solution: x= " + String.valueOf(-b / (2*a)));
		} else {
			JOptionPane.showMessageDialog(null, "Solution: \nx1: " + String.valueOf((-b - Math.sqrt(delta)) / (2*a)) + 
					"\nx2: " + String.valueOf((-b + Math.sqrt(delta)) / (2*a)));
		}
		
		System.exit(0);
	}

}
