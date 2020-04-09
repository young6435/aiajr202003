package prac;

public class Prac_07 {

	public static void main(String[] args) {

		float f = 1.2345678901234567890f;		//뒤에 숫자에 f를 안붙이면 디폴트값이 double 이여서 f변수에 담을수가 없다.		
		double d = 1.2345678901234567890;		//d가 double 이니까 숫자뒤에 f 안붙인다.
		float f2 = 0.100000001f; // 0.1 double d2 = 0.100000001; // 접미사 생략되었다.
		double d3 = 0.1000000000000001;			//d3가 double 이니까 숫자뒤에 f 안붙인다.
		System.out.println(f);
		System.out.println(d);
		System.out.println(f2);
		
		System.out.println(d3);
	}

}
