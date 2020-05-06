package ex;		// ThreadMain6

public class Increment {
	
	int num = 0;
	
	void increment() {			// 그냥 synchronized void increment()  이렇게 해도 된다.
		
		synchronized(this) {
			num++;
		}
		
	}
	
	int getNum() {
		return num;
	}
	
	
}
