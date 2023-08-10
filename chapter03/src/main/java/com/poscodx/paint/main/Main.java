package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rect;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
import com.poscodx.paint.text.GraphicText;

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

		// instanceof 연산제 Test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);

		// 오류 : 연산자 우층항이 클래스인 경우, 레퍼런스 하고 있는 class 타입의
		// hierachy(계층) 상의 하위와 상위만 instanceof 연산자를 사용할 수 있다.
//		System.out.println(circle instanceof Rect);

		// 연산자 우측항이 인터페이스인 경우, hierachy 상관없이 사용할 수 있다.
		// 어차피 인터페이스는 hierachy가 없음
		System.out.println(circle instanceof Drawable);
		System.out.println(circle instanceof Runnable);
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
