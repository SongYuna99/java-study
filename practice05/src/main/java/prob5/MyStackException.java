package prob5;

public class MyStackException extends Exception {
	private static final long serialVersionUID = 1L;

	public MyStackException(String message) {
		super(message);
	}

	public MyStackException() {
		super("Prob05.MyStackException: stack is empty");
	}
}
