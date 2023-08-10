package paint;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10, 10);
//		point1.setX(10);
//		point1.setY(10);

		draw(point1);
		point1.show(false);

		// 업캐스팅 : 형변환 명시 안해줘도 됨
		Point point2 = new ColorPoint();
		point2.setX(20);
		point2.setY(20);
		((ColorPoint) point2).setColor("red");

		// 다운캐스팅
//		ColorPoint p = (ColorPoint) point2;
//		p.setColor("red");

		draw(point2);

		Rect rect = new Rect();
		draw(rect);

		Triangle triangle = new Triangle();
		draw(triangle);

		Circle circle = new Circle();
		draw(circle);

		draw(new GraphicText("Hello World"));
	}

	public static void draw(Drawable drawable) {
		drawable.draw();
	}

//	public static void drawPoint(Point point) {
//		point.show(true);
//	}

//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show(true);
//	}

//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}

//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}

//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
}
