package laioffer;

public class bubbleSort {
	public static void main(String[] args) {
		int unsortedArray[] = new int[] {6, 5, 3, 1, 8, 7, 2, 4};
		sort(unsortedArray);
		System.out.println("After sort: ");
		for (int item : unsortedArray) {
			System.out.print(item + " ");
		}
	}
	public static void sort(int[] array) {
		int len = array.length;
		for (int i = 0; i < len; i++) {
//			for (int item : array) {
//				System.out.print(item + " ");
//			}
//			System.out.println();
			
			for (int j = 1; j < len - i; j++) {
				if (array[j -1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] =  array[j];
					array[j] = temp;
				}
			}
		}
	}
}
