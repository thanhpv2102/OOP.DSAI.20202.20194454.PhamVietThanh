import java.util.Scanner;

public class EX63 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the triangle's height?");
		int n = keyboard.nextInt();
		for (int i = 1; i <= n; i++) {
			String spaces = "";
			String stars = "";
			for (int j = 0; j < n-i; j++) {
				spaces += " ";
			}
			for (int j = 0; j < 2*i - 1; j++) {
				stars += "*";
			}
			System.out.println(spaces + stars + spaces);
		}
	}

}
