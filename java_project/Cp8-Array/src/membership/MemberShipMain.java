package membership;		//1차원배열.

public class MemberShipMain {

	public static void main(String[] args) {
		
		// 회원 정보 5개를 저장 할 수 있는 배열을 생성.
		// Member 타입의 인스턴스의 참조값을 저장하는 메모리 공간.
		// Member m1, m2, m3 ,m4, m5
		Member[] members = new Member[5];
		
		// Member 타입의 인스턴스 주소 저장.
		members[0] = new Member("soccerGod","메시","messi@gmail.com"); 	
		members[1] = new Member("passmaster","사비","xavi@gmail.com"); 	
		members[2] = new Member("ini","이니에스타","iniesta@gmail.com"); 
		members[3] = new Member("rooney","루니","rooney@gmail.com"); 
		members[4] = new Member("Kim","김병지","Kim@gmail.com");
		
		
//		members[0].showInfo();
//		members[1].showInfo();
//		members[2].showInfo();
//		members[3].showInfo();
//		members[4].showInfo();
//		members[5].showInfo();
		
		for(int i=0; i<members.length; i++) {
			System.out.println(members[i]);
			System.out.println("===========================");
		}
		
		for(int i=0; i<members.length; i++) {
			members[i].showInfo();
			System.out.println("===========================");
		}
		
		
		
		
		
		
//		Member member = new Member("soccerGod","메시","messi@gmail.com");
//	
//		member.showInfo();
//		System.out.println("===============");
//		System.out.println(member);				// member.toString() 호출.
		
		// toString 오버라이딩 안되어있으면 @같은거 나온다.
		// toString 디버깅 할때 쓴다.
	}
}
