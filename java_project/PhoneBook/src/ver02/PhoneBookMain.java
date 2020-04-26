package ver02;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();	// PhoneBookManager 매니저 타입에
															// scanner 만들어 놨다.
		PhoneInfor info = null;
		
		while(true) {
		
			info = manager.creatInstance();
			info.showInfo();
		
		}
	}
}
