package prac;

public class Prac_01 {

	public static void main(String[] args) {
		
		char ch1='A';	//문자타입의 변수 ch1선언, 초기화. 'A'저장하고 대입.
		char ch2='Z';
		int num1=ch1;			//ch1을 int형으로 바꿔서 num1에 저장한다.
		int num2=(int)ch2;		//ch2를 int형으로 바꿔서 num2에 저장한다.
		System.out.println("문자 A의 유니코드 값: "+num1);
		System.out.println("문자 Z의 유니코드 값: "+num2);
		
	}

}
