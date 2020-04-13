package ex;

public class DoWhileBasic {

	public static void main(String[] args) {
		
		int num = 6;  		// 반복의 조건을 체크하는 변수.
		
		do {				// 최소 한번은 실행.
			
			System.out.println("I like JAVA " + num);
			num++;
		} while(num<6);
	}

}