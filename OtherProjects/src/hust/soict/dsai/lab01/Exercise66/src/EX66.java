import java.util.*;

public class EX66 {
	
	public static void printMatrix(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	public static void main(String[] args) {
		
		System.out.println("The size of the matrix will be m x n.");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input m.");
		int m = keyboard.nextInt();
		System.out.println("Please input n.");
		int n = keyboard.nextInt();
		
		System.out.println("Please enter the first matrix.");
		double[][] arr1 = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(". . .");
				arr1[i][j] = keyboard.nextDouble();
			}
		}
		System.out.println("The first matrix is:");
		printMatrix(arr1);
		
		System.out.println("Please enter the second matrix.");
		double[][] arr2 = new double[m][n];
		double[][] sum = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(". . .");
				arr2[i][j] = keyboard.nextDouble();
				sum[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		System.out.println("The second matrix is:");
		printMatrix(arr2);
		System.out.println("The sum of them is:");
		printMatrix(sum);

	}

}
