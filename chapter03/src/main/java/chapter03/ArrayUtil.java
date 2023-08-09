package chapter03;

public class ArrayUtil {
	static double[] intToDouble(int[] a) {
		double[] d = new double[a.length];
		for (int i = 0; i < a.length; i++) {
//			d[i] = (double) a[i];
			d[i] = a[i];
		}

		return d;
	}

	public static int[] doubleToInt(double[] d) {
		int[] a = new int[d.length];
		for (int i = 0; i < a.length; i++) {
//			a[i] = (int) d[i];
		}

		return a;
	}

	public static int[] concat(int[] a1, int[] a2) {
		int[] a3 = new int[a1.length + a2.length];
		int index = 0;
		for (int i : a1) {
			a3[index++] = i;
		}
		for (int i : a2) {
			a3[index++] = i;
		}

		return a3;
	}

}
