package ver04;

// 상속을 위한 기본 클래스 구성.
public class PhoneInfo {

	String name;				// 친구의 이름.	
	String phoneNumber;			// 친구의 전화번호.
	String addr;				// 친구의 주소.
	String email;				// 친구의 email.
	
	// 인스턴스 변수 초기화.
	PhoneInfo(String name, String phoneNumber, String addr, String email){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.addr = addr;
		this.email = email;
	}
	
	// 기본 정보 출력 메서드.
	void showBasicInfo() {
		System.out.println("이름 : "+ name);
		System.out.println("전화번호 : "+ phoneNumber);
		System.out.println("주소 : "+ addr);
		System.out.println("이메일 : "+ email);
	}
	
	
	
	// 전체 정보 출력 메서드.
	void showAllInfo() {
		// 상속 후 오버라이딩을 통해 재구성할꺼다.
		showBasicInfo();	// 기본적으로 베이직 보여주고, 오버라이딩해서 추가할꺼다.
	}




}
