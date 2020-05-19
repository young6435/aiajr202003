package com;		// 알고리즘 2번. (피보나치 수열)

public class Algo2 {

	public static void main(String[] args) {
		
		
		// An =An-1 + An-2 (피보나치 수열)
		
		
		// 1번 방법.
		int[] arr= new int[100];
		
		arr[1]=1;			// 이거 왜 배열 1번지 부터 하지?, 배열0번지부터 하면 값이 다르게 나온다.
		arr[2]=1;
		
		
		for(int i=3; i<100; i++) {
			
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		for(int i=1; i<=10; i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
//		System.out.println(arr[0]);		// 뭐 들어있나 확인했음.
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
		
		
		// 2번 방법.
		
		int prePreNum = 1;
		int preNum = 1;
		int nNum;
		
		System.out.print(prePreNum+" ");
		System.out.print(preNum+" ");
		
		for(int i=0; i<=10; i++) {
			
			nNum = prePreNum+preNum;
			System.out.print(nNum+" ");
			
			prePreNum = preNum;
			preNum = nNum;
			
			
		}
	}

}
