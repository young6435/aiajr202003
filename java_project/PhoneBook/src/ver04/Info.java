package ver04;

/*
클래스의 정의

- 데이터 저장용 클래스
1. 상속관계로 구성
   - 기본 클래스( 상속을 위한 클래스 )
     PhoneInfor
   - PhoneUnivInfor
   - PhoneCompanyInfor
   - PhoneCafeInfor

- PhoneInfor
변수 : 이름, 전화번호, 주소, 이메일
메서드 : 기본정보 출력, 전체정보 출력(오버라이딩)

- PhoneUnivInfor
PhoneInfor 상속
변수 : 전공, 학년
메서드 : 전체 정보 출력(오버라이딩)

- PhoneCompanyInfor
PhoneInfor 상속
변수 : 회사이름, 부서, 직급
메서드 : 전체 정보 출력(오버라이딩)

- PhoneCafeInfor
PhoneInfor 상속
변수 : 동호회 이름, 닉네임
메서드 : 전체 정보 출력(오버라이딩)

- PhoneBookManager
배열 : PhoneInfor타입의 배열 생성
입력 : 배열의 요소에 인스턴스 저장
삭제 : 배열의 요소에서 인스턴스 참조 끊는것
수정 : 배열의 수정 하고자하는 인덱스를 찾아서
       변경하고자하는 데이터를 기반으로 
       인스턴스를 생성 해당 인덱스의 배열요소에
       저장

*/

public class Info {

}
