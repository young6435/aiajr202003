package ver04;

// PhoneInfo 클래스를 상속해서 새로운 클래스를 정의.
public class PhoneUnivInfo extends PhoneInfo{

	String major;		// 친구의 전공.
	String grade;		// 친구의 학년.
	
	PhoneUnivInfo(
			String name, 
			String phoneNumber, 
			String addr, 
			String email, 
			String major, 
			String grade) {
		super(name, phoneNumber, addr, email);	// 부모꺼에서 4개 만들고, 2개는 여기서만들고.
		this.major = major;
		this.grade = grade;
		
	}

	@Override
	void showAllInfo() {
		super.showAllInfo();
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + grade);
	}
	
	
	

}
