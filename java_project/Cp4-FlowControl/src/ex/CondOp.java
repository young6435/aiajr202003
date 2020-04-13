package ex;

public class CondOp {

	public static void main(String[] args) {
		
		// 숫자 2개를 받는다.
		int num1 = 10;
		int num2 = 50;
		
		// 큰수, 차이 값을 저장 하는 변수.
		int big, diff;
		
		// 큰수 구하기.
		big = (num1 > num2) ? num1 : num2;		// 둘중에 큰수가 big에 저장된다.
		
		// 두 수의 차이 값을 구하기.
		diff = (num1 > num2) ? num1 - num2 : num2 - num1;
	
		System.out.println("큰값 : " + big);			
		System.out.println("차이값 : " + diff);			
	}

}
