package ex;

import java.util.Iterator;
import java.util.TreeSet;

public class Person implements Comparable<Person>{

	String name;
	int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	void showData() {
		
		System.out.println("이름 : "+this.name+", 나이 : "+this.age);
	}

	@Override
	public int compareTo(Person o) {
		
		int result = 0;
		
//		if(this.age > o.age) {
//			result = 1;			// 양수.	(오름차순)	// 내 나이 기준으로 o의 나이와 비교한다.
//		} else if(this.age < o.age) {				// result 값 양수 음수 바꾸면 출력 달라진다.
//			result = -1;		// 음수.(내림차순)
//		} else {
//			result = 0;
//		}
		
		result = this.age - o.age;				// 나이 빼기한다.		(오름차순)
		//result = (this.age - o.age)*-1;		// 역순으로 나온다.	(내림차순)
		
		return result;
	}
	
	public static void main(String[] args) {
		
		TreeSet<Person> tree = new TreeSet<>();
		
		tree.add(new Person("Son", 27));
		tree.add(new Person("King", 30));
		tree.add(new Person("Lee", 20));
		
		Iterator<Person> itr = tree.iterator();
		
		while(itr.hasNext()) {
			itr.next().showData();
		}
	
	
	}
	
	
}
