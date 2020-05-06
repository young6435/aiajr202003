package ex;				// ThreadMain5

public class Sum {

	int num;
	
	Sum(){
		num = 0;
	}
	
	void addNum(long n) {
		num += n;	// num = num + n;
	}
	
	long getNum() {
		return num;
	}
	
}
