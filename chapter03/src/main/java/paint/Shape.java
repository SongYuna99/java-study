package paint;

public abstract class Shape implements Drawable {
	private String lineColor;
	private String fillColor;

	// method
	@Override
	public abstract void draw();

	// getter - setter
	public String getLineColor() {
		return lineColor;
	}

	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}

	public String getFillColor() {
		return fillColor;
	}

	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

}
