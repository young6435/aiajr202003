package ex;

public class SwitchCaseBreak {

	public static void main(String[] args) {
		
		int menuNum = 1;		//바꿔바라.
		
		switch(menuNum) {
		
		case 1:
			System.out.println("1. simple JAVA");
			break;
		case 2:
			System.out.println("2. funny JAVA");
			break;
		case 3:
			System.out.println("3. fantastic JAVA");
			break;
		default:
			System.out.println("d. The best Programing Language");
			break;				// default 에서는 break 생략가능.
		}
		
		System.out.println("Do you like coffee?");		// switch문 끝나고 출력되는것.
	}

}
