package prob5;

public class Base {
	public void service(String state) {
		if (state.equals("낮")) {
			day();
		} else {
			night();
		}
	}

	public void day() {
		System.out.println("낮에는 열심히 일하자!");
	}

	public void night() {
		System.out.println("night");
	}

}
