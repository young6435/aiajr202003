package ver02;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();	// PhoneBookManager 매니저 타입에
															// scanner 만들어 놨다.
		PhoneInfor info = null;
		
		while(true) {
		
			info = manager.creatInstance();	//PhoneInfor 타입 객체를 만들어서 info 에 넣는다.
			info.showInfo();
		
		}
	}
}
