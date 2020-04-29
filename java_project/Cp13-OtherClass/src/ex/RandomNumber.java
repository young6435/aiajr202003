package ex;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		
		Random rand = new Random(System.currentTimeMillis());
		for(int i=0; i<10; i++) {
			
			//System.out.println(rand.nextBoolean());
			System.out.println(rand.nextInt(45)+1);			// 1부터 45까지/
			//System.out.println(rand.nextDouble());
			System.out.println("=====================");
		
		
		}
	}

}
