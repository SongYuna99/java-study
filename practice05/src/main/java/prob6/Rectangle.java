package prob6;

public class Rectangle extends Shape implements Resizable {
	private double width;
	private double height;

	public Rectangle(double w, double h) {
		this.width = w;
		this.height = h;
	}

	@Override
	public double getArea() {
		double perimeter = width * height;
		return perimeter;
	}

	@Override
	public double getPerimeter() {
		double area = (width * 2) + (height * 2);
		return area;
	}

	@Override
	public void resize(double d) {
		width = width * d;
		height = height * d;
	}
}
