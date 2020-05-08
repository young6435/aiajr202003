package ver03;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();		
				
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			Menu.showMenu();

			
			int selectNum = sc.nextInt();
			
			sc.nextLine();					// 오류 방지용. 숫자 잘못 들어가는거.
			
			switch(selectNum) {
			case 1:		// 1. 친구 정보 입력					
				// 사용자의 입력 데이터를 인스턴스 생성
				//PhoneInfor info = manager.createInstance();
				// 정보를 배열에 저장
				//manager.addInfo(info);
				manager.addInfo();
				break;
			case 2:		// 2. 친구 정보 검색
				// 이름으로 검색
				manager.searchInfo();
				break;
			case 3:		// 3. 친구 정보 삭제
				// 이름으로 검색후 삭제
				manager.deleteInfo();
				break;
			case 4:		// 4. 친구 정보 전체 보기
				// 전체 리스트 출력
				manager.showAllData();
				break;
			case 5:		// 5. 프로그램 종료
				//return;
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				
				break;
			}
			
			
		}

	}

}