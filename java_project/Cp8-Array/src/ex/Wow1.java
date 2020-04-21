package ex;

public class Wow1 {

	public static int miniValue(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int mini = arr[0];
			if(mini > arr[i]) {
			mini = arr[i];
			
			}
			
		}
		return mini;
	}
	
	public static int maxValue(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int max = arr[0];
			if(max < arr[i]) {
			max = arr[i];
			
			}
			
		}
		return max;
		
	}
	

	

}
