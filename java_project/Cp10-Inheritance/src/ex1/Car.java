package ex1;

//문제 1.
//상관관계에 놓여있는 클래스의 생성자 정의 및 호출방식에 대해 알아보았다.
//이 내용을 바탕으로 다음 클래스에 적절한 생성자를 넣어보자.
//그리고 이의 확인을 위한 maon메서드로 적절히 정의 해 보자.

class Car { 
	
	int gasolinegauge;
	Car(int gasolinegauge){
		this.gasolinegauge = gasolinegauge;
	}
} 

class HybridCar extends Car { 
	
	int electronicGauge;
	
	HybridCar(int gasolinegauge, int electronicGauge){
		super(gasolinegauge);
		this.electronicGauge = electronicGauge;
	}
} 

class HybridWaterCar extends HybridCar { 
	
	int waterGauge;

	HybridWaterCar(int gasolinegauge, int electronicGauge, int waterGauge){
		super(gasolinegauge,electronicGauge);
		this.waterGauge = waterGauge;
	}
	
	
	public void showCurrentGauge() { 
		System.out.println("잔여 가솔린 : " + gasolinegauge);
		System.out.println("잔여 가솔린 : " + electronicGauge);
		System.out.println("잔여 가솔린 : " + waterGauge);
		} 
} 
