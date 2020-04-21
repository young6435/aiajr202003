package ex;

public class Friend {
	
	String myName;
	
	Friend(String name){		// 생성자.
		myName = name;
	}

	// Object 클래스의 toString() 메서드를 재구성한다. => 오버라이딩.
	// 메서드의 선언부가 원본 메서드의 선언부와 동일해야한다.
	
	  public String toString() { // 선언부는 똑같해야 된다.
	  
	  return "제 이름은 " + this.myName + "입니다."; // 구현부는 바껴도 된다. }
	  
	  }
	
	
	
	
	public static void main(String[] args) {
		
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("박지성");
		
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		
		System.out.println(f1);
		System.out.println(f2);
		
	}

//	@Override
//	public String toString() {
//		return "Friend [myName=" + myName + "]";
//	}

}
