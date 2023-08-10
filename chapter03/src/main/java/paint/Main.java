package paint;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10, 20);
//		point1.setX(2);
//		point1.setY(5);
		
		drawPoint(point1);
		point1.show(false);
	}

	public static void drawPoint(Point point) {
		point.show(true);

	}
}
