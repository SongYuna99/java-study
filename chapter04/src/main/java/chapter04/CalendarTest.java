package chapter04;

import java.util.Calendar;

// final
// 클래스 : 상속 금지 
// 메소드 : 오버라이드 금지
public class CalendarTest {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		printDate(calendar);

		calendar.set(Calendar.YEAR, 2023);
		calendar.set(Calendar.MONTH, 11); // 12월(month-1)
		calendar.set(Calendar.DATE, 25);
		printDate(calendar);

		calendar.set(1999, 6, 28);
		calendar.add(Calendar.DATE, 10000);
		printDate(calendar);

	}

	private static void printDate(Calendar calendar) {
		final int i = 0;
//		i = 10;

//		final Book b = new Book();
//		b.setTitle("");	// 가능
//		b = b2 // 불가능

		final String[] DAYS = { "일", "월", "화", "수", "목", "금", "토" };

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH); // 0~11, +1
		int date = calendar.get(Calendar.DATE);
		int day = calendar.get(Calendar.DAY_OF_WEEK); // 1(일)~7(토)
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		System.out.println((year) + "/" + (month + 1) + "/" + (date) + " " + (DAYS[day - 1]) + "요일 " + hour + ":"
				+ minute + ":" + second);
		;
	}

}
