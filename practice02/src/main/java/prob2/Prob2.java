package prob2;

import java.util.Scanner;

public class Prob2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] intArray = new int[5];
		double sum = 0;

		System.out.println(intArray.length + "개의 숫자를 입력하세요.");
		for (int i = 0; i < 5; i++) {
			int n = scan.nextInt();
			intArray[i] = n;
			sum += n;
		}

		double avg = sum / (double) intArray.length;
		System.out.println("평균은 " + avg + " 입니다.");
		scan.close();
	}

}
