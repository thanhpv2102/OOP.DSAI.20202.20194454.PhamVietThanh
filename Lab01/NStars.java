import java.util.Scanner;

public class NStars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input n");
		int n = scanner.nextInt();


		int i, j, k;
		for(i = 1; i <= n; i++)
		{
			for(j = n; j > i; j--)
			{
				System.out.print(" ");
			}
			for(k = 1; k < (i * 2); k++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

