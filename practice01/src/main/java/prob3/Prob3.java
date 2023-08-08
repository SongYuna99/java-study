package prob3;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int input = scan.nextInt();
		int startNum = 1;

		if ((input % 2) == 0) {
			startNum = 2;
		}

		int result = 0;
		for (int i = startNum; i < input + 1; i = i + 2) {
			result += i;
		}
		System.out.println("결과 값 : " + result);
		
		scan.close();
	}

}
