package tv;

public class Tvmain2 {

	public static void main(String[] args) {

		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
		
		System.out.println("====================");
		System.out.println(tv1==tv2);		// false. 객체의 주소값이 다르다.
		System.out.println("tv1 의 channel : "+tv1.channel);
		System.out.println("tv2 의 channel : "+tv2.channel);
		
		System.out.println("====================");
		tv1.channel = 10;
		System.out.println("tv1 의 channel 을 10으로 변경");
		
		System.out.println("tv1 의 channel : "+tv1.channel);
		System.out.println("tv2 의 channel : "+tv2.channel);
		
		
	}

}
