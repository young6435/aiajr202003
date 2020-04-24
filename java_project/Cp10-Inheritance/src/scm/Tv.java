package scm;

public class Tv extends Product {		// 상위클래스에 생성자가 있으면 호출해줘야 한다.
	
	Tv(int price){
		super(price);
	}

	@Override							// 알트 + 쉬프트 + s
	public String toString() {
		return "Tv";
	}
	
	void display() {
		System.out.println("Tv를 시청합니다.");
	}
	
	
	
	
	
	
	

	
}
