import java.util.*;

public class EX65 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input the array length: ");
		int n = keyboard.nextInt();
		double[] arr = new double[n];
		double sum = 0;
		for (int i = 0; i < n; i++) {
			System.out.println("Please input the next element in the array: ");
			arr[i] = keyboard.nextDouble();
			sum += arr[i];
		}
		System.out.println("The unsorted array is:");
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		System.out.println("The sorted array is:");
		System.out.println(Arrays.toString(arr));
		
		System.out.println("The sum of the elements in the array is: " + String.valueOf(sum));
		
		System.out.println("The average value of the elements in the array is: " + String.valueOf(sum/n));

	}

}
