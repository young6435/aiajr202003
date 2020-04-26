package friend;

import java.util.Scanner;

public class FriendInfoHandler {
	
	// Friend 타입의 정보를 저장할 배열을 가진다.
	// 친구정보를 저장하는 기능.
	// 친구정보의 기본 정보 출력 기능.
	// 친구정보 상세 정보 출력 기능.
	
	
	private Friend[] myFriends;		// Friend 타입의 배열 선언.
	private int numOfFriend;		// 저장된 친구의 정보 개수.	 (배열에서 친구가 몇명 저장됐는지).
	
	Scanner kb; 
	
	// 초기화 : 저장공간(사이즈) 크기를 받아서 배열 생성.	// 생성자.
	FriendInfoHandler(int num){				// main에서 10을 줄꺼다.
		myFriends = new Friend[num];		// 배열크기 10으로 만들어진다.
		numOfFriend = 0;					// 처음에는 친구 저장안됐으니까 0으로한다.
		kb = new Scanner(System.in);
	}
	
	// 친구정보를 저장하는 기능.
	// 1. 배열에 저장하는 기능.
	// 2. 사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성.
	
	// 1. 배열에 저장하는 기능.
	void addFriendInfo(Friend f) {			// f대신에 다른거 써도 된다. 밑에서 friend객체 만든거 들어온다.
		// 배열에 저장
		myFriends[numOfFriend] = f;  		// 객체만든게 배열의 0번지부터 들어간다. 위에서 0으로 저장해서.
		numOfFriend++;						// 이거 안하면 0번지에만 계속 저장된다.
		
	}
	
	// 2. 사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성.
	// HighFriend / UnivFriend 2가지 타입이 있다.
	// 타입별로 필요한 데이터가 있다.
	void addFriend(int choice) {		// ui에서 번호 누른거.
		
			
		// Scanner kb = new Scanner(System.in); 객체가 계속 생성된다. 그래서 위에 생성자에다가 넣었다.
		// 기본정보 받기.
		System.out.println("이름을 입력해주세요.");
		String name = kb.nextLine();
		System.out.println("전화번호를 입력해주세요.");
		String phoneNum = kb.nextLine();
		System.out.println("주소를 입력해주세요");
		String addr = kb.nextLine();
		
		Friend friend = null; 
		
		if(choice == 1) {
			// 1일때 정보 받기.
			System.out.println("직업을 입력해주세요.");
			String work = kb.nextLine();
			
			// HighFriend 인스턴스 생성.
			friend = new HighFriend(name, phoneNum, addr, work);	//배열에 객체생성해서 넣을꺼다.
		
		} else {
			// 2 일때 정보 받기.
			System.out.println("전공을 입력해주세요.");
			String major = kb.nextLine();
			System.out.println("학년을 숫자로 입력해주세요.");
			String grade = kb.nextLine();
			//Integer.parseInt(grade);		// 문자열을 int로 바꿔준다.
			
			// UnivFriend 인스턴스 생성.
			friend = new UnivFriend(name, phoneNum, addr, major, Integer.parseInt(grade));
																// 배열에 객체생성해서 넣을꺼다.
		}
		
		// addFriendInfo 호출.
		addFriendInfo(friend);		// 여기에다가 넣어야 1이든 2이든 저장이 된다.
									// 위에서 객체 생성된게 friend 이다.
		
	}
	
	
	// 친구정보의 기본 정보 출력 기능.
	void showAllSimpleData() {		// switch 에서 3번 눌렀을때.
		
		System.out.println("친구의 기본정보를 출력합니다.================");
		
		for(int i=0; i<numOfFriend; i++) {
			myFriends[i].showBasicInfo();
			System.out.println("---------------------");
			
		}
	}
	
	
	
	
	// 친구정보 상세 정보 출력 기능.
	void showAllData() {			// switch 에서 4번 눌렀을때.
		
		System.out.println("친구의 모든 정보를 출력합니다.================");
		
		for(int i=0; i<numOfFriend; i++) {
			myFriends[i].showData();
			System.out.println("---------------------");
		}
	}
	
	
}
