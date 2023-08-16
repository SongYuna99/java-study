package prob05;

@SuppressWarnings("serial")
public class PasswordDismatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PasswordDismatchException(String message) {
		super(message);
	}

	public PasswordDismatchException() {
		super("비밀번호가 틀렸습니다.");
	}
}
