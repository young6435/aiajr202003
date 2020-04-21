package ex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportTest {

	public static void main(String[] args) {
		
		// java.util.Date
		// 날짜와 시간 정보를 하나로 표현.
		Date today = new Date();
		
		System.out.println(today);		// today.toString()
		
		// 시간정보를 문자열 형식으로 반환.
		SimpleDateFormat dateFromat = new SimpleDateFormat("yyyy.MM.dd. HH:mm");
		
		System.out.println(dateFromat.format(today));
	}

}
