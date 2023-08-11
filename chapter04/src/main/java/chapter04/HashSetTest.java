package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Rect> set = new HashSet<>();

		Rect r1 = new Rect(10, 50);
		Rect r2 = new Rect(10, 50);
		Rect r3 = new Rect(30, 30);

		set.add(r1);
		set.add(r2);
		set.add(r3);

		for (Rect rect : set) {
			System.out.println(rect.toString());
		}
	}

}
