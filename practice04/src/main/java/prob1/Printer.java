package prob1;

public class Printer {
//	public void println(Object content) {
//		System.out.println(String.valueOf(content));
//
//	}
//
//	public void println(int content) {
//		System.out.println(String.valueOf(content));
//	}
//
//	public void println(boolean content) {
//		System.out.println(String.valueOf(content));
//	}
//
//	public void println(double content) {
//		System.out.println(String.valueOf(content));
//	}
//
//	public void println(String content) {
//		System.out.println(String.valueOf(content));
//	}
//
//	public <T> void println(T t) {
//		System.out.println(t);
//	}

	public <T> void println(T... ts) {
		for (T t : ts) {
			System.out.print(t + " ");
		}
		System.out.println();
	}

	public int sum(Integer... nums) {
		int s = 0;
		for (Integer i : nums) {
			s += i;
		}
		return s;
	}
}
