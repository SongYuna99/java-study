package prob1;

import java.util.Scanner;

public class Prob1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("수를 입력하시오 : ");
		int input = scan.nextInt();

		if ((input % 3) == 0) {
			System.out.println("3의 배수입니다.");
		} else {
			System.out.println("3의 배수가 아닙니다.");
		}
		
		scan.close();
	}

}
