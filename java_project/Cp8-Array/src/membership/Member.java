package membership;		//1차원배열.


// 회원 정보를 저장하기 위한 클래스 생성.
public class Member {
	
	String memberId;
	String memberName;
	String memberEmail;
	
	// 생성자
	Member(String memberId, String memberName, String memberEmail){
		this.memberId=memberId;
		this.memberName=memberName;
		this.memberEmail=memberEmail;
		
	}
	
	void showInfo() {		// 함수이름 지을때 직관적으로 하면 좋다.
		System.out.println("ID : "+this.memberId); 			//this 빠저도 가능하다.
		System.out.println("이름 : "+this.memberName);
		System.out.println("E-mail : "+this.memberEmail);
	}

	
	// toString 오버라이딩 안되어있으면 @같은거 나온다.
	// toString 디버깅 할때 쓴다.
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", memberEmail=" + memberEmail + "]";
	}
	
	
	
	
	
}
