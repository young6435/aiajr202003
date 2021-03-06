package ex;

public class ArrayAndMethod {

	public static void main(String[] args) {
		
		// 원본 배열 생성
		int[] arr = {1,2,3,4,5,6,7};		//arr에 주소값 저장. 100번지.
		
		// 결과 저장할 배열 선언.
		int[] ref;		 //arr에 10 더한거 저장할거.
		
		// 메서드 호출하고 결과를 ref에 저장.
		ref = addAllArray(arr, 10);		//arr의 주소값 주고 호출한다. 100번지.
										// ref 도 주소값 100번지 들어간다.
		
		System.out.println("동일 배열 참조 여부 확인 : "+ (arr==ref));
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	// 배열(배열 참조변수)을 전달받고, 증가시킬 정수값도 받아서
	// 모든 배열의 요소에 더해준다.
	// 전달받은 배열을 반환한다.
	public static int[] addAllArray(int[] ar, int addVal) {		// ar=100번지.
		
		for(int i=0; i<ar.length; i++) {
			ar[i] = ar[i]+addVal;		//ar[i] += addVal
		}
		
		return ar; // 100번지 반환.
	}
}
