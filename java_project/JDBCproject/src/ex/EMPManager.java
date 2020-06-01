package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class EMPManager {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println("Select Menu");
		System.out.println("----------------");
		System.out.println("1. EMP,  2. DEPT");
		System.out.println("----------------");
		
		int select = sc.nextInt();
		
		switch (select) {
		case 1:
			empManager();
			break;
		case 2:
			deptManager();
			break;
		}

	}

	private static void empManager() throws ClassNotFoundException, SQLException {
		System.out.println("EMP Manager Menu");
		System.out.println("=========================================");
		System.out.println("1. List  2. insert  3. search  4. delete ");
		System.out.println("=========================================");
		
		int select = sc.nextInt();
		
		
		
		switch (select) {
		case 1:
			System.out.println("전체 리스트 출력");
			empList();
			break;
		case 2:
			System.out.println("사원 정보를 입력합니다.");
			empInsert();
			break;
		case 3:
			System.out.println("사원을 검색합니다.");
			empSearch();
			
			break;
		case 4:
			System.out.println("사원을 삭제합니다.");
			empDelete();
			break;

		}
		
	}
	
	private static void empDelete() {
		// TODO Auto-generated method stub
		
	}

	private static void empList() throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from emp01";
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
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}

	
	private static void empInsert() {
		
		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		// 사용자 입력정보 변수
		System.out.println("사원 정보를 입력해주세요.");
		
		System.out.println("사원번호");
		int empno = sc.nextInt();
		System.out.println("사원이름");
		sc.nextLine();
		String ename = sc.nextLine();
		System.out.println("직급(업무)");
		String job = sc.nextLine();
		System.out.println("관리자");
		int mgr = sc.nextInt();
		System.out.println("입사일");
		sc.nextLine();
		String hiredate = sc.nextLine();
		System.out.println("급여");
		int sal = sc.nextInt();
		System.out.println("수당");
		int comm = sc.nextInt();
		System.out.println("부서번호");
		int deptno = sc.nextInt();
		
		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.		
		
		try {
			//0. 드라이버 LIB 추가
			//1. 데이터베이스 드라이버 로드
			//   Class.forName(드라이버 클래스 전체이름)
			//   Oracle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			
			
			//2. 데이터베이스 연결
			
			//String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// 주소 : localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			// Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);
			
			//3. SQL 처리
			//   Statement or PreparedStatement
			//   pstmt = conn.prepareStatement(SQL 문장)

			
			String sql = "insert into emp "
					+ " (empno, ename, job, mgr, hiredate, sal, comm, deptno) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, sal);
			pstmt.setInt(7, comm);
			pstmt.setInt(8, deptno);
			
			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt>0) {
				System.out.println("정상적으로 입력 되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지않았습니다. 확인후 재 시도해주세요.");
			}
			
			
			
			
			
			//4. 데이터베이스 연결 종료			
			//pstmt.close();
			//conn.close();
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {

			
			//4. 데이터베이스 연결 종료	
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
			
		}
		
		
		
		
	}
	
	private static void empSearch() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("검색하실 이름을 입력해주세요.");
		String searchName = sc.nextLine();
		
		String sql = "select * from emp01 where ename = ?";

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
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
		
		
	

	private static void deptManager() {
		// TODO Auto-generated method stub
		
	}

}