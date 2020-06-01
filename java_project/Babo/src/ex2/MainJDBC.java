package ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MainJDBC {

	public static void main(String[] args) {
//		1. 사원관리 프로그램
//		기능
//			입력(all), 
//			수정(요청:사원번호)(이름,부서,급여), 
//			삭제(사원번호기준), 
//			리스트, 
//			검색(이름)

		
		Scanner sc = new Scanner(System.in);
		int selectNum = 0;

		DeptService dService = new DeptService();
		EmpService eService = new EmpService();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			while (true) {
				
				System.out.println("관리 프로그램입니다.");
				System.out.println("1. 사원관리 | 2.부서관리");
				selectNum = sc.nextInt();

				switch (selectNum) {
				case 1:
					System.out.println("사원관리페이지입니다. 필요하신 요청을 선택하세요.");
					System.out.println("1. 입력 | 2. 수정 | 3. 삭제 | 4.리스트 | 5.검색");
					selectNum = sc.nextInt();
					sc.nextLine();
					switch (selectNum) {

					case 1:
						eService.createEmp();
						break;
					case 2:
						eService.updateEmp();
						break;
					case 3:
						eService.deleteEmp();
						break;
					case 4:
						eService.listEmp();
						break;
					case 5:
						eService.searchEmp();
						break;

					}
					break;
				case 2:
					System.out.println("부서관리페이지입니다. 필요하신 요청을 선택하세요.");
					System.out.println("1. 입력 | 2. 수정 | 3. 삭제 | 4.리스트 | 5.검색");
					selectNum = sc.nextInt();
					sc.nextLine();
					
					switch (selectNum) {
					
					case 1:
						dService.createDept();
						break;
					case 2:
						dService.updateDept();
						break;
					case 3:
						dService.deleteDept();
						break;
					case 4:
						dService.listDept();
						break;
					case 5:
						dService.searchDept();
						break;
					}
					break;
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}