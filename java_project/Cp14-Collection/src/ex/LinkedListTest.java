package ex;				// ArrayList 와 사용방법이 같다.

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		
		// List<E> => ArrayList<E>
		// List<E> 특징 : 1.저장순서를 가진다. 
		//				 2.데이터의 중복 저장 가능.
		// 순서대로 처리할 수 있다. => 일괄 처리(반복적인 동일한 작업을 빠르게 처리 할 수 있다.)
		// 배열보다 리스트가 편하다.
	
		// ArrayList 인스턴스 생성 : Integer 타입의 객체만 저장.
		LinkedList<Integer> list = new LinkedList<Integer>();	// 1번 방식.
		//ArrayList<Integer> list = new ArrayList<>();			// 2번 방식.(인스턴스 생성시에 자료형을 생략가능)
		//List<Integer> list = new ArrayList<>();				// 3번 방식. 다형성.
		
		// List<E> 정의된 메서드 => 
		// add(E) : 인스턴스의 저장.
		// remove(index) : 해당 index의 요소를 삭제.
		// size() : List요소의 개수를 반환해준다.
		// get(index) : 해당 index위치의 요소 반환.
	
		
		// 데이터의 저장.   저장한(입력한) 순서대로 들어간다.
		list.add(new Integer(30));
		//list.add(20); 가능 	// Auto Boxing.
		list.add(new Integer(20));
		list.add(new Integer(10));
		list.add(0);
		list.add(1);  // 이거 있으면 에러난다.
	
		// 데이터의 참조
		System.out.println("저장된 데이터를 확인 합니다.");
		// 반복문을 통해서 일괄 참조 가능.
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("=============================");
		
		// 데이터의 삭제
//		list.remove(1);		// 1번지값 "10" 삭제되고, 내부적으로 쉬프트해서 2번지값 "30"을 당긴다.
		System.out.println("데이터 삭제 후 데이터를 확인합니다.");
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		System.out.println("Iterator를 이용한 모든 요소 출력.");
		
		Iterator<Integer> itr = list.iterator();
		
		while(itr.hasNext()) {
			
			int num = itr.next();				// 변수(num)에 받아놓고 써야된다.
			System.out.println(itr.next());
		}
		
	
	}

}
