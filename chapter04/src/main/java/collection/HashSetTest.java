package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<String>();

		s.add("둘리");
		s.add("마이콜");
		s.add("또치");

		// 자료구조는 무조건 동질성
		String s1 = "또치";
		s.add(s1);

		String s2 = new String("도우너");
		String s3 = new String("도우너");
		s.add(s2);
		s.add(s3);

		System.out.println(s.size());
		System.out.println(s.contains(s2));

		// 순회
		for (String str : s) {
			System.out.println(str);
		}
	}

}
