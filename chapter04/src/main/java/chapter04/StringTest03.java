package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
//		String s1 = "Hello" + "World " + "Java" + 17;
		String s1 = new StringBuffer("Hello").append("World ").append("Java").append(17).toString();

		System.out.println(s1);

		String s2 = "";
		for (int i = 0; i < 100000; i++) {
//			s2 = s2 + i;
//			s2 = new StringBuffer(s2).append(i).toString();
		}
//		System.out.println(s2);

		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < 100000; i++) {
			sb.append(i);
		}
		String s3 = sb.toString();
//		System.out.println(s3);

		// String method들...
		String s4 = "aBcABCabcABc";
		System.out.println(s4.length());
		System.out.println(s4.toUpperCase());
		System.out.println(s4.toLowerCase());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("ABC"));
		System.out.println(s4.indexOf("abc", 7));
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3, 5));

		String s5 = "          ab     cd e        ";
		String s6 = "efg,hij,klm,qrs";
		String s7 = s5.concat(s6);

		System.out.println(s7);
		System.out.println("===" + s5.trim() + "===");
		System.out.println("===" + s5.replaceAll(" ", "") + "===");
		
		String[] tokens = s6.split(",");
		for(String s : tokens) {
			System.out.println(s);
		}
		String[] tokens2 = s6.split(" ");
		for(String s : tokens2) {
			System.out.println(s);
		}
		
	}

}
