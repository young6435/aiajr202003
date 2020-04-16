package ex;

public class MemberCall {
	
	// 인스턴스 변수.
	int iv = 10;
	
	// 클래스 변수(static 변수).
	static int cv = 100;
	
	int iv2 = cv;
	//static int cv2 = iv;
	static int cv2 = new MemberCall().iv;			// memberCall을 만들면 주소가 생기니까.
	
	
	static void staticMethod() {		// 인스턴스 메서드.
		// static 멤버 출력.
		System.out.println(cv);
		
		// 인스턴스 멤버 출력.
		//System.out.println(iv);		// 이렇게 쓰면 오류난다.
		
		MemberCall mc = new MemberCall();
		System.out.println(mc.iv);
	}
	
	void instatnceMethod() {
		// static 멤버 출력.
		System.out.println(cv);
				
		// 인스턴스 멤버 출력.
		System.out.println(iv);
		
	}
	
}
