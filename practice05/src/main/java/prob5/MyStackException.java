package prob5;

import java.util.EmptyStackException;

public class MyStackException extends EmptyStackException {
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() throws EmptyStackException {
		return "Prob5.MyStackException: stack is empty";
	}

	public MyStackException() {
	}
}
