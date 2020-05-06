package ver03;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Tree {

	public static void main(String[] args) {
		//오늘 날짜 저장
		//public void setDate() {
			// 오늘날짜
			SimpleDateFormat day = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
			Date date = new Date();
			String today = day.format(date);
		
	
			System.out.println(date);
			System.out.println(today);
	}

	}


