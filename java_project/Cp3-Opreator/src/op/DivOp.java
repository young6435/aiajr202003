package op;

public class DivOp {

	public static void main(String[] args) {
		
		int num1 = 7;
		int num2 = 3;
		
		// 정수의 나누기 연산.		// 나누기 연산은 몫만 출력된다.
		System.out.println("num1 / num2 = " + num1 / num2);
		
		// 실수의 연산.
		System.out.println("num1 / num2 = " + 7f / 3);    // 3은 int 형인데 float으로 자동 형변환 된다.
		System.out.println("num1 / num2 = " + (float)num1 / num2);  //num1을 형변환시키면 num2도 형변환 된다.
		
	}
}
