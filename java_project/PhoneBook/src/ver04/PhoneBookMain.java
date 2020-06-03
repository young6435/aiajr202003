package ver04;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager(100);		// 100개 짜리 배열생성.
		
		while(true) {
			
			Menu.showMenu();
			
			int select = manager.kb.nextInt();		// 내가누른 숫자가 select에 저장된다.
			manager.kb.nextLine();					// PhoneBookManager 안에 scanner 있다.
			
			if(!(select>0 && select<7)) {	// 1~6번.
				System.out.println("정상적인 메뉴 선택이 아닙니다.\n메뉴를 다시 선택해 주세요.");
			}
			switch(select) {
			case 1:
				manager.createInfo();
				break;
			case 2:
				manager.showInfo();
				break;
			case 3:
				manager.deleteInfo();
				break;
			case 4:
				manager.editInfo();
				break;
			case 5:
				manager.showAllInfo();
				break;
			case 6: 
				System.out.println("프로그램을 종료 합니다.");
				return;
			}
			
			
			
		}
		
	}

}
