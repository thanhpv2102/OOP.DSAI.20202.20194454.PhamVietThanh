import java.util.Scanner;

public class EX64 {
	
	public static boolean isInteger(String str) {
		try {
			Integer.valueOf(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		boolean valid = true;
		do {
			valid = true;
			Scanner keyboard = new Scanner(System.in);
			System.out.println("What is the month?");
			String month = keyboard.nextLine();
			System.out.println("What is the year?");
			String inputYear = keyboard.nextLine();
			
			if (isInteger(inputYear)) {
				int year = Integer.valueOf("3");
				if (month.equals("January") || month.equals("Jan") || month.equals("Jan.") || month.equals("1")) {
					System.out.println("The number of days of that month is: 31");
				} else if (month.equals("February") || month.equals("Feb") || month.equals("Feb.") || month.equals("2")) {
					if (year % 4 == 0) {
						System.out.println("The number of days of that month is: 29");
					} else {
						System.out.println("The number of days of that month is: 28");
					}
				} else if (month.equals("March") || month.equals("Mar") || month.equals("Mar.") || month.equals("3")) {
					System.out.println("The number of days of that month is: 31");
				} else if (month.equals("April") || month.equals("Apr") || month.equals("Apr.") || month.equals("4")) {
					System.out.println("The number of days of that month is: 30");
				} else if (month.equals("May") || month.equals("May.") || month.equals("5")) {
					System.out.println("The number of days of that month is: 31");
				} else if (month.equals("June") || month.equals("Jun") || month.equals("Jun.") || month.equals("6")) {
					System.out.println("The number of days of that month is: 30");
				} else if (month.equals("July") || month.equals("Jul") || month.equals("Jul.") || month.equals("7")) {
					System.out.println("The number of days of that month is: 31");
				} else if (month.equals("August") || month.equals("Aug") || month.equals("Aug.") || month.equals("8")) {
					System.out.println("The number of days of that month is: 31");
				} else if (month.equals("September") || month.equals("Sep") || month.equals("Sep.") || month.equals("9")) {
					System.out.println("The number of days of that month is: 30");
				} else if (month.equals("October") || month.equals("Oct") || month.equals("Oct.") || month.equals("10")) {
					System.out.println("The number of days of that month is: 31");
				} else if (month.equals("November") || month.equals("Nov") || month.equals("Nov.") || month.equals("11")) {
					System.out.println("The number of days of that month is: 30");
				} else if (month.equals("December") || month.equals("Dec") || month.equals("Dec.") || month.equals("12")) {
					System.out.println("The number of days of that month is: 31");
				}
			} else {
				System.out.println("Please enter invalid month and year.");
				valid = false;
			}
		} while (valid == false);
	}
}
