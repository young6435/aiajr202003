package op;

public class ArithOp {

	public static void main(String[] args) {
		// 1. 정수 타입의 숫자 두개를 받는다. => 변수 선언.
		int num1;
		int num2;
		
		num1 = 10;
		num2 = 3;
		
		// 2. 덧셈 연산 => 결과 출력.
		int res = num1 + num2;
		System.out.println("num1 + num2 = " + res);
		
		// 3. 빼기 연산 => 결과 출력.
		res = num1 - num2;
		System.out.println("num1 - num2 = " + res);
		
		// 4. 곱하기 연산 => 결과 출력.
		res = num1 * num2;
		System.out.println("num1 * num2 = " + res);
		
		// 5. 나누기 연산 => 결과 출력.			//나누기 연산은 몫만 출력된다.
		res = num1 / num2;												
		System.out.println("num1 / num2 = " + res);
		
		// 6. 나머지 연산 => 결과 출력.
		res = num1 % num2;
		System.out.println("num1 % num2 = " + res);
	}

}
