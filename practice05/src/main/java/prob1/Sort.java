package prob1;

public class Sort {

	public static void main(String[] arg) {

		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int count = array.length;

		System.out.println("Before sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}

		for (int round = 0; round < count - 1; round++) {
			for (int idx = 0; idx < count - round - 1; idx++) {
				if (array[idx] < array[idx + 1]) {
					int temp = array[idx];
					array[idx] = array[idx + 1];
					array[idx + 1] = temp;
				}
			}
		}

		// 결과 출력
		System.out.println("\nAfter Sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}
	}
}