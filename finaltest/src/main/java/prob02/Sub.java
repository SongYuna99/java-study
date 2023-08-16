package prob02;

public class Sub implements Arithmetic {

	@Override
	public int calculate(int a, int b) {
		int result = a - b;
		return result;
	}

}