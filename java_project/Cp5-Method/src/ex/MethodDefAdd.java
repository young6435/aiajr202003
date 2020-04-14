package ex;

public class MethodDefAdd {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");

		hiEveryone(23, 175.4); // hiEveryone 메서드에서 static 빼면 실행 안된다.
		hiEveryone(14, 180.4); // static 을 쓰든지, 객체를 만들어야 된다.
		hiEveryone(8, 220); // int는(220) double로 바껴서 들어간다.
		hiEveryone(19, 260.5);

		System.out.println("프로그램 종료");
	}

	// 인사물 출력(반환값이 없다.), 나이값을 받아서 나이를 출력하는 메서드.
	static void hiEveryone(int age, double height) {
		System.out.println("안녕하세요.");

		if (age < 10) { // 8살은 출력안된다.	위에꺼 "안녕하세요"만 찍는다.
			return;
		}
		System.out.println("제 나이는 " + age + "살 입니다.");
		System.out.println("제 나이는 " + height + "cm 입니다.");

	}
}
