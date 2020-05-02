
package fruit;

/*
작성자 : 임재영
수정일 : 2020.04.17
수정내용 : 생성자를 통한 변수 초기화.
*/

public class FruitBuyer {		// 고객
	
	// 속성 : 변수.
	// 1. 보유한 나의 돈.
	// 2. 사과의 개수.
//	int myMoney = 10000;
//	int numOfApple = 0;
	
	// 변수의 명시적 초기화 변경.
	int myMoney;
	int numOfApple;
	
	// 생성자.
	FruitBuyer() {								// 매개변수가 없을때.
		myMoney = 5000;
		numOfApple = 0;
	}
	
	FruitBuyer(int money, int num){				// 매개변수가 있을때.
		myMoney = money;
		numOfApple = num;
	}
	
	
	// 기능 : 메서드.
	// 1. 사과장수 찾기 받기.
	// 2. 지출할 돈 정의.
	// 3. 셀러에게 돈을 주고 판매 요청. => 사과의 개수를 얻는다.
	// 4. 사과의 개수를 받은 사과의 개수만큼 증가시킨다.
	// 5. 지출한 돈은 나의 돈에서 차감한다.
	
	
	// 참조변수 : FruitSeller의 주소를 seller가 가지고 있다.
	void buyApple(FruitSeller seller, int money) {
		
		int num = seller.saleApple(money);	//seller.saleApple 메서드는 개수 구하는 메서드.
		numOfApple += num;		// 사과를 샀으니까 개수를 더한다.
		myMoney -= money;		// 돈을 지불했으니까 뺀다.
	}
	
	void saleResult() {
		
		System.out.println("===================");
		System.out.println("구매자의 정보");
		System.out.println("현재 보유한 금액 : " + myMoney);
		System.out.println("보유한 사과의 개수 : " + numOfApple);
	}
	
	

	

}
