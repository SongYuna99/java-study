package paint;

public class ColorPoint extends Point {
	private String color;

	// method
	public void show(String color) {

	}

	// getter - setter
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void show() {
		System.out.println("점 [x = " + x + ", y = " + y + ", color = " + color + "]를 지웠습니다.");
	}
}
