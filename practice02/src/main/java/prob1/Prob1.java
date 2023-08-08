package prob1;

import java.util.Scanner;

public class Prob1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("금액 : ");
		int money = scan.nextInt();
		final int[] paper = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		int[] paperCount = new int[paper.length];

		for (int i = 0; i < paper.length; i++) {
			paperCount[i] = money / paper[i];
			money -= paper[i] * paperCount[i];
		}
		for (int i = 0; i < paper.length; i++) {
			System.out.println(paper[i] + "원 : " + paperCount[i] + "개" + "");
		}
		scan.close();
	}

}
