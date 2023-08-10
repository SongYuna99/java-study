package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;

		System.out.println("some code1");
		try {
			System.out.println("some code2");

			int result = (1 + 2 + 3) / b;

			System.out.println("some code3");
		} catch (Exception e) {
			// 예외 처리

			// 1. 로깅
			System.out.println("예외 발생 : " + e);

			// 2. 사과
			System.out.println("미안합니다...");

			// 3. 3. 정상 종료
//			System.exit(0);
			return;
		} finally {
			System.out.println("자원 정리 : file close, socket close, ... ");
		}

		System.out.println("some code4");
	}

}
