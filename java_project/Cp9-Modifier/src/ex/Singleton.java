package ex;

public class Singleton {
	// Singleton 패턴을 쓸때는 변수가 없이 메서드만 있는 경우, 
	// 인스턴스 여러개 만들어도 모두 같은내용이기 떄문에 여러개 만들필요가 없다. 
	// 따라서 여러개 인스턴스 만들필요없이 하나만 만들어서 사용하도록 Singleton클래스에 하나만 인스턴스 한다. 
	// 하나만 만든 인스턴스를 다른데서도 사용해야하므로 참조변수를 반환하는 메서드를 만든다. 
	// 왜 순서가 이렇게 되는지, 접근제어지시자 흐름이 이렇게 되는지 기억하기! (디자인)

	// 1. 생성자의 접근제어지시자 : private 해준다 ㅡ> 인스턴스 생성불가 목적
	// 무분별하게 인스턴스 생성하지 못하도록 일단 막는다. 
	private Singleton() {}
	
	// 2. 공유할 객체를 생성
    // Singleton s=new Singleton();  
	// ㅡ> s는 인스턴스 변수, 근데 생성자를 private해두었으므로 만들 수 있도록 static을 해둔다. 
	// ㅡ> 같은 클래스이니까 생성자가 가능하여 인스턴스 생성됨. 
	// ㅡ> 근데 보호하기 위해 private을 붙여준다. 
	private static Singleton s=new Singleton();  
	// ㅡ> static, private해둠. 근데 이러면 내부에서만 이 객체를 쓸 수 있으므로
	
	// 3. 참조값을 반환하는 메서드를 생성
	// 전체프로그램에서(외부) 사용가능하도록 static을 붙여준다.
	// ㅡ> s 참조변수를 반환하므로 이렇게 하나만 만들어진 인스턴스의 메서드를 활용하여 인스턴스사용가능.
	static Singleton getInstance() {
		return s;
	}	
	public void print() {
		System.out.println("Singleton !!");
	}
}