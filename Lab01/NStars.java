import java.util.Scanner;

public class NStars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input n");
		int n = scanner.nextInt();
		
		String result;
		int incr = 1;
		int current = 1;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1) {
				incr++;
				result = "";
				for (int j = 1; j <= current + incr; j++) {
					result += "*";
				}
				System.out.println(result);
				
			} else {
				result = "";
				for (int j = 1; j <= current + incr; j++) {
					result += "*";
				}
				System.out.println(result);
			}
			current += incr;
		}
	}

}
