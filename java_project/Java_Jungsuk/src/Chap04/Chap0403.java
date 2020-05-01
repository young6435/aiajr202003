package Chap04;

// 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산하시오.

public class Chap0403 {

	public static void main(String[] args) {
		
		int sum = 0;		// i가 더해지는 변수.
		
		int tsum = 0;		// 총합
		
		for(int i=1; i<=10; i++) {
			
			sum += i;
			
			tsum += sum;
			
			
			
		}
		
		System.out.println(tsum);
	}

}
