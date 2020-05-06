package com;

import java.util.ArrayList;
import java.util.Scanner;

//도서관 정보
public class Library_Info {
	public static String[][] booklist; // 도서 목록들
	private final int BOOK_LIST_LENGTH = 40; // 도서 가입 최대 수
	private final int BOOK_INFO_LENGTH = 6; // 도서정보들 수
	public static int bookCount = 0;
	public static ArrayList<String[]> saveBookList = new ArrayList<String[]>(); // 북
																				// 검색시
																				// 저장할
																				// 것

	Scanner sc = new Scanner(System.in);

	// 생성자
	public Library_Info() {
		// 처음만 배열 생성
		if (booklist == null)
			booklist = new String[BOOK_LIST_LENGTH][BOOK_INFO_LENGTH];

	}

	// 도서관입장정보(보류)
	public void entrance_Info() {
	}

	// 도서목록
	public void getBook_List() {
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("대여상태\t\t책제목\t\t대여날짜\t\t저자\t\t출판사\t\t고유번호");
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────");
		for (int i = 0; i < BOOK_LIST_LENGTH; i++) {
			for (int j = 0; j < BOOK_INFO_LENGTH; j++) {
				if (booklist[i][0] == null)
					continue;

				if (booklist[i][j] != null) {

					if (j == 2)
						System.out.print(booklist[i][j] + "\t");
					else {
						System.out.print(splitString(booklist[i][j]));
					}
					if (j == BOOK_INFO_LENGTH - 1)
						System.out.println();
				} else {
					System.out.print("\t\t");
				}
			}

		}
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────");
	}

	// 현재 사용자가 대출한 목록
	public boolean booklistCheck(String id) {

		int count = 0;
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("대여상태\t\t책제목\t\t대여날짜\t\t저자\t\t출판사\t\t고유번호");
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────");
		for (int i = 0; i < booklist.length; i++) {
			if (booklist[i][0] == id) // 각행의 0번째 인덱스를 확인해서 고객의 아이디가 입력되어 있는경우
			{
				count++;

				for (int j = 0; j < booklist[i].length; j++) {
					if (!(j == 2))
						System.out.print(splitString(booklist[i][j]));
					else
						System.out.print(booklist[i][j] + "\t");
				}
				System.out.println();

			} else {
				if (i + 1 == booklist.length) // 이때 3은 배열'행'의 길이
				{
					if (count == 0) {
						System.out.println(id + "님은 현재 대여중인 책이 없습니다");
						return false;
					}
				}
			}

		}
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────");
		return true;
	}

	// 대여
	public boolean book_Rental(String code, String id, String date) {
		LABEL: while (true) {
			for (int i = 0; i < booklist.length; i++) {
				if (Integer.parseInt(code) >= bookCount) {
					System.out.println("코드번호가 잘못 되었습니다.");
					return false;
				}

				if (booklist[i][5].equals(code)) {

					if (booklist[i][0].equals("대여가능")) {
						boolean a = true;
						while (a) {

							System.out.println("대여가능합니다. 대여하시겠습니까? (y/n)");
							String choice = sc.next();

							if (choice.equals("y") || choice.equals("Y")) {
								booklist[i][0] = id;
								booklist[i][2] = date;
								System.out.println("도서대여가 완료되었습니다");
								return true; // 상위메뉴로 리턴
							} else if (choice.equals("n") || choice.equals("N")) {
								System.out.println("도서대여가 취소되었습니다");
								return false; // 상위메뉴로 리턴
							} else {
								System.out.println("잘못 입력하였습니다");

							}
						}

					} else {
						System.out.println("이미 대여중인 책입니다");
						break LABEL;
					}
				}

			} // switch문 끝

		} // while문 끝
		return false;
	}

	// 반납
	public String return_Book(String code, String id, String t) {
		int today = Integer.parseInt(t);
		int gap; // 반납날짜-대여날짜
		int num; // 1.도서코드로 반납 2.상위메뉴(도서코드 모르거나 반납일 다시설정하기 원하는 경우)

		LABEL: while (true) {
			for (int i = 0; i < booklist.length; i++) {
				if (Integer.parseInt(code) >= bookCount) {
					System.out.println("코드번호가 잘못 되었습니다.");
					return "취소";
				}

				if (booklist[i][5].equals(code)) {
					if (booklist[i][0] == id) {
						gap = today - Integer.valueOf(booklist[i][2]);

						if (gap >= 0 && gap <= 4) // 대여한지 5일차까지 반납했을시
						{
							System.out.println("연체료는 없습니다. 반납하시겠습니까?  (y/n)");
							String choice = sc.next();
							if (choice.equals("y") || choice.equals("Y")) {
								booklist[i][0] = "대여가능";
								booklist[i][2] = null;
								System.out.println("도서반납이 완료되었습니다");
								return "완료";
							} else if (choice.equals("n") || choice.equals("N")) {
								System.out.println("도서반납이 취소되었습니다");
								return "취소";
							}

							else {
								System.out.println("잘못 입력하였습니다");
								i--;
								continue;
							}
						} else if (gap <= 7) // 대여한지 8일차까지
						{
							System.out.println("연체료는 500원입니다. 반납하시겠습니까?  (y/n)");
							String choice = sc.next();
							if (choice.equals("y") || choice.equals("Y")) {
								booklist[i][0] = "대여가능";
								booklist[i][2] = null;
								System.out.println("도서반납이 완료되었습니다");
								return "완료";
							} else if (choice.equals("n") || choice.equals("N")) {
								System.out.println("도서반납이 취소되었습니다");
								return "취소";
							}

							else {
								System.out.println("잘못 입력하였습니다");
								i--;
								continue;
							}
						}

						else if (gap <= 10) // 대여한지 11일차까지
						{
							System.out.println("연체료는 700원입니다. 반납하시겠습니까?  (y/n)");
							String choice = sc.next();
							if (choice.equals("y") || choice.equals("Y")) {
								booklist[i][0] = "대여가능";
								booklist[i][2] = null;
								System.out.println("도서반납이 완료되었습니다");
								return "완료";
							} else if (choice.equals("n") || choice.equals("N")) {
								System.out.println("도서반납이 취소되었습니다");
								return "취소";
							}

							else {
								System.out.println("잘못 입력하였습니다");
								i--;
								continue;
							}
						} else if (gap > 10) // 대여한지 12일차이상
						{
							System.out.println("연체료는 1000원입니다. 반납하시겠습니까? (y/n)");
							String choice = sc.next();
							if (choice.equals("y") || choice.equals("Y")) {
								booklist[i][0] = "대여가능";
								booklist[i][2] = null;
								System.out.println("도서반납이 완료되었습니다");
								return "완료";
							} else if (choice.equals("n") || choice.equals("N")) {
								System.out.println("도서반납이 취소되었습니다");
								return "취소";
							}

							else {
								System.out.println("잘못 입력하였습니다");
								i--;
								continue;
							}
						}
					} else // booklist[i][0] == "대여가능"인 경우
					{
						System.out.println("반납가능한 책이 아닙니다. 도서코드 재확인바랍니다");
						return "실패";// 도서검색 메뉴로 리턴
					}
				}
			} // for문 끝
		} // while문 끝
	}

	// 도서추가 - 처음 배열 추가용
	public void book_Add(String[] arr) {
		for (int i = 0; i < BOOK_INFO_LENGTH; i++) {
			booklist[bookCount][i] = arr[i];
		}
		bookCount++;
	}

	// 도서추가
	public void book_Add() {
		int j = 0;
		int o = 0;
		int q = 0;
		int k = 0;
		boolean yup = true;

		while (yup) {
			for (o = 0; o < BOOK_LIST_LENGTH; o++) {
				for (q = 0; q < BOOK_INFO_LENGTH; q++) {
					if (booklist[o][q] != null) {
						yup = false;
						k = o + 1;
					}
				}
			}
		}

		for (int p = k; p < k + 1; p++) {
			for (j = 0; j < BOOK_INFO_LENGTH; j++) {
				if (j == 0) {
					booklist[p][j] = "대여가능";
				}
				if (j == 1) {
					System.out.println("책제목 :");
					booklist[p][j] = sc.next();
				}
				if (j == 2) {
					booklist[p][j] = null;
				}
				if (j == 3) {
					System.out.println("저자 :");
					booklist[p][j] = sc.next();
				}
				if (j == 4) {
					System.out.println("출판사 :");
					booklist[p][j] = sc.next();
				}
				if (j == 5) {
					booklist[p][j] = String.valueOf(bookCount);
				}
			}
		}
		bookCount++;
	}

	// 도서수정
	public void book_Setting(String code) {
		
		String goyu = code;
		int i;
		boolean check = false;
		String[] state = { "대여상태", "책제목", "날짜", "저자", "출판사" };
		for (i = 0; i < BOOK_LIST_LENGTH; i++) {
			if(booklist[i][0] == null)
				continue;
				
			if (booklist[i][5].equals(goyu)) {
				for (int y = 0; y < BOOK_INFO_LENGTH; y++) {
					if (y == 0 || y == 2 || y == BOOK_INFO_LENGTH - 1)
						continue;

					System.out.println("[ " + state[y] + " ]");
					System.out.print(booklist[i][y] + " ──> ");
					booklist[i][y] = sc.next();
				}
				check = true;
				break;
			}
		}
		if(!check)
			System.out.println("해당 코드번호를 가지고 있는 도서가 없습니다.");
		else
			System.out.println("[ 코드번호 : " + code + " ]의 도서 수정을 성공적으로 완료 하였습니다.");
	}

	// 도서삭제
	public void book_Delete(String code) {
		String goyu = code;
		boolean check = false;
		for (int i = 0; i < BOOK_LIST_LENGTH; i++) {
			if(booklist[i][0] == null)
				continue;
			
			if (booklist[i][5].equals(goyu)) {
				for (int y = 0; y < BOOK_INFO_LENGTH; y++) {
					booklist[i][y] = null;
				}
				check = true;
				break;
			}
		}
		
		if(!check)
			System.out.println("해당 코드번호를 가지고 있는 도서가 없습니다.");
		else
			System.out.println("[ 코드번호 : " + code + " ]의 도서가 삭제되었습니다.");
	}

	// 도서검색
	public void book_Search() {
		String code;
		int num; // 검색방법 1.도서코드 2.책이름

		LABEL: while (true) {
			System.out.println("──회원 정보────────────────────────────────────────");
			System.out.println(" 1.도서코드로 검색      2.키워드로 검색      3.사용자기능 메뉴 ");
			System.out.println("────────────────────────────────────────────────");
			System.out.print("───> ");
			num = checkInputScanner(sc.next());

			switch (num) {
			case 1: // 도서코드로 검색한 경우
				while (true) {
					System.out.print("도서코드를 입력하세요.(exit:1004) : ");
					code = ""+checkInputScanner(sc.next());
					
					if(code.equals("1004")){
						System.out.println("도서코드기능에서 종료합니다.");
						continue LABEL;
					}
					
					saveBookList.clear();// 북리스트 클리어

					for (int i = 0; i < booklist.length; i++) {
						if (Integer.parseInt(code) >= bookCount) {
							System.out.println("코드번호가 잘못 되었습니다.");
							break;
						}
						if (booklist[i][5].equals(code)) {
							// 검색된 북리스트 저장
							saveBookList.add(booklist[i]);

							System.out.println(
									"───────────────────────────────────────────────────────────────────────────────────────────────────");
							System.out.println("대여상태\t\t책제목\t\t대여날짜\t\t저자\t\t출판사\t\t고유번호");
							System.out.println(
									"───────────────────────────────────────────────────────────────────────────────────────────────────");
							for (int j = 0; j < booklist[i].length; j++) {
								if (booklist[i][j] != null) {
									if (!(j == 2))
										System.out.print(splitString(booklist[i][j]));
									else
										System.out.print(booklist[i][j] + "\t");
								} else
									System.out.print("\t\t");
							}
							System.out.println();
							System.out.println(
									"───────────────────────────────────────────────────────────────────────────────────────────────────");
							break LABEL;
						}
					}
				}
			case 2: // 책이름으로 검색한 경우
				int count1 = 0; // 메뉴출력 (1회만)
				int noname = 0;

				System.out.print("키워드를 입력하세요.(exit:1004) : ");
				String name = sc.next();
				
				if(name.equals("1004")){
					System.out.println("키워드검색기능에서 종료합니다.");
					continue LABEL;
				}
				
				
				saveBookList.clear();// 북리스트 클리어

				for (int i = 0; i < booklist.length; i++) {
					if (booklist[i][1] == null) {
						noname++;
						continue;
					}

					if (booklist[i][1].contains(name)) {
						// 검색된 북리스트 저장
						saveBookList.add(booklist[i]);

						if (count1 == 0) {
							System.out.println(
									"───────────────────────────────────────────────────────────────────────────────────────────────────");
							System.out.println("대여상태\t\t책제목\t\t대여날짜\t\t저자\t\t출판사\t\t고유번호");
							System.out.println(
									"───────────────────────────────────────────────────────────────────────────────────────────────────");
							count1++;
						}

						for (int j = 0; j < booklist[i].length; j++) {
							if (booklist[i][j] != null) {
								if (!(j == 2))
									System.out.print(splitString(booklist[i][j]));
								else
									System.out.print(booklist[i][j] + "\t");
							} else
								System.out.print("\t\t");
						}
						System.out.println();
					} else {
						noname++;
					}
				}

				if (noname == booklist.length) {
					System.out.println("검색되는 도서가 없습니다");
					continue LABEL;
				}
				System.out.println(
						"───────────────────────────────────────────────────────────────────────────────────────────────────");
				break LABEL;
			case 3: // 상위메뉴로 가길 원하는 경우
				return;

			default:
				System.out.println("번호를 잘못 입력하였습니다.");

			}
		}
	}

	public void printSerchBookList() {
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("대여상태\t\t책제목\t\t대여날짜\t\t저자\t\t출판사\t\t고유번호");
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────");
		for (int j = 0; j < saveBookList.size(); j++) {
			for (int i = 0; i < saveBookList.get(j).length; i++) {
				if (saveBookList.get(j)[i] != null) {
					if (!(i == 2))
						System.out.print(splitString(saveBookList.get(j)[i]));
					else
						System.out.print(saveBookList.get(j)[i] + "\t");
				} else
					System.out.print("\t\t");
			}
			System.out.println("");
		}
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────");
	}

	// 문자 ?자리 이상이면 잘르기 문자수 sp+2개수로 마추기
	public String splitString(String s) {
		int sp = 25; // 자를 수
		String returnValue = ""; // 리턴할
		byte[] temp = s.getBytes();

		int length = temp.length; // 문자 자리

		if (length > sp) {
			if (s.length() > 12)
				returnValue = s.substring(0, 12) + "…\t";
			else
				returnValue = s + "\t";
		} else {
			if (length < 18)
				returnValue = s + "\t\t";
			else
				returnValue = s + "\t";
		}
		return returnValue;
	}

	// 스캐너 받은걸 int형으로 바꺼서 내보냄 한글 특수문자 걸르기!!
	public int checkInputScanner(String input) {
		if (isNumber(input)) { // 숫자만 있으면
			return Integer.parseInt(input);
		} else {
			System.out.println("올바른 형식이 아닙니다. 다시입력해주세요.");
			System.out.print("───> ");
			return checkInputScanner(sc.next());
		}
	}

	// 숫자만 있는지 체크 숫자만 있으면 true, 없으면 false;
	public boolean isNumber(String str) {
		return str.matches("^[0-9]*$");
	}

	// 이체 날짜 검사 (년,월,일 체크)
	public void overdue_Calculate() {
	}

	// 대여된 책인지? 책이있는지? 삭제된 책인지? 책 정보 상태 체크
	public void Book_Check() {
	}

}
