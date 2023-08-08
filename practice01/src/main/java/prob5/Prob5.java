package prob5;

public class Prob5 {

	public static void main(String[] args) {
		int maxNum = 99;

		for (int i = 1; i < maxNum + 1; i++) {
			int num1 = i % 10;
			int num2 = i / 10;
			int clapCount = 0;

			if (num1 == 3 || num1 == 6 || num1 == 9) {
				clapCount++;
			}
			if (num2 == 3 || num2 == 6 || num2 == 9) {
				clapCount++;
			}

			if (clapCount > 0) {
				System.out.print(i + " ");
				for (int k = 0; k < clapCount; k++) {
					System.out.print("짝");
				}
				System.out.println();
			}
		}
	}

}
