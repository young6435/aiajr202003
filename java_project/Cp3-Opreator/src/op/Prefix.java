package op;

public class Prefix {

	public static void main(String[] args) {
		
		int num1 = 7;
		int num2, num3;
		num2 = ++num1;					//num2 = 8,  num1 = 8
		num3 = --num1;					//num3 = 7,  num1 = 7
		System.out.println(num1);		//7
		System.out.println(num2);		//8
		System.out.println(++num2);		//8+1 = 9
		System.out.println(num3);		//7  
	}

}
