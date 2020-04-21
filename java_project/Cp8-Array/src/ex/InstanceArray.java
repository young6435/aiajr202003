package ex;

public class InstanceArray {

	public static void main(String[] args) {
		
		// 참조형(String) 변수를 저장하는 배열 생성. =>String이 아니여도 된다.
		String[] strArray = new String[3];
		
		// strArray[0] : 배열의 첫번째 참조변수.
		strArray[0] = "JAVA";				// JAVA의 주소값이 strArray[0]에 저장된다.
		strArray[1] = "JS";					// JS의 주소값이 strArray[1]에 저장된다.
		strArray[2] = "Python";				// Python의 주소값이 strArray[2]에 저장된다.
		
		/*
		 *  strArray[0].toString()
		 *  strArray[0].length()  
		 *  참조변수 니까 이런게 가능하다.
		 */
		
		// String 타입의 참조변수 => strArray[0]
		System.out.println("문자열의 길이 : "+strArray[0].length());
		System.out.println("문자열의 toString() : "+strArray[0].toString());
	
		// 배열의 순차적 참조 : 반복문을 이용해서 순차 참조가능.
		for(int i=0; i<strArray.length; i++) {
			System.out.println(strArray[i]);
			
		}
	
	}

}
