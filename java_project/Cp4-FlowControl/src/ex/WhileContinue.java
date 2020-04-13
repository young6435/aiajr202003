package ex;

public class WhileContinue {

	public static void main(String[] args) {
		
		// 1 ~ 10까지의 숫자중 3의 배수를 제외하고 출력.
		// 1 ~ 10까지의 숫자중 3의 배수만 출력.
		int num;
		for(int i=1; i<=10; i++) {
			//System.out.println(i);
			if(!(i%3==0)) {
				continue;					// 밑에꺼 건너 띄고 다시 조건으로 간다.
			}
			System.out.println(i);
		}
	}

}
