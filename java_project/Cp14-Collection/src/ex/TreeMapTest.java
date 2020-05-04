package ex;

import java.util.Iterator;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		
		TreeMap<Integer, String> tMap = new TreeMap<>();
		//Map<Integer, String> tMap = new TreeMap<>();
		
		tMap.put(1, "data1");
		tMap.put(3, "data3");
		tMap.put(5, "data5");
		tMap.put(4, "data4");
		tMap.put(2, "data2");
		
		
		// Map => Collection
		// Map => Set
		NavigableSet<Integer> navi = tMap.navigableKeySet();
		
		Iterator<Integer> itr = navi.iterator();	// 그냥 출력(오름차순)?
		
		while(itr.hasNext()) {
			System.out.println(tMap.get(itr.next()));
		}
		
		System.out.println("========================");
		
		
		// 반대로 출력.
		
		itr = navi.descendingIterator();		// 내림차순 출력.
		
		while(itr.hasNext()) {
			System.out.println(tMap.get(itr.next()));
		}
		
	}

}
