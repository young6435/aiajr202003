package ex;

public class LoopTest {

	public static void main(String[] args) {
		
		for(int i=1; i<6; i++) {				// for 문
			
			System.out.println(i);
			
		}
		
		System.out.println("=========================");
		
		int i = 1;
		
		while(i<6) {							// while 문
			
			System.out.println(i);
			i++;							// 졸라 중요!!!
		}
		
		System.out.println("=========================");
		
		
		i = 1;
		
		do {									// do while 문
			System.out.println(i);
			i++;
		} while(i<6);
	}	
}
