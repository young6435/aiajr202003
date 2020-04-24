package friend;

public class HighFriend extends Friend {

	String work;		// 친구의 직업.
	
	public HighFriend(String name, String phoneNum, String addr, String work) {
		super(name, phoneNum, addr);		// 부모로 가서 생성자로 만든다.
		this.work = work;					
	
	}

	@Override
	void showData() {			// 부모꺼 오버라이딩.
		
		showBasicInfo();   		// 부모꺼 기본3개에다가 직업 더한다.
		System.out.println("직업 : " + work);
	}
	
	
}
