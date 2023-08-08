package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);

		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}

	public static char[] reverse(String str) {
		char[] c = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			c[i] = str.charAt(str.length() - i - 1);
		}

		return c;
	}

	public static void printCharArray(char[] array) {
		StringBuffer sb = new StringBuffer();
		for(int i =0;i<array.length;i++) {
			sb.append(array[i]);
		}
		System.out.println(sb.toString());
	}
}
