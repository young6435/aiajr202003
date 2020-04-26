package ex;

public class Array04 {

	public static void main(String[] args) {

		// 정수 45개를 저장 할 수 있는 배열 생성.
		int[] ball = new int[45];
		
		// 각 배열의 요소에 1~45 숫자를 초기화.
		for(int i=0; i<ball.length; i++) {
			
			ball[i] = i+1;    // 숫자를 1부터 넣어야 되니까.
			
		}
//		
//		for(int i=0; i<ball.length; i++) {
//			System.out.println(ball[i]);
//		}
		
		System.out.println("=======[로또 번호 추첨]========");
		// 배열의 요소 값의 변경을 위한 임시 변수.
		int temp;
		
		// 랜덤한 index 값 : 1 ~ 44
		int j=0;						// index로 사용할꺼다.
		
		for(int i=0; i<60000; i++) {
			
			j =(int)(Math.random()*44)+1;
			
			temp = ball[0];				// j에서 나온 숫자가 index숫자인데, 그 index가 갖고있는 숫자랑
			ball[0] = ball[j];			// 첫번째 index랑 바꾼다.
			ball[j] = temp;
		}
		
		// 숫자6개 출력.
		for(int i=0; i<6; i++) {
			System.out.print(ball[i]+", ");
		}
		
	}

}
