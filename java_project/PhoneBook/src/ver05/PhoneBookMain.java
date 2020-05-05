package ver05;

import java.util.InputMismatchException;

import ver05.exception.BadNumberException;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		//PhoneBookManager manager = new PhoneBookManager(100);	
		// 싱글톤 썼으니까 이거안됨.
		
		
		// 싱글톤.
		PhoneBookManager manager = PhoneBookManager.getInstance();		
		
		while(true) {
			
			Menu.showMenu();
			
			int select = 0;
			
			try {
				select = manager.kb.nextInt();
				
				// 정상 범위는 1~6
				// MenuNum.INSERT ~ MenuNum.EXIT
				if(!(select >= MenuNum.INSERT && select <= MenuNum.EXIT)) {
					
					BadNumberException e = new BadNumberException("잘못된 메뉴입력");
					
					// 강재적인 예외 발생
					throw e;
					
				}
				
				
			} catch (InputMismatchException e) {
				System.out.println("잘못된 메뉴 입력입니다. \n확인하시고 다시 입력해주세요.");
				//manager.kb.nextLine();
				continue;
			} catch (BadNumberException e) {
				System.out.println("메뉴 범위를 벗어난 숫자 입력입니다.\n다시 확인 후 입력해주세요.");
				continue;				
			} catch (Exception e) {
				System.out.println("잘못된 메뉴 입력입니다. \n확인하시고 다시 입력해주세요.");
				//manager.kb.nextLine();
				continue;
			} finally {
				manager.kb.nextLine();
			}
			
			//manager.kb.nextLine();
			
			
			switch(select) {
			case MenuNum.INSERT:	// 1. 친구 정보 입력
				manager.createInfo();
				break;
			case MenuNum.SEARCH:	// 2. 친구 정보 검색
				manager.showInfo();
				break;
			case MenuNum.DELETE:	// 3. 친구 정보 삭제
				manager.deleteInfo();
				break;
			case MenuNum.EDIT:		// 4. 친구 정보 수정
				manager.editInfo();
				break;
			case MenuNum.PRINT_ALL:		// 5. 친구 정보 전체 보기
				manager.showAllInfo();
				break;
			case MenuNum.EXIT:		// 6. 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
			
			
		}	// while문 종료.

	}		// 메인 메서드 종료.

} 	// class 종료.


