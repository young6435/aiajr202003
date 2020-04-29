package ver05;

/*
  1. manager 클래스의 싱글톤 패턴 처리.
  	
  	- 생성자 접근제어지시자 : private => 인스턴스 생성 막는다.
  	- 공동으로 사용할 인스턴스 생성 : static private	 	외부에서 접근하면 안된다. 
  	- 참조변수 반환 메서드 : static public   외부에서 접근하도록 한다.
  
  2. interface 기반의 상수 표현.
  	 메뉴표현
  	 	고교 친구 : 1
  	 	대학 친구 : 2
  	 	기본정보 출력 : 3
  	 	전체정보 출력 : 4
  	 	exit :5 
  
  3. interface => 추상클래스 => 상속 관계 구조로 변경.
  	 
	
	
  4. PhoneBook 예외상황


      1. 메뉴 입력 시.

        - 숫자 => 문자입력 시 (RuntimeException)
        - 메뉴의 범위에 벗어나는 메뉴 입력.
          1~6 : 논리적 오류 => 사용자 예외.

      2. 사용자의 데이터 입력 시.
   
        - 공백 입력 => 사용자 예외.
 */
public class Memo {

}
