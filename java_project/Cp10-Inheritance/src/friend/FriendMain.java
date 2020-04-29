package friend;

public class FriendMain {

	public static void main(String[] args) {
		
		FriendInfoHandler handler = new FriendInfoHandler(10);	// handler에 scanner 있다.
															
		
		while(true) {
			System.out.println("=====메뉴를 선택해 주세요=====");
			System.out.println("1. 고교 친구 저장");
			System.out.println("2. 대학 친구 저장");
			System.out.println("3. 기본 정보 출력");
			System.out.println("4. 전체 정보 출력");
			System.out.println("5. 종료");
			System.out.println("============================");
			
			
			int choice = handler.kb.nextInt();		// 이미 scanner 가지고 있다.
			
			handler.kb.nextLine();			//앞의 버퍼를 클리어 해준다.
			
			switch(choice) {
			case 1: case 2:						// case 1,2 일때 호출하는게 같다.
				handler.addFriend(choice);
				break;
			case 3:
				handler.showAllSimpleData();
				break;
			case 4:
				handler.showAllData();
				break;
			case 5:
				System.out.println("프로그램을 종료 합니다.");
				return;		// main 메서드 종료. 프로그램 종료.
				
			}
			
		}
	
	
	
	}

}
