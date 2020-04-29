package ver03;

/*
	Version 0.1 전화번호 관리 프로그램. 
	PhoneInfor 라는 이름의 클래스를 정의해 보자. 
	클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며, 
	저장된 데이터의 적절한 출력이 가능하도록 메소드 정의
	• 이름           name            String
	• 전화번호       phoneNumber     String
	• 생년월일       birthday        String 
	단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.
*/
public class PhoneInfor {

	// private : 변수의 직접 참조를 막는다, 정보은닉
	private String name; // 친구의 이름
	private String phoneNumber; // 친구의 전화 번호
	private String birthday; // 친구의 생일

	// 초기화를 위한 생성자
	PhoneInfor(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	PhoneInfor(String name, String phoneNumber) {
		// this.name = name;
		// this.phoneNumber = phoneNumber;
		// this(name, phoneNumber, null);
		this(name, phoneNumber, "입력값이 없습니다.");
	}

	void showInfo() {
		System.out.println("이름 : " + this.name);
		System.out.println("전화번호 : " + this.phoneNumber);
		System.out.println("생일 : " + this.birthday);

//		if(this.birthday == null) {
//			System.out.println("생일 : 입력값이 없습니다.");
//		} else {
//			System.out.println("생일 : " + this.birthday);
//		}

	}
	
	
	// name 속성값과 전달받은 문자열을 비교해서 결과 반환
	boolean checkName(String name) {
		return this.name.equals(name);		// 매개변수로 받은거(찾을 이름)랑 
			// 앞 name = 배열안에 있는것	.		// 저장되어있는 이름하고 똑같은지를 반환한다.
	}		// 뒤 name = 찾을 이름.
	
}