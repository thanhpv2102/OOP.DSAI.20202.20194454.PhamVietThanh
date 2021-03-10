
public class ArraySorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 5, 2, 7, 3, 2019, 2020, 1990};

		int sum = 0;
		for (int i = 0; i <= arr.length -1; i++) {
			sum += arr[i];
		}
		double average = sum / arr.length;
		System.out.println("Sum: " + String.valueOf(sum) + "\nAverage: " + String.valueOf(average));

		int temp;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr [j - 1]) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
		System.out.println("Sorted array: ");
		for (int i = 0; i <= arr.length -1; i++) {
			System.out.println(String.valueOf(arr[i]));
		}
	}

}
