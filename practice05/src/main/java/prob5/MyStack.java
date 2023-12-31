package prob5;

public class MyStack {
	private String[] buffer;
	private int top;

	public MyStack(int num) {
		this.buffer = new String[num];
		this.top = 0;
	}

	public void push(String string) throws MyStackException {
		if (top > (buffer.length - 1)) {
			resize();
		}
		buffer[top++] = string;
	}

	public void resize() {
		String[] newBuffer = new String[buffer.length * 2];

		for (int i = 0; i < top; i++) {
			newBuffer[i] = buffer[i];
		}
		buffer = newBuffer;
	}

	public boolean isEmpty() {
		if (top != 0) {
			return false;
		}
		return true;
	}

	public String pop() throws MyStackException {
		top--;
		if (top < 0) {
			throw new MyStackException();
		}
		String s = buffer[top];
		buffer[top] = null;
		return s;
	}
}