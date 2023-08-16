package prob04;

public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;

	/* 코드 작성 */
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPerson++;
	}

	public Person(String name) {
		this(12, name);
	}

	public static String getPopulation() {
		return String.valueOf(numberOfPerson);
	}

	public void selfIntroduce() {
		System.out.println("내 이름은 " + name + "이며, 나이는 " + age + "입니다.");
	}

}
