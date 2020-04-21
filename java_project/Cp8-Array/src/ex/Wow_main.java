package ex;

public class Wow_main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		
		System.out.println("숫자를 입력해주세요.");
		int num1 = sc.nextInt();
		System.out.println("숫자를 입력해주세요.");
		int num2 = sc.nextInt();
		System.out.println("숫자를 입력해주세요.");
		int num3 = sc.nextInt();
		System.out.println("숫자를 입력해주세요.");
		int num4 = sc.nextInt();
		System.out.println("숫자를 입력해주세요.");
		int num5 = sc.nextInt();
		
		arr[0] = num1;
		arr[1] = num2;	
		arr[2] = num3;	
		arr[3] = num4;	
		arr[4] = num5;	
		
		
		
		
		int maxnum = Wow1.maxValue(int[] arr);
		int minnum = Wow1.miniValue(int[] arr);
		
		System.out.println("최소값 : "+minnum);
		System.out.println("최대값 : "+maxnum);
		
		
	}

}
