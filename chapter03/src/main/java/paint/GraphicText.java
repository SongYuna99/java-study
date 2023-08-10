package paint;

public class GraphicText implements Drawable {
	private String text;

	// constructor
	public GraphicText(String text) {
		this.text = text;
	}

	// method
	@Override
	public void draw() {
		System.out.println("텍스트 '" + text + "'를 그렸습니다.");
	}

}
