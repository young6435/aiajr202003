// 트럼프카드 종류별로 생성하기.

package card;

public class CardMain2 {

	public static void main(String[] args) {
	
		
		int i,j;
		for(i=1; i<=4; i++) {
			for(j=1; j<=13; j++) {
				
				String kind = "";
				
				switch(i) {
				case 1:
					kind = "spade";
					break;
				case 2:
					kind = "clover";
					break;
				case 3:
					kind = "heart";
					break;
				case 4:
					kind = "diamond";
					break;
				}
				
				Card c = new Card();
				c.kind = kind;
				c.number = j;
				
				System.out.println("카드는 "+ c.kind +"이고,");
				System.out.println("숫자는 "+ c.number +"이고,");
				System.out.println("높이는 "+ c.height +"이고,");
				System.out.println("넓이는 "+ c.width +"입니다.");
			}
		}
			
	}

}
