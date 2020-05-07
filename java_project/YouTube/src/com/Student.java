package com;	// 1번문제.

import java.util.ArrayList;
import java.util.Scanner;

public class Student{
	
	private String name;	// 학생이름.
	private String no;		// 학생학번.

	public Student(String name, String no) {
		
		this.name = name;
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}


	public static void main(String[] args) {
		
		Student st1 = new Student("박지성", "1234");
		Student st2 = new Student("플레처", "2343");
		Student st3 = new Student("오셰어", "1252");
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(st1);
		list.add(st2);
		list.add(st3);
		
		for(Student i:list) {		// list 컬렉션은 Student 타입이다.
			System.out.println(i.getName());
			System.out.println(i.getNo());
			
		}
		
		System.out.println("==========================");
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("친구를 검색 하시겠습니까?");
			System.out.println("검색 y, 종료 n");
			
			String input = sc.next();
			
			
			if(input.equals("y")||input.equals("Y")) {
				System.out.println("검색시작.");
				String name = sc.next();
				boolean flag = false;
				
				for(Student i:list) {		// list 컬렉션은 Student 타입이다.
					if(i.getName().equals(name)) {
						System.out.println("해당하는 학생의 이름은 : "+name);
					}
				
				
			
			else if(input.equals("n")||input.equals("N")){
					break;
			}
	
	
	
		
			System.out.println("프로그램 종료.");
			}
	}
}

	


	


	








	























	








	

