package com;

//로그인 정보
public class Login{
	public String id;
	public String name;
	public String rental;
	private String date;
	private String phone;
	private static final String ADMIN_ID = "admin"; //아이디 
	private static final String ADMIN_PW = "admin"; //비번
	public int idx; //로그인 체크된 idx
	
	// 아이디 확인 있음:true 없음:false
	public boolean id_Check(String[][] arr,String id) {
		for(int i = 0; i<arr.length;i++){
			String arr_ID = arr[i][0];
			
			if(id.equals(arr_ID)){
				this.idx = i; //id 체크된 거 저장
				return true;
			}
		}
		return false;
	}

	// 패스워드 확인
	public boolean pw_Check(String[][] arr, String pw) {
			int i = this.idx;
			String arr_PW = arr[i][1];
			
			if(pw.equals(arr_PW)){
				//값 저장
				this.id = arr[i][0];
				this.name = arr[i][2];
				this.date = arr[i][3];
				this.rental = arr[i][4];
				this.phone = arr[i][5];
				return true;
			}
		return false;
	}
	
	// 관리자인지 체크
	public boolean admin_Check(String id, String pw) {
		if(id.equals(ADMIN_ID) && pw.equals(ADMIN_PW))
			return true;
		
		return false;
	}
	
	// 로그인된 정보 뽑기
	public String[] getArr(){
		String[] arr = {id,name,date,rental,phone};
		return arr;
	}
	
	
	public void setArr(String name,String date,String phone){
		this.name = name;
		this.date = date;
		this.phone = phone;
	}
	
}
