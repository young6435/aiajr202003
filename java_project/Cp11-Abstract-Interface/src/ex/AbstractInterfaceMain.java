package ex;

public class AbstractInterfaceMain {

	public static void main(String[] args) {
		
		PersnalNumberStorageImpl storage = new PersnalNumberStorageImpl(100); 
		
		storage.addPersnalInfo("202020-1111111", "손흥민");
		storage.addPersnalInfo("202020-1000000", "박지성");
		
		System.out.println(storage.searchName("202020-1111111"));
		System.out.println(storage.searchName("202020-0000000"));		
		
			
			
	}

}
