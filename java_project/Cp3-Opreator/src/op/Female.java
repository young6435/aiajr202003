package op;

public class Female {

	public static void main(String[] args) {
		
			//  성인 
			//	여성중 
			//	기혼자
			//	에게만 메시지를 출력합니다.
			int age = 20;
			char gender = 'w';
			boolean mCheck = true;
			
			boolean result = age >19 && gender == 'w' && mCheck;
			
			if(result) {		// result 가 true 라면.
				System.out.println("메시지를 보냅니다.");
			}
			
	}
}