package test;

public class Boy {		// test.Boy		=> 원래이름 이다.
	
	// 구슬의 개수.
	int numOfMarble;
	
	Boy(int num){
		numOfMarble = num;
	}
	
	
	

	// 구슬의 개수 설정.
	void setMarble(int num) {
	
		numOfMarble=num;
	}

	void gameWin(Boy boy, int num) {			// boy는 상대방이다.
		numOfMarble+=num;
		boy.numOfMarble-=num;
	}
	
	void showData() {
		System.out.println("현재 보유한 구슬의 개수는 "+numOfMarble+"개 입니다.");
	}
	
}
