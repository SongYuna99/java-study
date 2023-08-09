package prob2;

import java.util.ArrayList;
import java.util.Scanner;

public class Prob2 {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Goods[] goods = new Goods[COUNT_GOODS];
		
		System.out.println("실행 결과 : ");
		String input = scan.nextLine();
		int count = 0;
		while(count < COUNT_GOODS) {
			String[] str = input.split(" ");
			
			goods[count] = new Goods(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
			count++;
			input = scan.nextLine();
		}
		
		for(Goods g : goods) {
			g.printInfo();
		}
		
		// ArrayList 사용
//		ArrayList<Goods> goods = new ArrayList<Goods>();
//		
//		System.out.println("실행 결과 : ");
//		String input = scan.nextLine();
//		while(input != "") {
//			String[] str = input.split(" ");
//			
//			Goods g = new Goods(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
//			goods.add(g);
//			input = scan.nextLine();
//		}
//		
//		for(Goods g : goods) {
//			g.printInfo();
//		}
		
		scan.close();
	}

}
