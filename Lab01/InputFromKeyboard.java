import java.util.Scanner;

public class InputFromKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is your name?");
		String strName = scanner.nextLine();
		System.out.println("How old are you");
		int age = scanner.nextInt();
		System.out.println("How tall are you? (m)");
		double height = scanner.nextDouble();
		
		System.out.println("Mr/Mrs " + strName + ", " + String.valueOf(age) + " years old, " + 
		String.valueOf(height) + " meters tall.");
	}

}
