package ex;

public class LinkedTest {				// 조각조각 떨어진걸 연결시킨다고 보면된다. 배열이랑 다르다.

	public static void main(String[] args) {

		String str1 = "one";
		String str2 = "two";
		String str3 = "three";
		String str4 = "four";
		
		Data d1 = new Data(str1, str2);		// 첫번째 = 값, 두번째 = 다음꺼 주소값.
		
		//Data d4 = new Data(str4, str2);  // 여기에 들어온다고 생각하면 된다.
											// one => four => two => three 
		Data d2 = new Data(str2, str3);
		
		Data d3 = new Data(str3, null);
		
		
		// 중간에 데이터 삽입.
		Data d4 = new Data(str4, str2);		// d4는 다음 주소값을 str2로 잡는다.
		d1.setNextValue(str4);				// d1 다음에 올 주소값을 str4로 바꾼다.
		
	
	}

	

}


class Data{
	
	Object value;
	Object nextValue;

	Data(Object obj, Object nextObj){
		this.value = obj;
		this.nextValue = nextObj;
		
	}
	
	Object getValue() {
	
		return value;
		
	}

	void setNextValue(Object nextValue) {
		
		this.nextValue = nextValue;
		
	}
	
	
	
	
	
	
}