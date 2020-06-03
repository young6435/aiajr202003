package instanceof11;

public class InstanceOf {
	
	public static void main(String[] args) {
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		wrapBox(box1);		// 밑에 메서드호출.		// simple wrap 호출된다.
		wrapBox(box2);							// paper wrap 호출된다.
		wrapBox(box3);							// gold wrap 호출된다.
	
		
	}

	public static void wrapBox(Box box) { 	//PaperBox, GoldPaperBox 는 Box를 상속해서 3개 다 사용가능하다.
		
		//box.wrap();
		if (box instanceof GoldPaperBox)
			((GoldPaperBox) box).goldWrap();
		else if (box instanceof PaperBox)
			((PaperBox) box).paperWrap();
		else
			box.simpleWrap();
	}

}

class Box {
	public void simpleWrap() {
		System.out.println("simple wrap");
	}
	
	public void wrap() {
		System.out.println("simple wrap");
	}
}

class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("paper wrap");
	}

	@Override									// 오버라이딩 했다.
	public void wrap() {
		System.out.println("paper wrap");
	}
	
	
}

class GoldPaperBox extends PaperBox {
	public void goldWrap() {
		System.out.println("gold wrap");
	}

	@Override									// 오버라이딩 했다.
	public void wrap() {
		System.out.println("gold wrap");
	}
	
}

