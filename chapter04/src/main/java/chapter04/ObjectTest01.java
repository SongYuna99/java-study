package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();
		
//		Class c = point.getClass();				// reflection
		System.out.println(point.getClass());
		System.out.println(point.hashCode());	// address x, reference x, address 기반의 해싱값 O
		System.out.println(point.toString());	// getClass() + "@" + hashCode()
		System.out.println(point);
	}

}
