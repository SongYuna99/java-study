package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();

		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("도우너");

		// 순회1
		for (int i = 0; i < v.size(); i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		System.out.println("----------------------\n");

		// 삭제
		v.removeElementAt(2);

		// 순회2 : 한번만 할 수 있음
		Enumeration<String> e = v.elements();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		}
		System.out.println("----------------------\n");
		
		
	}

}
