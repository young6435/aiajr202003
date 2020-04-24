package friend;

/*
  	 친구의 정보를 저장하가 위한 클래스.
  	 상속을 목적으로 기본 클래스 정의.
  	 기본 속성과 기능을 구성.
 */

public class Friend {
	
	String name;		// 친구의 이름.
	String phoneNum;	// 친구의 전화번호.
	String addr;		// 친구의 주소.			// 네이밍 할때 2번째 모음 앞에서 자른다..
	
	// 생성자.	// 이번꺼는 3개는 무조건 받는다.
	Friend(String name, String phoneNum, String addr){
		
		this.name = name;
		this.phoneNum = phoneNum;
		this.addr = addr;
	}

	void showBasicInfo() {
		System.out.println("이름 : "+this.name);
		System.out.println("전화번호 : "+this.phoneNum);
		System.out.println("주소 : "+this.addr);
		
	}

	// 상속의 목적으로 오버라이딩 할 메서드.		고등학교친구 , 대학교친구 껄로 출력할꺼다.
	void showData() {
		// 기본 데이터와 하위클래스의 데이터를 출력하도록 오버라이딩 한다.
	}

	

}
