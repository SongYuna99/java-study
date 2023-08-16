package prob05;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException() {
		super("존재하지 않는 사용자입니다.");
	}
}
