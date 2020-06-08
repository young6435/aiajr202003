package ver03;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		// 저장되어 있는 메서드 쓸라고 객체생성.
		PhoneBookManager manager = new PhoneBookManager();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			Menu.showMenu();
			
			int select = sc.nextInt();
			
			sc.nextLine();
			
			switch(select) {
			
			case 1:
				manager.addInfo();
				break;
			case 2:
				manager.searchInfo();
				break;
			case 3:
				manager.deleteInfo();
				break;
			case 4:
				manager.showAllData();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
		}

	}

}
