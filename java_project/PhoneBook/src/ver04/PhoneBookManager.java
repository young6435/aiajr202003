package ver04;

import java.util.Scanner;

// PhoneInfo 타입의 배열로 친구들의 정보를 
// 저장, 수정, 삭제, 검색, 출력
public class PhoneBookManager {

	// 1. 배열 선언
	PhoneInfo[] books;		// PhoneInfo 타입으로 객체가 생성되니까, PhoneInfo 타입으로 만들어야 객체 담을수 있다.
	// 배열에 저장된 요소의 개수
	int numOfInfo;

	Scanner kb;

	// 생성자를 통해서 배열 생성, 요소의 개수 초기화
	PhoneBookManager(int num) {
		// 배열의 생성
		books = new PhoneInfo[num];		// main에서 100개 줄꺼다.
		// 요소 개수의 초기화
		numOfInfo = 0;
		// Scanner 초기화
		kb = new Scanner(System.in);
	}

	
	// 2. 배열에 정보 저장
	// 2.1 배열에 추가
	// 2.2 사용자로 부터 받은 데이터로 인스턴스 생성

	// 2.1 배열에 추가
	void addInfo(PhoneInfo info) {
		// 배열에 numOfInfo 숫자 -> index 로 참조값을 저장
		books[numOfInfo] = info;
		// 입력된 정보의 개수를 +1 증가 시킨다
		numOfInfo++;
	}

	// 2.2 사용자로 부터 받은 데이터로 인스턴스 생성
	void createInfo() {		// 메뉴에서 1. 친구 정보 입력 누르고 들어온상태.

		System.out.println(" 1.일반 2.대학 3.회사 4.동호회 ");

		System.out.println("입력하고자 하는 번호를 입력해주세요.");

		// int select = kb.nextInt();
		// kb.nextLine();

		// 사용자 선택 번호
		int select = Integer.parseInt(kb.nextLine());		// string타입의 숫자를 int 타입으로 변환시킨다.
	
		if(!(select>0 && select<5)) { // 1~4번
			System.out.println("정상적인 메뉴 선택이 아닙니다.\n메뉴를 다시 선택해 주세요.");
			return;
		}

		// 2.2.1 기본 정보 수집 : 이름, 전번, 주소, 이메일
		System.out.println("이름을 입력해 주세요.");
		String name = kb.nextLine();

		System.out.println("전화번호를 입력해 주세요.");
		String phoneNumber = kb.nextLine();

		System.out.println("주소를 입력해 주세요.");
		String addr = kb.nextLine();

		System.out.println("이메일을 입력해 주세요.");
		String email = kb.nextLine();

		PhoneInfo info = null;		// 기본으로 4개는 입력받아야 되고, 추가로 합친 다음에,
									// 객체를 만들어야 되니까 미리 null값으로 해둔다.
		switch (select) {
		case 1:	// 기본으로 하나 만든다. 4개짜리.
			// 2.2.2 기본 클래스로 인스턴스 생성
			info = new PhoneInfo(name, phoneNumber, addr, email);	// 여기서 만드니까.
			break;
		case 2:	// 대학.
			System.out.println("전공(학과)를 입력해주세요.");
			String major = kb.nextLine();
			
			System.out.println("학년 정보를 입력해주세요.");
			String grade = kb.nextLine();
			
			// 2.2.3 대학 클래스로 인스턴스 생성			
			info = new PhoneUnivInfo(name, phoneNumber, addr, email, major, grade);
			break;
		case 3:	// 회사.
			System.out.println("회사의 이름을 입력해주세요.");
			String company = kb.nextLine();
			
			System.out.println("부서의 이름을 입력해주세요.");
			String dept = kb.nextLine();
			
			System.out.println("직무(직급)정보를 입력해주세요.");
			String job = kb.nextLine();
			
			// 2.2.4 회사 클래스로 인스턴스 생성
			info = new PhoneCompanyInfo(name, phoneNumber, addr, email, company, dept, job);
			break;
		case 4:	// 동호회.
			System.out.println("동호회 이름을 입력해주세요.");
			String cafeName = kb.nextLine();
			
			System.out.println("닉네임을 입력해주세요.");
			String nickName = kb.nextLine();
			
			// 2.2.5 동호회 클래스로 인스턴스 생성
			info = new PhoneCafeInfo(name, phoneNumber, addr, email, cafeName, nickName);
			break;
		}

		// 2.3 생성된 인스턴스를 배열에 저장
		
		addInfo(info);

	}	// createInfo 끝.

	// 3. 배열의 데이터 출력
	void showAllInfo() {
		
		// for each 반복  : 현재 프로그램에서는 사용 불가
		// for 반복문 : 반복의 횟수 지정이 가능 numOfInfo
		
		System.out.println("전체 정보를 출력합니다. ===========");
		for(int i=0; i<numOfInfo ; i++) {
			books[i].showAllInfo();					//books가 PhoneInfo 타입이고, PhoneInfo 안에 showAllInfo 있다.
			System.out.println("----------------");
		}
		
	}
	
	
	// 배열의 index 검색 : 인스턴스의 name 기준
	int searchIndex(String name) {
		
		// 정상적인 index 값은 0~이상의 값, 찾지 못했을 때 구분 값 -1을 사용
		int searchIndex = -1; 	// 정상적인 index 값은, 0  이상의 값, 찾지 못했을때 -1을 사용.
		
		// 배열의 반복으로 name 값을 비교해서 index 값을 찾는다.
		for(int i=0; i<numOfInfo; i++) {
			if(books[i].name.equals(name)) {	// 매개변수 name이랑 같냐.
				searchIndex=i;
				break;
			}
		}
		
		return searchIndex;
		
	}	// searchIndex 끝.
	
	
	// 4. 배열의 정보 검색 : 이름 기준
	void showInfo() {
		
		System.out.println("검색하실 이름을 입력해주세요.");
		String name = kb.nextLine();
		
		int index = searchIndex(name);		// index 번호 넘어와서 index 변수에 들어간다.	
		
		if(index<0) {
			System.out.println("검색하신 이름의 정보가 없습니다.");
		} else {
			System.out.println("----------------");
			books[index].showBasicInfo();				//books가 PhoneInfo 타입이고, PhoneInfo 안에  showBasicInfo 있다.
			System.out.println("----------------");
		}
		
		
	}
	
	
	
	// 5. 배열의 정보를 삭제 : 이름 기준
	void deleteInfo() {
		System.out.println("삭제하고자하는 이름을 입력해주세요.");
		String name = kb.nextLine();
		
		int index = searchIndex(name);	// 검색해야 이름을 지우니까, 위에서 검색하는 거랑 똑같다.
		
		if(index<0) {
			System.out.println("삭제하고자하는 이름의 정보가 없습니다.");
		} else {
			
			// 삭제 위치에서 외쪽으로 시프트
			for(int i=index; i<numOfInfo-1; i++) {	// 해당 index를 지울꺼니까 바로 다음껄로 덮어씌운다
				books[i]=books[i+1];
			}
			// 삭제가 되었으므로 요소의 개수도 -1 
			numOfInfo--;
		}
		
	}	// deleteInfo 끝.
	
	
	// 6. 배열의 정보를 수정 : 이름 기준
	void editInfo() {
		
		System.out.println("변경하고자 하는 이름을 입력해주세요.");
		String name = kb.nextLine();
		
		int index = searchIndex(name);	// 검색해야 수정을 할수있으니까, 위에서 검색하는 거랑 똑같다.
		
		if(index<0) {
			System.out.println("찾으시는 이름의 정보가 존재하지 않습니다.");
			return;
		} else {
			
			String editName = books[index].name;	// 검색해서 나온 index를  editName에 넣는다.
			
			System.out.println("수정 데이터 입력을 시작합니다.");
			System.out.println("이름은 " + editName + "입니다.");
			
			System.out.println("전화번호를 입력해주세요.");
			String phoneNumber = kb.nextLine();
			
			System.out.println("주소를 입력해주세요.");
			String addr = kb.nextLine();
			
			System.out.println("이메일을 입력해주세요.");
			String email = kb.nextLine();
			
			PhoneInfo info = null;	// 여기서 null값으로 비워놔야 밑에서 객체 만든거 들어간다.
			
			// 배열이 PhoneInfo 타입이고, PhoneInfo 타입을 상속받아서 
			// 대학,회사,동호회 친구들을 만들었다.
			// 그래서 타입변환할때 잘 봐야된다.
			
			// 저장된 인스턴스가 : 기본, 대학, 회사, 동호회
			if(books[index] instanceof PhoneUnivInfo) {		// books 가 PhoneInfo 타입이다.
				System.out.println("전공을 입력해주세요.");
				String major = kb.nextLine();
				
				System.out.println("학년을 입력해주세요.");
				String grade = kb.nextLine();
				
				info = new PhoneUnivInfo(editName, phoneNumber, addr, email, major, grade);
				
			} else if(books[index] instanceof PhoneCompanyInfo) {
				
				System.out.println("회사 이름을 입력해주세요.");
				String company = kb.nextLine();
				
				System.out.println("부서 이름을 입력해주세요.");
				String dept = kb.nextLine();
				
				System.out.println("직급을 입력해주세요.");
				String job = kb.nextLine();
				
				info = new PhoneCompanyInfo(editName, phoneNumber, addr, email, company, dept, job);
				
			
			} else if(books[index] instanceof PhoneCafeInfo) {
				
				System.out.println("동호회 이름을 입력해주세요.");
				String cafeName = kb.nextLine();
				
				System.out.println("닉네임을 입력해주세요.");
				String nickName = kb.nextLine();
				
				info = new PhoneCafeInfo(editName, phoneNumber, addr, email, cafeName, nickName);
				
			} else if(books[index] instanceof PhoneInfo) {
				info = new PhoneInfo(editName, phoneNumber, addr, email);
			}
			
			// 배열에 새로운 인스턴스를 저장
			books[index] = info;
			
			
		}
		
		
		
	}	// editInfo 끝.
	
}