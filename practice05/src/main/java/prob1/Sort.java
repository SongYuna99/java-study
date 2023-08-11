package prob1;

public class Sort {

	public static void main(String[] arg) {

		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int count = array.length;

		System.out.println("Before sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}

		for (int front = 0; front < count - 1; front++) {
			if (array[front] < array[front + 1]) {
				int temp = array[front];
				array[front] = array[front + 1];
				array[front + 1] = temp;

				for (int i = 0; i < count; i++) {
					System.out.print(array[i] + " ");
				}
				System.out.println();
				
			}
		}

		// 결과 출력
		System.out.println("\nAfter Sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}
	}
}