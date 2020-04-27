package ex;


// class 앞에 abstract 키워드가 있는경우 이 클래스는 추상클래스다.
// 추상클래스는 미완성된 클래스다.
// 클래스의 멤버중 추상 메서드를 하나라도 포함하고 있는 경우 => 추상클래스.
// 추상 메서드 : 미완성된 메서드.
public abstract class Player {	// 인스턴스 생성이 안된다.	추상클래스는 상속 목적.
	
	int currentPos;
	
	Player(){
		
	}
	
	// 추상메서드 : abstract 반환형 메서드이름(매개변수);
	abstract void play(int pos);
	
	// 추상메서드
	abstract void stop();
	
	void play() {
		play(currentPos);
	}
}
