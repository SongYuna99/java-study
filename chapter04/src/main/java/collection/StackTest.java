package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();

		s.push("둘리");
		s.push("마이콜");
		s.push("도우너");

		while (!s.empty()) {
			String str = s.pop();
			System.out.println(str);
		}
		System.out.println("--------------------");

		// 비어있는 경우, 예외 발생
//		s.pop();

		s.push("둘리");
		s.push("마이콜");
		s.push("도우너");

		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
	}

}
