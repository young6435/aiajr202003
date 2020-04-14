package fruit;

public class FruitSeller {		// 사과장수.
		
	//	속성 : 변수.
	//	1. 사과의 개수.
	// 	2. 수입.
	// 	3. 사과의 가격.
	// 멤버 변수, 인스턴스 변수.
	int numOfApple = 20;		// 사과의 개수.
	int myMoney = 0;			// 수입.
	final int price = 1000;			// 사과의 가격.

	
	//	기능 : 메서드
	//	1. 돈을 받는다. ==> 매개변수 int money.
	// 	2. 받은 돈의 사과의 개수를 구한다.
	//	3. 나의 사과 개수에서 반환해야하는 사과의 개수를 빼준다.
	// 	4. 받은 금액은 나의 수입으로 더해준다.
	// 	5. 사과의 개수를 반환한다. ==> 반환 데이터 int return 사과의 개수.
	int saleApple(int money) {		// 사과 개수 구하는 메서드.
		int num = money/price;		// 사과가 몇개인지.
		
		numOfApple -= num;		//numOfApple = numOfApple - num;	
		myMoney += money;		//myMoney = myMoney + money;
		
		return num;
	}
	
	void saleResult() {
		System.out.println("판매자 판매 정보");
		System.out.println("현재 사과의 개수 : " + numOfApple);
		System.out.println("판매 금액 : " + myMoney);
	}	

}
