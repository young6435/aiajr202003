package ex1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Newnew {

	public static void main(String[] args) {
		
		
		//Date now = new Date();
		
		
		Calendar cal = Calendar.getInstance();
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/ MM/ dd");
		
		String datestr = sdf.format(cal.getTime());
		
		System.out.println(datestr);
	
		cal.add(Calendar.DATE,7);
		
		String returnd = sdf.format(cal.getTime());
		System.out.println(returnd);
		
		
	}
}
