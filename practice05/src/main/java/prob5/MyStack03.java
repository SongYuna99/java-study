package prob5;

public class MyStack03<T> {
	private T[] buffer;
	private int top;

	public MyStack03(int capacity) {
		this.buffer = (T[]) new Object[capacity];
		this.top = 0;
	}

	public void push(T t) throws MyStackException {
		if (top > (buffer.length - 1)) {
			resize();
		}
		buffer[top++] = t;
	}

	public void resize() {
		T[] newBuffer = (T[]) new Object[buffer.length * 2];

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

	public T pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException();
		}
		T s = buffer[--top];
		buffer[top] = null;
		return s;
	}
}