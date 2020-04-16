package ex;

public class AccessWayMain {

	public static void main(String[] args) {
		
		
		System.out.println(AccessWay.num);		// static 변수 쓸때는, 클래스이름.변수명 으로 쓴다.
		AccessWay.num++;						
		System.out.println(AccessWay.num);	
	
		AccessWay ac = new AccessWay();
		
		System.out.println(ac.num2);
		System.out.println(ac.num);			// static 변수를 객체 만들어서 쓸수도 있다.
		
	}

}
