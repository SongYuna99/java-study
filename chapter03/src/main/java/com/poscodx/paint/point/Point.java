package com.poscodx.paint.point;

import com.poscodx.paint.i.Drawable;

public class Point implements Drawable {
	// 자식 메소드에서 사용하기 위해 protected
	protected int x;
	protected int y;

	// constructor
	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// method
	public void show(boolean visible) {
		if (visible) {
			show();
		} else {
			disappear();
		}
	}

	public void show() {
		System.out.println("점 [x = " + x + ", y = " + y + "]를 그렸습니다.");
	}

	public void disappear() {
		System.out.println("점 [x = " + x + ", y = " + y + "]를 지웠습니다.");
	}

	@Override
	public void draw() {
		show();
	}

	// getter&setter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
