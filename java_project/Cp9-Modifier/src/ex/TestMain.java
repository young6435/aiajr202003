package ex;

public class TestMain {

	public static void main(String[] args) {

		Singleton s = Singleton.getInstance();	
		s.print();
		
		Member member = new Member();
		
		//member.setName("멍청이");
		System.out.println(member.getName());
	}

}
