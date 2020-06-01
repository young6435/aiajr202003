package ex2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpService {
//		1. 사원관리 프로그램
//		기능
//			입력(all), 
//			수정(요청:사원번호)(이름,부서,급여), 
//			삭제(사원번호기준), 
//			리스트, 
//			검색(이름)

	
	
	
	Scanner sc = new Scanner(System.in);
	int selectNum = 0;

	// 테이블 복사부터 하고 시작함.

//				String sql = "create table emp10 as select * from emp";
//				pstmt = conn.prepareStatement(sql);
//				
//				//실행이 정상적으로 되면 false를 반환
//				boolean rs = pstmt.execute();

//				if(rs=false) 
//					System.out.println("테이블이 성공적으로 복사되었습니다.");

	// EMP 테이블 입력(all)

	public void createEmp() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		

		// 1. 데이터베이스 접속
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

		
		System.out.println("사원번호를 입력하세요.");
		int empno = sc.nextInt();
		sc.nextLine();

		System.out.println("사원이름을 입력하세요.");
		String ename = sc.nextLine();

		System.out.println("직급을 입력해주세요");
		String job = sc.nextLine();

		System.out.println("사수의 사원번호를 입력하세요.");
		int mgr = sc.nextInt();
		sc.nextLine();

		// 입사일 생성
		Date hireDate = new Date(new java.util.Date().getTime());
		System.out.println("월급을 입력하세요.");
		int sal = sc.nextInt();
		sc.nextLine();
		System.out.println("성과급을 입력하세요.");
		int comm = sc.nextInt();
		sc.nextLine();
		System.out.println("부서번호를 입력하세요.");
		int deptno = sc.nextInt();
		sc.nextLine();

		String sql = "insert into emp11 values(?, ?, ?, ?, ?, ?, ?, ?)";

		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, empno);
		pstmt.setString(2, ename);
		pstmt.setString(3, job);
		pstmt.setInt(4, mgr);
		pstmt.setDate(5, hireDate);
		pstmt.setInt(6, sal);
		pstmt.setInt(7, comm);
		pstmt.setInt(8, deptno);

		int rs = pstmt.executeUpdate();

		System.out.println(rs + "개 행이 입력 되었습니다.");
		
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}

	// 수정(요청:사원번호)(이름,부서,급여)

	public void updateEmp() throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// 1. 드라이버 로드
		

		// 1. 데이터베이스 접속
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		
		
		System.out.println("사원번호를 입력해주세요.");
		int empno = sc.nextInt();
		sc.nextLine();

		System.out.println("변경하실 컬럼을 선택하세요 \n 1.이름 | 1.부서 | 3.급여");
		selectNum = sc.nextInt();
		sc.nextLine();

		switch (selectNum) {

		case 1:
			String sql = "update emp11 set ename = ? where empno = ? ";
			pstmt = conn.prepareStatement(sql);
			System.out.println("변경하실 이름을 입력해주세요.");
			String ename = sc.nextLine();

			pstmt.setString(1, ename);
			pstmt.setInt(2, empno);

			int count = pstmt.executeUpdate();

			if (count > 0)
				System.out.println("수정이 완료 되었습니다.");
			
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

			break;
		case 2:
			sql = "update emp11 set deptno = ? where empno = ? ";
			pstmt = conn.prepareStatement(sql);
			System.out.println("변경하실 부서번호를 입력해주세요.");
			int deptno = sc.nextInt();
			sc.nextLine();

			pstmt.setInt(1, deptno);
			pstmt.setInt(2, empno);

			count = pstmt.executeUpdate();

			if (count > 0)
				System.out.println("수정이 완료 되었습니다.");
			
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

			break;

		case 3:
			sql = "update emp11 set sal = ? where empno = ? ";
			pstmt = conn.prepareStatement(sql);
			System.out.println("변경하실 급여를 입력해주세요.");
			int sal = sc.nextInt();
			sc.nextLine();

			pstmt.setInt(1, sal);
			pstmt.setInt(2, empno);

			count = pstmt.executeUpdate();

			if (count > 0)
				System.out.println("수정이 완료 되었습니다.");
			
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

			break;
		}
	}

	// delete

	public void deleteEmp() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		

		// 1. 데이터베이스 접속
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		
		
		System.out.println("삭제하실 사원번호를 입력해주세요.");
		int empno = sc.nextInt();
		sc.nextLine();

		String sql = "delete from emp11 where empno = ? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empno);

		int count = pstmt.executeUpdate();

		if (count > 0)
			System.out.println("삭제가 완료 되었습니다.");
		
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}

	// EMP 테이블의 모든 데이터를 출력
	public void listEmp() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		

		// 1. 데이터베이스 접속
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

		String sql = "select * from emp10";
		pstmt = conn.prepareStatement(sql);

		rs = pstmt.executeQuery(sql);

		while (rs.next()) {
			int empno = rs.getInt(1);
			String ename = rs.getString(2);
			String job = rs.getString(3);
			int mgr = rs.getInt(4);
			Date hireDate = rs.getDate(5);
			int sal = rs.getInt(6);
			int comm = rs.getInt(7);
			int deptno = rs.getInt(8);

			System.out.println(empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hireDate + "\t" + sal + "\t"
					+ comm + "\t" + deptno);
		}
		
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}

	// 검색
	public void searchEmp() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		

		// 1. 데이터베이스 접속
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		
		System.out.println("검색하실 이름을 입력해주세요.");
		String searchName = sc.nextLine();
		
		String sql = "select * from emp10 where ename = ?";

		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, searchName);
		
		rs = pstmt.executeQuery(sql);

		System.out.println(searchName + "님의 정보입니다.");

		while (rs.next()) {
			int empno = rs.getInt(1);
			String ename = rs.getString(2);
			String job = rs.getString(3);
			int mgr = rs.getInt(4);
			Date hireDate = rs.getDate(5);
			int sal = rs.getInt(6);
			int comm = rs.getInt(7);
			int deptno = rs.getInt(8);

			System.out.println(empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hireDate + "\t" + sal + "\t"
					+ comm + "\t" + deptno);
		}
		
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}
}