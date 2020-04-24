package ex3;							

public class BusinessMan extends Man {

	String company;
	String position;
	
	// 조상클래스의 생성자가 있다면 자손클래스의 생성자에서 
	// 값을 받아 조상클래스의 생성자를 호출해서 초기화해준다.
	BusinessMan(String name, String company, String position ) {
		super(name);
		this.company = company;
		this.position = position;
		
	}
	
	void tellYourInfor() {
		//super.tellYourName();		// 조상으로 접근해서 들어간다.
		tellYourName();
		System.out.println("나의 직장 이름은 " +company+" 입니다.");		// this.company 가능.
		System.out.println("나의 직급은 "+position+" 입니다. ");		// this.position 가능.
	
	}
	
	
}
