package manager;

import java.util.List;

public class DEPTManager {
	
	DeptDao dao = new DeptDao();		// "의존한다" 라고 표현

	/////////////////////////////////////////////////////////////////
	// DEPT MANAGER
	/////////////////////////////////////////////////////////////////

	 public void deptManager() {

		System.out.println("DEPT Manager Menu");
		System.out.println("=========================================");
		System.out.println("1. List  2. Insert  3. Search  4. Delete  5. Edit  ");
		System.out.println("=========================================");

		int select = ManageMain.sc.nextInt();

		switch (select) {
		case 1:
			System.out.println("전체 리스트 출력");
			deptList();
			break;
		case 2:
			System.out.println("부서 정보를 입력합니다.");
			//deptInsert(); 사용자의 입력데이터를 dept 객체에 담아서 dao에 있는 insert 메소드로 전달한다.
			break;
		case 3:
			System.out.println("부서 정보를 검색합니다.");
			//deptSearch();	사용자가 입력한 이름을 dao에 search 쪽으로 전달한다.
			break;
		case 4:
			System.out.println("부서 정보를 삭제합니다.");	// 보통 삭제는 pk 대상.
			//deptDelete();	삭제하고싶은 이름(이건 위험하다) or 부서번호 를 dao에 delete 쪽으로 전달한다.
 			break;
		case 5:
			System.out.println("부서 정보를 수정합니다.");
			//deptEdit();
			break;

		}

	}
	 
	 
	public void deptSearch() {
		
		// 사용자 입력정보 변수

		System.out.println("검색하고자 하는 부서이름 : ");
		ManageMain.sc.nextLine();
		String searchName = ManageMain.sc.nextLine();
	
	}
	 
	public void deptList() {
		
		List<Dept> deptList = dao.deptList();
		
		if(deptList!=null && !deptList.isEmpty()) {
			
			for(int i=0; i<deptList.size(); i++) {
				System.out.printf("%5s", deptList.get(i).getDeptno()+"\t");
				System.out.printf("%12s", deptList.get(i).getDname()+"\t");
				System.out.printf("%12s", deptList.get(i).getLoc()+"\n");
			}
		} else {
			System.out.println("입력된 데이터가 없습니다.");
		}
		
	}

}