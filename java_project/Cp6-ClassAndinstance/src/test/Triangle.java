package test;

public class Triangle {
	
	// 변수 : 밑변, 높이
	
	int width;		// 밑변 데이터.
	int height;		// 높이 데이터.

	// 생성자 : 인스턴스 생성시에 반드시 한번 실행한다. => 인스턴스변수들의 초기화 작.
	//		    생략가능.
			    
	// 기본 생성자.
	Triangle(){
		
	}
	
	Triangle(int w, int h){
		width = w;
		height = h;
	}
	
	// 밑변과 높이 데이터를 변경하는 메서드.
	void setData(int w, int h) {	// 지역변수, 메서드실행할때 생성, 메서드끝나면 소멸.
		width = w;
		height = h;
	}
	
	// 삼각형의 넓이를 구해서 반환하는 메서드.
	
	float area() {
		float result = width * height / 2f;
		return result;
	}

	
	public static void main(String[] args) {
		
		// 삼각형 객체 생성.
		//Triangle t = new Triangle();				// 생성자 안만들고 했을때.
		Triangle t = new Triangle(5,3);				// 생성자 만들고 했을때.
		
		
		// 데이터 설정.
		t.setData(5, 3);
		
		System.out.println("삼각형의 밑변 : "+t.width+", 높이 : "+t.height);
		
		// 넓이를 구하는 메서드 실행.
		System.out.println("삼각형의 넓이는 "+t.area()+"입니다.");
	}
	
	
}

