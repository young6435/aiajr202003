package com;

//회원정보
public class User extends Login {
	public static String[][] user_List; // 회원정보들
	public static int user_Count = 0; // 현제 회원 카운트
	private final int USER_LIST_LENGTH = 10; // 유저 가입 최대 수
	private final int USER_INFO_LENGTH = 6; // 회원정보들 수

	public User() {
		// 처음만 배열 생성
		if (user_List == null)
			user_List = new String[USER_LIST_LENGTH][USER_INFO_LENGTH];
	}

	// 회원가입
	public void user_Add(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			user_List[user_Count][i] = arr[i];
		}
		user_Count++;
	}

	// 회원 탈퇴
	public boolean user_Delete() {
		if (!(super.rental.equals("0")))
			return false;

		int idx = super.idx;
		for (int i = 0; i < user_List[idx].length; i++) {
			user_List[idx][i] = null;
		}
		return true;
	}

	// 회원 정보변경
	public void user_Change(String pw, String name, String date, String phone) {
		int idx = super.idx;
		String[] arr = { super.id, pw, name, date, super.rental, phone };
		user_List[idx] = arr; // 배열에 저장
		setArr(name, date, phone); // 현재상태에 저장
	}

	// 회원정보확인
	public String[] user_Info() {
		String[] arr = getArr();

		System.out.println("──현재 회원 정보──────────────────────────────────────────────────────────────────────────");
		System.out.println("   아이디:" + arr[0] + "    이름:" + arr[1] + "    생일:" + arr[2] + "    대여수량:" + arr[3]
				+ "    폰번호:" + arr[4] + "  ");
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────");

		return arr;
	}

	// 모든회원정보확인
	public void user_InfoAll() {
		System.out.println("──현재 회원 정보────────────────────────────────────────────────────────────────────");
		for (int i = 0; i < user_List.length; i++) {
			if (user_List[i][0] == null)
				continue;

			System.out.println("   아이디:" + user_List[i][0] + "       이름:" + user_List[i][2] + "       생일:"
					+ user_List[i][3] + "       대여수량:" + user_List[i][4] + "      폰번호:" + user_List[i][5] + "  ");
		}
		System.out.println("───────────────────────────────────────────────────────────────────────────────");
	}

	// 렌탈 정보 수정
	public void setRantal(String rental) {
		this.rental = rental;
		user_List[super.idx][4] = rental;
	}

	@Override
	public boolean id_Check(String[][] arr, String id) {
		// TODO Auto-generated method stub
		return super.id_Check(arr, id);
	}

	@Override
	public boolean pw_Check(String[][] arr, String pw) {
		// TODO Auto-generated method stub
		return super.pw_Check(arr, pw);
	}

	@Override
	public boolean admin_Check(String id, String pw) {
		// TODO Auto-generated method stub
		return super.admin_Check(id, pw);
	}

	@Override
	public String[] getArr() {
		// TODO Auto-generated method stub
		return super.getArr();
	}
}
