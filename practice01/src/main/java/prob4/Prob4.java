package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		String input = scan.nextLine();

		for (int i = 1; i < input.length() + 1; i++) {
			System.out.println(input.substring(0, i));
		}
		
		scan.close();
	}

}
