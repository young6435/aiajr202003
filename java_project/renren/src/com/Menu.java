package com;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {
	final int STANDARD_DATE = 5; // 연체 기준 날짜 일수
	public String today; // 오늘날짜 형식 : 2016.09.05
	public Scanner sc;
	public User user;

	public Library_Info l_info;

	public Menu() {
		sc = new Scanner(System.in); // 스캐너
		user = new User(); // User 생성
		l_info = new Library_Info(); // 도서관 정보

		// 기본적으로 관리자1, 테스터1 생성
		user.user_Add(new String[] { "admin", "admin", "관리자", "161231", "0", "01198779877" });
		user.user_Add(new String[] { "test", "test", "테스터", "910101", "1", "01012341234" });

		// 기본적으로 책 생성
		l_info.book_Add(new String[] { "대여가능", "자바의 정석", null, "남궁성", "도우출판", "0" });
		l_info.book_Add(new String[] { "대여가능", "모나리자 바이러스", null, "박여명", "북펌", "1" });
		l_info.book_Add(new String[] { "대여가능", "자바스크립트 디자인 패턴", null, "사이먼 팀스", "에이콘", "2" });
		l_info.book_Add(new String[] { "대여가능", "자바스크립트 쿡북", null, "셀리 파워즈", "교학사", "3" });
		l_info.book_Add(new String[] { "대여가능", "이것이 자바다", null, "신용권", "한빛미디어", "4" });
		l_info.book_Add(new String[] { "대여가능", "미래를 바꾸는 장외 주식투자", null, "서유진", "참돌", "5" });
		l_info.book_Add(new String[] { "대여가능", "리치트랙", null, "passion", "좋은땅", "6" });
		l_info.book_Add(new String[] { "test", "주식에 장기투자하라", "20160901", "제러미 시겔", "이레미디어", "7" });
		l_info.book_Add(new String[] { "대여가능", "김이나 작사법", null, "김이나", "문학동네", "8" });

	}

	// 스캐너 받은걸 int형으로 바꺼서 내보냄 한글 특수문자 걸르기!!
	public int checkInputScanner(String input, String print) {
		if (isNumber(input)) { // 숫자만 있으면
			int number = Integer.parseInt(input);
			if (number < 0) {
				System.out.println("음수를 입력할수 없습니다. 다시입력해주세요.");
				System.out.print(print);
				return checkInputScanner(sc.next(), print);
			} else
				return number;

		} else {
			System.out.println("올바른 형식이 아닙니다. 다시입력해주세요. (자리제한:10)");
			System.out.print(print);
			return checkInputScanner(sc.next(), print);
		}
	}

	// 숫자만 있는지 체크 숫자만 있으면 true, 없으면 false;
	public boolean isNumber(String str) {
		return str.matches("^\\d{0,10}");
	}

	// 주민등록 , 전번 체크
	public boolean isCheck(String s, int i) {
		String mc = "^\\d{" + i + "}";
		if (!(Pattern.matches(mc, s))) // 숫자만 있는지 체크
			return false;
		return true;
	}

	// 오늘 날짜 저장
	public void setDate() {
		// 오늘날짜
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		Date date = new Date();
		today = mSimpleDateFormat.format(date);
	}

	// 로그인시 번호입력
	public void inputLogin() {
		boolean check = true;

		while (check) {
			System.out.println("──도서관리 프로그램────────────────");
			System.out.println("  0.종료     1.로그인     2.회원가입    ");
			System.out.println("─────────────────────────────");
			System.out.print("───> ");
			int i = checkInputScanner(sc.next(), "───> ");

			switch (i) {
			case 0:
				// 종료
				System.out.println("프로그램을 종료 합니다.");
				check = false;
				break;
			case 1:
				// 로그인
				String c = Login();

				if (c.equals("")) { // 시도횟수 초과시
					System.out.println("시도 가능 횟수를 초과했습니다.");
					break;
				}

				// 오늘날짜저장
				setDate();

				if (c.equals("관리자")) {
					System.out.println("──관리자 로그인─────────────────");
					System.out.println(" 접속날짜:" + today + " ");
					System.out.println("───────────────────────────");
					adminLogin();
				}
				if (c.equals("사용자")) {
					System.out.println("──사용자 로그인────────────────");
					System.out.println(" 접속날짜:" + today + " ");
					System.out.println("───────────────────────────");
					userLogin();
				}

				// 로그아웃 시 saveBookList 초기화
				l_info.saveBookList.clear();
				// check = false;
				break;
			case 2:
				// 회원가입
				memberShip();
				break;
			default:
				System.out.println("없는 번호입니다. 다시 입력해주세요.");
			}
		}
	}

	public String memberChcek(String q, String type) {
		System.out.print(q);
		String returnValue = sc.next();
		// id만 체크
		if (type == "id") {
			if (user.id_Check(user.user_List, returnValue)) // 아이디가 있으면 리턴 ""
				return "";
		} else if (type == "date") {
			if (!(isCheck(returnValue, 6))) {
				System.out.println("형식이 맞지 않습니다. 다시 입력해주세요.");
				return memberChcek("생년월일을 입력하세요 (ex:910101)  : ", "date");
			}
		} else if (type == "phone") {
			if (!(isCheck(returnValue, 11))) {
				System.out.println("형식이 맞지 않습니다. 다시 입력해주세요.");
				return memberChcek("폰번호를 입력하세요(ex:01012341234) : ", "phone");
			}
		}

		return returnValue;
	}

	// 회원가입
	public void memberShip() {
		String id;
		while (true) {
			id = memberChcek("아이디를 입력하세요 : ", "id");
			if (!(id.equals("")))// 아이디가 없으면 중지
				break;

			System.out.println("중복되는 아이디가 있습니다.");
		}

		String pw = memberChcek("비밀번호를 입력하세요 : ", "pw");
		String name = memberChcek("이름을 입력하세요 : ", "name");
		String date = memberChcek("생년월일을 입력하세요 (ex:910101)  : ", "date");
		String phone = memberChcek("폰번호를 입력하세요(ex:01012341234) : ", "phone");

		user.user_Add(new String[] { id, pw, name, date, "0", phone });

		System.out.println("회원 가입 성공 !");
	}

	// 로그인
	public String Login() {
		boolean check = true;
		String id = null;
		String pw = null;

		int c = 3;
		while (check) {
			if (c == 0) {
				return "";
			}

			System.out.print("아이디를 입력하세요. 시도 가능 횟수(" + c + ") : ");
			id = sc.next();
			if (user.id_Check(user.user_List, id))
				check = false;
			else {
				System.out.println("없는 아이디 입니다.");
				c--;
			}
		}

		c = 3;
		check = true;
		while (check) {
			if (c == 0) {
				return "";
			}
			System.out.print("비밀번호를 입력하세요. 시도 가능 횟수(" + c + ") : ");
			pw = sc.next();
			if (user.pw_Check(user.user_List, pw))
				check = false;
			else {
				System.out.println("비밀번호가 다릅니다.");
				c--;
			}
		}

		// 관리자 로그인 체크
		if (user.admin_Check(id, pw)) {
			System.out.println("관리자로 로그인 하셧습니다.");
			return "관리자";
		} else {
			System.out.println("사용자로 로그인 하셧습니다.");
			return "사용자";
		}
	}

	// 관리자모드 번호입력
	public void adminLogin() {
		boolean check = true;

		String[] userArr = user.getArr();
		while (check) {
			System.out.println("──관리자 기능─────────────────────────────────────────────────────────────────");
			System.out.println(" 0.로그아웃     1.회원목록     2.도서목록     3.도서검색     4.도서추가     5.도서수정     6.도서삭제 ");
			System.out.println("──────────────────────────────────────────────────────────────────────────");
			System.out.print("───> ");
			int i = checkInputScanner(sc.next(), "───> ");

			switch (i) {
			case 0:
				// 종료
				check = false;
				break;
			case 1: // 회원목록
				user.user_InfoAll();
				break;
			case 2: // 도서목록
				l_info.getBook_List();
				break;
			case 3: // 도서검색
				l_info.book_Search();
				break;
			case 4: // 도서추가
				l_info.book_Add();
				break;
			case 5: // 도서수정
				l_info.getBook_List();
				System.out.print("수정할 코드 번호를 입력하세요 : ");
				int code = checkInputScanner(sc.next(), "───> ");
				l_info.book_Setting(String.valueOf(code));

				break;
			case 6: // 도서삭제
				l_info.getBook_List();
				System.out.print("삭제할 코드 번호를 입력하세요 : ");
				int code1 = checkInputScanner(sc.next(), "───> ");
				l_info.book_Delete(String.valueOf(code1));

				break;
			default:
				System.out.println("없는 번호입니다. 다시 입력해주세요.");
			}
		}
	}

	// 사용자모드 번호입력
	public void userLogin() {
		boolean check = true;
		String[] userArr = user.getArr();
		while (check) {
			System.out.println("──사용자 기능──────────────────────────────────────────────────────");
			System.out.println("  0.로그아웃     1.대여     2.반납     3.도서검색     4.도서목록     5.회원정보 ");
			System.out.println("───────────────────────────────────────────────────────────────");
			System.out.print("───> ");
			int i = checkInputScanner(sc.next(), "───> ");

			switch (i) {
			case 0:
				// 종료
				check = false;
				break;
			case 1: // 대여
				
				//3권 이상 대여 불가능
				if(Integer.parseInt(userArr[3]) >= 3){
					System.out.println("3권 이상 대여를 할 수 없습니다. 반납 후 진행해 주세요!\n");
					break;
				}else{
					System.out.println("[ 대여가능 수 : "+ (3 - Integer.parseInt(userArr[3])) +"권  ]");
				}
				
				// 전에 검색한 자료가 있을경우 전검색결과 보여주기
				if (l_info.saveBookList.size() != 0)
					l_info.printSerchBookList();
				else
					l_info.getBook_List();

				boolean ck = false;
				while (true) {
					System.out.print("대여할 코드를 입력하세요.(Exit : 1004) : ");
					int code = checkInputScanner(sc.next(), "대여할 코드를 입력하세요 : ");

					if (code == 1004) {
						System.out.println("대여 기능에서 종료합니다.");
						l_info.saveBookList.clear();// 북리스트 클리어
						break;
					}

					ck = l_info.book_Rental(String.valueOf(code), userArr[0], today);

					if (ck)
						break;
				}

				if (ck) {// 유저의 대여수량 변경
					user.setRantal("" + (Integer.parseInt(userArr[3]) + 1));
					userArr = user.getArr(); // 갱신

					// 대여시에 saveBookList 초기화
					l_info.saveBookList.clear();
				}

				break;

			case 2: // 반납
				if (l_info.booklistCheck(userArr[0])) {

					String ck1 = "";

					while (true) {
						System.out.print("반납할 코드를 입력하세요.(Exit : 1004) : ");
						int code1 = checkInputScanner(sc.next(), "반납할 코드를 입력하세요 : ");

						if (code1 == 1004) {
							System.out.println("반납 기능에서 종료합니다.");
							break;
						}

						ck1 = l_info.return_Book(String.valueOf(code1), userArr[0], today);

						if (ck1.equals("완료") || ck1.equals(""))
							break;
					}

					if (ck1.equals("완료")) {// 유저의 대여수량 변경
						user.setRantal("" + (Integer.parseInt(userArr[3]) - 1));
						userArr = user.getArr(); // 갱신
					}

				}
				break;
			case 3: // 도서검색
				l_info.book_Search();
				break;
			case 4: // 도서목록
				l_info.getBook_List();
				break;
			case 5: // 회원정보
				if (inputMember()) {
					check = false; // 회원탈퇴시 프로그램 종료
				}
				break;
			default:
				System.out.println("없는 번호입니다. 다시 입력해주세요.");
			}
		}

	}

	// 회원 정보수정
	public boolean inputMember() {
		boolean exit = false;
		boolean check = true;
		String[] u = user.getArr();// 현재 회원 정보
		while (check) {
			System.out.println("──회원 정보──────────────────────────────────────────────────────────────────");
			System.out.println(" 0.사용자 기능으로     1.회원정보확인     2.회원정보수정    3.대여목록     4.회원탈퇴   ");
			System.out.println("──────────────────────────────────────────────────────────────────────────");
			System.out.print("───> ");
			int i = checkInputScanner(sc.next(), "───> ");

			switch (i) {
			case 0:
				// 종료
				check = false;
				break;
			case 1: // 회원정보 확인
				user.user_Info();
				break;
			case 2: // 회원정보수정
				setMember();
				break;
			case 3:// 대여목록
				l_info.booklistCheck(u[0]);
				break;
			case 4: // 회원탈퇴
				while (true) {
					System.out.println("정말 회원 탈퇴 하시겠습니까? (y/n)");
					System.out.print("───> ");
					String sw = sc.next();

					if (sw.equals("y") || sw.equals("Y")) {
						if (user.user_Delete()) {
							System.out.println(u[1] + "님 회원 탈퇴 되셧습니다.");
							check = false;
							exit = true; // 종료 시키기
						} else {
							System.out.println("현제 대여중인 책이 총 " + u[3] + " 권이 있습니다. 반납후 탈퇴해주세요.");
							l_info.booklistCheck(u[0]);
						}
						break;
					} else if (sw.equals("n") || sw.equals("N")) {
						System.out.println("회원 탈퇴를 취소하셧습니다.");
						break;
					} else {
						System.out.println("잘못 입력하였습니다.");
					}
				}
				break;

			default:
				System.out.println("없는 번호입니다. 다시 입력해주세요.");
			}
		}

		return exit;

	}

	// 자기 회원 정보 수정
	public void setMember() {
		String[] state = user.getArr();

		user.user_Info(); // 유져 정보

		String pw = memberChcek("변경 할 비밀번호를 입력하세요 : ", "pw");
		String name = memberChcek("변경 할 이름을 입력하세요 : ", "name");
		String date = memberChcek("변경 할 생년월일을 입력하세요 (ex:910101) : ", "date");
		String phone = memberChcek("변경 할 폰번호를 입력하세요(ex:01012341234) : ", "phone");

		user.user_Change(pw, name, date, phone);

		System.out.println("회원 정보 수정 성공 !");

	}
}
