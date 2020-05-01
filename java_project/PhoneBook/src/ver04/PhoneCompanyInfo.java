package ver04;

public class PhoneCompanyInfo extends PhoneInfo {

	String company;		// 회사이름.
	String dept;		// 부서이름.
	String job;			// 직급.
	
	PhoneCompanyInfo(
			String name, 
			String phoneNumber, 
			String addr, 
			String email, 
			String company, 
			String dept, 
			String job) {
		super(name, phoneNumber, addr, email);		// 부모꺼에서 4개 만들고,
		this.company = company;						// 여기서 3개만들고.
		this.dept = dept;
		this.job = job;
	
	}

	@Override
	void showAllInfo() {
		super.showBasicInfo();
		System.out.println("회사 : "+ company);
		System.out.println("부서 : "+ dept);
		System.out.println("직급 : "+ job);
	}
	
	
}
