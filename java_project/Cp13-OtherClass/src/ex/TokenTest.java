package ex;

import java.util.StringTokenizer;

public class TokenTest {

	public static void main(String[] args) {
		
		String phoneNumber = "Tel 82-02-997-2059 test";
		
		StringTokenizer st1 = new StringTokenizer(phoneNumber);
		
		while(st1.hasMoreTokens()) {
			
			System.out.println(st1.nextToken());			// 공백으로 구분한다.
		}
	
		System.out.println("-----------------------");
		
		System.out.println(phoneNumber);		// 원본.
		
		StringTokenizer st2 = new StringTokenizer(phoneNumber, " -", true);	// 공백하나, 다시하나.
																			// true 빼고 해봐라.
		while(st2.hasMoreTokens()) {
			
			System.out.println(st2.nextToken());
		}
	
	}

}
