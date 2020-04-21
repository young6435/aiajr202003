package ex;

public class Singleton {
	
	// 1. 생성자의 접근제어지시자 : private => 인스턴스 생성 불가. // 다른객체 못만들게 하려고.
	private Singleton() {}
	
	// 2. 공유할 객체를 생성.     //static은 외부에서 참조가 가능해서 private붙인다.
	private static Singleton s = new Singleton();	
	
	// 3. 참조값을 반환하는 메서드를 생성.
	public static Singleton getInstance() {
		return s;
	}
	
	public void print() {
		System.out.println("Singleton !!!");
	}
	
}
