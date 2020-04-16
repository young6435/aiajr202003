package ex;

public class Number {
	
	int num;
	
	// 생성자.
//	Number(){								// 매개변수 없는거.
//		System.out.println("생성자 호출");
//		num = 1000;
//	}
	
	Number(int n){							// 매개변수 있는거.
		System.out.println("생성자 호출");
		num = n;
	}
	
	
	
	
	public static void main(String[] args) {
		
		Number n1 = new Number(1000000);		// 인스턴스 생성.
		
		System.out.println(n1.num);
	}
	
	
}
