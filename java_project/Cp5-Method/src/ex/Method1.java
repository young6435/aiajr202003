package ex;

public class Method1 {			// Method는 class 블록 안에 있어야 된다.

	public static void main(String[] args) {
	
		// 메서드를 사용하기위해서는 인스턴스(객체)를 생성한 후 사용가능하다.
		// 메서드 코드를 메모리에 로드한다.

		// 인스턴스 생성(객체 생성).
		MyMath math = new MyMath();
		
		long result = math.add(10, 100);
		
		System.out.println(result);
		
		//System.out.println(math.add(100000000000l, 10000000000l));
	}
	
	int add() {			// Method의 선언부.
		
		return 10;
	}

}
