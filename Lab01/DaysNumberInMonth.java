
import javax.swing.JOptionPane;

public class DaysNumberInMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//My input on month variable not working somehow :\ so i tried with a value like this and it works.
		String month = "May";
		int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Input year"));
		
		if (month == "February" || month == "Feb" || month == "Feb." || month == "2") {
			if (year % 4 == 0) {
				if (year % 100 == 0 ) {
					if (year % 400 == 0) {
						JOptionPane.showMessageDialog(null, "Number of days: 29");
					} else {
						JOptionPane.showMessageDialog(null, "Number of days: 28");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Number of days: 29");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Number of days: 28");
			}
		} else if (month == "January" || month == "Jan" || month == "Jan." || month == "1" ||
				month == "March" || month == "Mar" || month == "Mar." || month == "3" ||
				month == "May" || month == "May" || month == "5" ||
				month == "July" || month == "Jul" || month == "July" || month == "7" ||
				month == "August" || month == "Aug" || month == "Aug." || month == "8" ||
				month == "October" || month == "Oct" || month == "Oct." || month == "10" ||
				month == "December" || month == "Dec" || month == "Dec." || month == "12") {
			JOptionPane.showMessageDialog(null, "Number of days: 31");
		} else {
			JOptionPane.showMessageDialog(null, "Number of days: 30");
		}
	}

}
