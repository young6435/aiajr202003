package card;

public class Card {
	
	static int width = 100;
	static int height = 250;
	
	String kind;
	int number;
	
	Card(){							// 생성자.
		
	}
	
	Card(String type, int num){		
		kind = type;				// 초기화 하는거다.
		number = num;
		
	}

}
