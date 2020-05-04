package ex;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		//HashMap<Integer, String> map = new HashMap<>();
		//Map<Integer, String> map = new HashMap<Integer, String>();
		
		// 입력.
		map.put(1, "일번");		// 추가. add랑 같다. map은 put쓴다.
		map.put(2, "이번");
		map.put(3, "삼번");
		map.put(8, "팔번");		// 정렬과는 상관없다. 사용자가 정의하는거다.
		
		// 참조.
		System.out.println("1번 학생의 이름은 : "+map.get(1));
		System.out.println("8번 학생의 이름은 : "+map.get(8));
		
		
		// 삭제.
		map.remove(8);
		System.out.println("8번 학생 삭제");
		System.out.println("8번 학생의 이름은 : "+map.get(8));		// 삭제해서 null값 들어온다.
		
		
		System.out.println(map.get(2));		// key 값 2인거 데이터 불러온다.
		System.out.println("key=2인 데이터 중복 입력");
		
		
		// key 값은 중복 허용이 되지 않는다.
		map.put(2, "Two");		
		System.out.println(map.get(2));		// 데이터가 "이번"에서 "Two"로 바뀐다.
		
		
	}

}
