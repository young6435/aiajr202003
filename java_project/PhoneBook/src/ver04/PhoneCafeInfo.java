package ver04;

public class PhoneCafeInfo extends PhoneInfo{

	String cafeName;		// 동호회 이름.
	String nickName;		// 닉네임.
	
	PhoneCafeInfo(
			String name, 
			String phoneNumber, 
			String addr, 
			String email,
			String cafeName,
			String nickName) {
		super(name, phoneNumber, addr, email);		// 부모꺼에서 4개 만들고,
		this.cafeName = cafeName;					// 여기서 2개만들고.
		this.nickName = nickName;
	}

	@Override
	void showAllInfo() {
		super.showBasicInfo();
		System.out.println("동호회 : "+ cafeName);
		System.out.println("닉네임 : "+ nickName);
		
	}
	
	

}
