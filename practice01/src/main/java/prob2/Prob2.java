package prob2;

public class Prob2 {

	public static void main(String[] args) {
		int startNum = 1;
		while (startNum < 11) {
			for (int i = startNum; i < startNum + 10; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
			startNum++;
		}
	}

}
