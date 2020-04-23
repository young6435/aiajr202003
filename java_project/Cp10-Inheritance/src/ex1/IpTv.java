package ex1;

public class IpTv extends Tv{

	String ipTvName = "daumipTv";
	
	void display() {								// 오버라이딩.
		super.display();
		System.out.println(ipTvName+"Ip TV를 봅니다.");
	}
	
	
	
}
