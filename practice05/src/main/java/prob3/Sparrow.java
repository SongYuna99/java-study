package prob3;

public class Sparrow extends Bird {
	// constructor
	public Sparrow() {
		super();
	}

	// method
	@Override
	public void fly() {
		System.out.println("참새(" + super.getName() + ")는 날지 않습니다.");
	}

	@Override
	public void sing() {
		System.out.println("참새(" + super.getName() + ")가 소리내어 웁니다.");
	}
	
	@Override
	public String toString() {
		String str = new StringBuffer("참새의 이름은 ").append(super.getName()).append(" 입니다.").toString();
		return str;
	}
	
}
