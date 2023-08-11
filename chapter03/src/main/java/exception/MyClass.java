package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException {
		System.out.println("some codes1... ");
		System.out.println("some codes2... ");

		if ((3 - 3) == 0) {
			throw new MyException();
		}
		if ((1 - 1) == 0) {
			throw new IOException();
		}

		System.out.println("some codes3... ");
		System.out.println("some codes4... ");
	}
}
