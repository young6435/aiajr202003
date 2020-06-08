package ver03;

import java.util.Scanner;

public class PhoneBookManager {
	
	PhoneInfor[] pBooks;
	
	Scanner sc;
	
	int cnt;
	
	public PhoneBookManager() {

		pBooks = new PhoneInfor[100];
		
		cnt=0;
		
		sc = new Scanner(System.in);
		
	}

	void addInfo(PhoneInfor info) {
		
		pBooks[cnt] = info;
		
		cnt ++;
		
		
	}
	
	void addInfo() {
		
		pBooks[cnt] = createInstance();
		
		cnt++;
		
	}
	
	PhoneInfor createInstance() {
		
		PhoneInfor info = null;
		
		System.out.println("친구의 정보를 저장하기 위한 데이터를 입력합니다.");
		
		System.out.println("이름을 입력해주세요.");
		String name = sc.nextLine();
		
		System.out.println("전화번호를 입력해주세요.");
		String phoneNumber = sc.nextLine();
		
		System.out.println("생일을 입력해주세요.");
		String birthday = sc.nextLine();
		
		if(birthday==null||birthday.trim().isEmpty()) {
			info = new PhoneInfor(name,phoneNumber);
		}else {
			info = new PhoneInfor(name,phoneNumber,birthday);
		}
		
		return info;
		
		
	}
	
	void showAllData() {	// 저장되어있는 사람들 다 보여주는거.
		
		for(int i=0; i<cnt; i++) {
			pBooks[i].showInfo();
			System.out.println("=======================");
		}
	}
	
	int searchIndex(String name) {
		
		int searchIndex = -1;
		
		for(int i=0; i<cnt; i++) {
			if(pBooks[i].checkName(name)) {
				searchIndex = i;
				
				break;
			}
		}
		
		return searchIndex;
	}
	
	void searchInfo() {
		
		System.out.println("찾으시는 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		int searchIndex = searchIndex(name);
		
		if(searchIndex<0) {
			System.out.println("찾으시는 이름이 없습니다.");
			
		}else {
			pBooks[searchIndex].showInfo();
		}
	}
	
	void deleteInfo() {
		
		System.out.println("삭제하실 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		int searchIndex = searchIndex(name);
		
		if(searchIndex<0) {
			System.out.println("찾으시는 이름이 없습니다.");
		}else {
			for(int i=searchIndex; i<cnt-1; i++) {
				pBooks[i]=pBooks[i+1];
			}
			
			cnt--;
			
			System.out.println("이름을 삭제했습니다.");
		}
	}
}
