package ex1;

public class CaptionTv extends Tv{
	
	String text;
	
	void caption() {
		System.out.println("자막 출력 : "+text);
	}
	
	void display() {		// 오버라이딩.
		super.display();
		caption();
	}
	
}
