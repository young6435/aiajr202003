package ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest2 {

	public static void main(String[] args) {
		
		 HashSet<SimpleNumber> set = new HashSet<SimpleNumber>();
		// HashSet<String> set = new HashSet<>();
		//Set<String> set = new HashSet<>();
		
		set.add(new SimpleNumber(10));		
		set.add(new SimpleNumber(20));
		set.add(new SimpleNumber(10));
		
		System.out.println("저장된 데이터의 개수 : " + set.size());		// 3개 뜬다.
		
		Iterator<SimpleNumber> itr = set.iterator();
		
		while(itr.hasNext()) {
			
			System.out.println(itr.next());		// 출력되는건 임의의 데이터부터 출력된다. 순서대로 되는게 아니다.
			
		}
		
		
	}

}


class SimpleNumber{
	
	int num;
	
	public SimpleNumber(int num) {
		this.num = num;
	}
	
	public String toString() {
		return String.valueOf(num);
	}
	
	
	// HashSet 의 동등 비교 과정.
	// 1. hash 코드를 비교 해서 같은 hash 코드를 가진 객체를 기반으로 비교한다.
	// 2. equals 메서드로 비교한다.
	
	
	

	@Override
	public boolean equals(Object obj) {		// 여기 구조 잘 봐야 된다.
		
		boolean result = false;
		
		// num 의 값을 비교해 주자.
		if(obj instanceof SimpleNumber) {
			
			SimpleNumber sm = (SimpleNumber)obj;		// 형변환 안되면 그냥 false 처리한다.
			result = this.num == sm.num;
		}
		
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
}
