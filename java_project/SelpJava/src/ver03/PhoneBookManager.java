package ver03;

import java.util.Scanner;

public class PhoneBookManager {
	
	final PhoneInfor[] pBook;
	
	int cnt;
	
	Scanner sc;

	private PhoneInfor[] pBooks;
	
	public PhoneBookManager() {
		
		pBooks = new PhoneInfor[100];
		
		cnt = 0;
		
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
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
	
	
