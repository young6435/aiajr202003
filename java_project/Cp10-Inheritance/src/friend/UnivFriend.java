package friend;

public class UnivFriend extends Friend {

	String major;		// 친구의 전공.
	int grade;			// 친구의 학년.
	
	
	public UnivFriend(String name, String phoneNum, String addr, String major, int grade) {
		super(name, phoneNum, addr);		// 부모꺼 3개 생성자.
		this.major = major;
		this.grade = grade;
	
	}


	@Override
	void showData() {			// 부모꺼 오버라이딩.
		
		showBasicInfo();		// 부모꺼 3개에다가 전공,학년 더한다.
		System.out.println("전공 : " + major);
		System.out.println("학년 : " + grade);
	}
	
	

}
