package ex1;

public class SmartTv extends Tv {
	
	String ch = "YOUTUBE";
	
	void display() {								// 오버라이딩.
		super.display();
		System.out.println(ch + "방송을 시청합니다.");
	}
}
