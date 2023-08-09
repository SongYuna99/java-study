package prob3;

public class Prob3 {

	public static void main(String[] args) {
		CurrencyConverter.setRate(1121);

		System.out.println("실행 결과 : ");
		System.out.println("백만원은 " + CurrencyConverter.toDollar(1000000) + "달러 입니다.");
		System.out.println("백달러는 " + CurrencyConverter.toKRW(100) + "원 입니다.");
	}

}
