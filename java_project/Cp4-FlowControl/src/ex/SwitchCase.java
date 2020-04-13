package ex;

public class SwitchCase {

	public static void main(String[] args) {
		
		int menuNum = 6;		//바꿔바라.
		
		switch(menuNum) {
		
		case 1:
			System.out.println("1. simple JAVA");
		case 2:
			System.out.println("2. funny JAVA");
		case 3:
			System.out.println("3. fantastic JAVA");
		default:
			System.out.println("d. The best Programing Language");
		}
		
		System.out.println("Do you like coffee?");		// switch문 끝나고 출력되는것.
	}

}
