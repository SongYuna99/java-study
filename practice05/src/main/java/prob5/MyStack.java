package prob5;

public class MyStack {
	private String[] buffer;

	public MyStack(int num) {
		this.buffer = new String[num];
	}

	public void push(String string) {
		for (int i = 0; i < buffer.length; i++) {
			if (buffer[i] == null) {
				buffer[i] = string;
			}
		}
	}

	public boolean isEmpty() {
		for (int i = 0; i < buffer.length; i++) {
			if (buffer[i] != null) {
				return false;
			}
		}
		return true;
	}

	public String pop() {
		String s = null;
		for (int i = 0; i < buffer.length; i++) {
			if (buffer[i] != null) {
				s = buffer[i];
				buffer[i] = null;
			}
		}
		return s;
	}
}