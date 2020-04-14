//처음에 클래스 정의 해야된다.
// 사과장수 (클래스)
// 나 (클래스)

package fruit;

public class FruitMain {

	public static void main(String[] args) {

		// 셀러 생성 : 인스턴스화.
		FruitSeller seller = new FruitSeller();
		//new FruitSeller() => 객체 생성, 메모리에 변수, 변수의 데이터, 메소드 코드가 저장된다.
		
		// 구매자 생성 : 인스턴스화.
		FruitBuyer buyer = new FruitBuyer();
	
		// 구매자가 사과를 구매.
		buyer.buyApple(seller, 5000);
		
		seller.saleResult();
		buyer.saleResult();
	}

}
