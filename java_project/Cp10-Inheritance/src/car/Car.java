package car;

public class Car {

		String color;
		int door;
		
		void drive() {
			System.out.println("운전");
		}

		void stop() {
			System.out.println("멈춤");
		}
		
		public static void main(String[] args) {
			
			Car car = null;
			Fireengine fe1 = new Fireengine();
			Fireengine fe2 = null;
			Ambulance am = null;
			
			fe1.water();
			car = fe1;					// car = (Car)fe1;    생략가능.
			// car.water();				// 사용불가능. water는 자식꺼에 있어서 못쓴다. car가 부모다.
			
			fe2 = (Fireengine)car;		// fe2 = car; 생략 불가능.
			
			
			if(car instanceof Ambulance){	// 부모가 자식으로 형변환 안된다. 
				am = (Ambulance)car;		// 자식이 부모로 형변환 가능하다.
				am.siren();
				
				
			}
			
		}	// main 메소드 끝.
		
}		

class Fireengine extends Car{
	
	void water() {
		System.out.println("물뿌리기");
	}
}

class Ambulance extends Car{
	
	void siren() {
		System.out.println("삐뽀삐뽀~");
	}
}


