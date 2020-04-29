package ex4;							// Speaker, OverridingTest, BaseEnSpeaker 한세트.

public class OverridingTest {

	public static void main(String[] args) {
		
		// 다형성 : 상위클래스 타입의 참조변수에 하위클래스의 인스턴스를 참조.
		Speaker sp = new BaseEnSpeaker();
		// 참조변수 sp는 BaseEnSpeaker 인스턴스의 멤버중 Speaker가 가진던 멤버만 사용한다.
		
		sp.showCurrnetState();
		//sp.setBaseRate(100);	//에러난다. setBaseRate 메서드가 BaseEnSpeaker 클래스안에 있는거다. 			
								//Speaker 클래스안에 있는것만 쓸수있다.(showCurrnetState, setVolume). 
		
		System.out.println("----------------------------");
		
		BaseEnSpeaker bSpeaker = new BaseEnSpeaker();
		bSpeaker.setVolume(10);			// 상속했으니까 가능.
		bSpeaker.setBaseRate(20);		// BaseEnSpeaker 가 setBaseRate 가지고 있음.
		
		bSpeaker.showCurrnetState();
		
		System.out.println(bSpeaker);		// toString() 호출하는거랑 같다.
	}

}

