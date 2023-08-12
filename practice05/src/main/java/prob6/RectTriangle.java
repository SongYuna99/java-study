package prob6;

public class RectTriangle extends Shape {
	private double width;
	private double height;

	public RectTriangle(double w, double h) {
		this.width = w;
		this.height = h;
	}

	@Override
	public double getArea() {
		double perimeter = width * height / 2;
		return perimeter;
	}

	@Override
	public double getPerimeter() {
		double area = Math.sqrt((width * width) + (height * height)) + width + height;
		return area;
	}
}
