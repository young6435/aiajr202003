package ex;

import java.util.Scanner;

public class Wow_main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);		// scanner 쓸때 import 해야된다.
		
		int[] arr = new int[5];
		
		
		for(int i=0; i<arr.length; i++) {			//숫자 입력받기.
			System.out.println("숫자를 입력해주세요.");
			arr[i] = sc.nextInt();
		
		}
		
		System.out.println(arr);

		int maxnum = Wow1.maxValue(arr);
		int minnum = Wow1.miniValue(arr);
		
		System.out.println("최소값 : "+minnum);
		System.out.println("최대값 : "+maxnum);
		
		
	}

}
