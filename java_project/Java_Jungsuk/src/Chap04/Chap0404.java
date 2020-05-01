package Chap04;

/*
	1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 
	몇까지 더해야 총합이 100이상이 되는지 구하시오.
*/

public class Chap0404 {		// 짝수 even, 홀수 odd

	public static void main(String[] args) {
		
		int num = 0;
		int sum = 0;
		int even;
		int odd;
		
		int i=1;
		while(sum >=100) {
			
			sum += i;
			if(i%2==0) {
				even = i;
				
			}
			
			
			i++;
		}
		
		
	}

}



/*
 	int i=0;

  int EvenSum = 0;

  int OddSum = 0;

  while(true) {

   if (i % 2 == 0) {

    EvenSum = EvenSum + i; 

     } else {

      OddSum = OddSum + i;

     }

   i++;

   if (OddSum-EvenSum>100) {

    System.out.println(i);

    break;

   }

  }
  
  
  
   int num=1;

  int sum=0;

  

  while(true) {

   if(num%2==0) {

    num=num*-1;

    sum+=num;

    num=num*-1;   //이거 안해주면 num값이 -2된다.

   }else {

    sum+=num;

   }

   if(sum>3) {

    System.out.println("마지막 숫자 : "+num);

    System.out.println("총합 : "+sum);

    break;

   }

   num++;

  }



 } 
  
  
 */

