package ex;

public class IEGrade {

	public static void main(String[] args) {

		int score = 99;
		
		String grade = "";  		// A+, A, A-, B+, B, B-, c
	
		// 100 ~ 98 : A+
		// 97 ~ 94 : A
		// 90 ~ 93 : A-
		
		if(score >= 90) {
			grade = "A";
			
			if(score >= 98) {
				grade = grade + "+";    // grade += "+";
			}else if(score < 94){		// 90 이상.
				grade = grade + "-";	// grade += "-";
			}
		}else if (score >=80) {  	//90에서 80 사이.
			grade = "B";
			if(score >= 88) {
				grade += "+";
			}else if(score < 84) {  	//80 에서 84 사이.
				grade += "-";
			}
		}else {
			grade = "C";
		}
		System.out.println("grade : " + grade);
//		if(score >= 98 && score <= 100) {
//			grade = "A+";
//			
//		}
//		
//		if(score >= 94 && score <= 97) {
//			grade = "A";
//		}
//		
//		if(score >= 93 && score <= 90) {
//			grade = "A-";
//		}	
//	
	
	}

}
