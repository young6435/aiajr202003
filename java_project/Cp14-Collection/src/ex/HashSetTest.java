package ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		
		// HashSet<String> set = new HashSet<String>();
		// HashSet<String> set = new HashSet<>();
		Set<String> set = new HashSet<>();
		
		set.add("First");		
		set.add("Second");
		set.add("Third");
		set.add("First");		// <String> 안에 equals("  ")가 있어서 비교한다. 그래서 3개 뜬다.
								// set은 데이터의 중복저장을 허용하지 않는다.
		
		System.out.println("저장된 데이터의 개수 : " + set.size());		// 3개 뜬다.
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			
			System.out.println(itr.next());		// 출력되는건 임의의 데이터부터 출력된다. 순서대로 되는게 아니다.
			
		}
		
		
	}

}
