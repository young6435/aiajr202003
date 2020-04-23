package ex1;					// TvMain, Tv, IpTv, SmartTv, CaptionTv 한세트.

public class TvMain {

	public static void main(String[] args) {
		
		Tv tv1 = new Tv();
		
		// IpTv itv = (IpTv) tv1;		// 이렇게 하면 안된다.
										// 형변환 해도 안되는게 있다.
		
		
		
		
		CaptionTv cTv1 = new CaptionTv();
		
		Tv t = cTv1;
		
		
		
		
		
		
		Tv tv2 = new CaptionTv();	// CaptionTv성질을 다 가지고 있고 쓸때는 Tv것만 쓴다.
		
		// IpTv itv3 = (IpTv)tv2;		// 이렇게 하면 안된다.
		
		
		CaptionTv ctv2 = (CaptionTv)tv2;	// 성질을 원래 갖고있었기 때문에 형변환이 가능.
		
		ctv2.caption();
		
		//System.out.println(tv2.power);
		tv2.power();
		//System.out.println(tv2.power);
		
		//tv2.display();
		
		Tv tv3 = new IpTv();
		Tv tv4 = new SmartTv();
		
		//tv3.display();
		//tv4.display();
		
		Tv[] tvs = new Tv[4];			// 참조형배열.
		
		tvs[0] = new Tv();
		tvs[1] = new CaptionTv();	// 배열의 요소는 변수와 같다. Tv tv2 = new CaptionTv(); 이런거와 같다.
		tvs[2] = new IpTv();
		tvs[3] = new SmartTv();		// 형변환 해서 사용해야된다. 자식꺼를 부모꺼에 넣으니까 명시적 형변환해야된다.
		
		for(int i=0; i<tvs.length; i++) {
			tvs[i].display();
		}
		
		
	}

}
