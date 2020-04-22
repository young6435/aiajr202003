package ver01;

public class PhonebookMain {

	public static void main(String[] args) {
		
		PhoneInfor info = new PhoneInfor("손흥민", "010-9999-8888", "2000.11.11");
		info.showInfo();
		
		info = new PhoneInfor("박지성", "010-4545-2332");
		info.showInfo();
	}

}
