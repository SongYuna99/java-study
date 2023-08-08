package prob5;

import java.util.Random;
import java.util.Scanner;

public class Prob5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		boolean flag = true;
		while (flag) {
			int min = 1;
			int max = 100;
			int correctNumber = random.nextInt(max) + min;
			System.out.println("수를 결정하였습니다. 맞추어 보세요.");

			boolean subFlag = true;
			while (subFlag) {
				int count = 0;

				System.out.println(min + " ~ " + max);
				System.out.print(count + " >> ");
				int input = scan.nextInt();

				if (input > correctNumber) {
					System.out.println("더 낮게");
					if (input < max) {
						max = input;
					}
				} else if (input < correctNumber) {
					System.out.println("더 높게");
					if (input > min) {
						min = input;
					}
				} else {
					subFlag = false;
				}
			}
			System.out.println("맞았습니다.");

			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scan.next();
			if ("n".equals(answer.toLowerCase()) == true) {
				flag = false;
			}
		}

		scan.close();
	}

}
