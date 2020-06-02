package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpManager {
	static Scanner sc = new Scanner(System.in);

	void empManger() {
		System.out.println("=============================");
		System.out.println("1.입력  2.수정  3.삭제  4.검색 5.전체정보");
		System.out.println("=============================");
		int num = sc.nextInt();
		sc.nextLine();
		switch (num) {
		case 1:
			insert();
			break;
		case 2:
			reset();
			break;
		case 3:
			delete();
			break;
		case 4:
			search();
			break;
		case 5:
			allDate();
			break;
		}
	}

	void insert() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);		// 데이터베이스로 연결한다.

			String sql = "insert into emp01 (empno, ename, job, mgr, hiredate, sal, comm, deptno ) "
					+ " values(?,?,?,?,sysdate,?,?,?)";
			System.out.println("========================");
			System.out.println("사원정보입력");
			System.out.println("========================");
			System.out.println("사원번호");
			int empno = sc.nextInt();
			sc.nextLine();

			System.out.println("사원이름");
			String name = sc.nextLine();

			System.out.println("직급");
			String job = sc.nextLine();

			System.out.println("관리자번호");
			int mgr = sc.nextInt();
			sc.nextLine();

			System.out.println("급여");
			int sal = sc.nextInt();
			sc.nextLine();

			System.out.println("보너스");
			int comm = sc.nextInt();
			sc.nextLine();

			System.out.println("부서번호");
			int deptno = sc.nextInt();
			sc.nextLine();

			pstmt = conn.prepareStatement(sql);		// 테이블의 데이터를 읽어온다.
			pstmt.setInt(1, empno);
			pstmt.setString(2, name);
			pstmt.setString(3, job);
			pstmt.setInt(4, mgr);
			pstmt.setInt(5, sal);
			pstmt.setInt(6, comm);
			pstmt.setInt(7, deptno);

			int resultCnt = pstmt.executeUpdate();

			System.out.println("=============================");
			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었숩니다.");
				System.out.println(resultCnt + "개 행이 입력되었습니다.");
			} else {
				System.out.println("입력이 되지 않았습니다.");
			}
			System.out.println("=============================");

			// 4. 데이터베이스 연결 종료

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	void reset() {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("========================");
			System.out.println("수정하실 정보의 사원번호를 입력해주세요");
			System.out.println("========================");
			int empno = sc.nextInt();
			sc.nextLine();
			String sql = "update emp31 set ename = ?, deptno = ?, sal = ? where empno = " + empno;

			System.out.println("수정정보입력");

			System.out.println("사원이름");
			String ename = sc.nextLine();

			System.out.println("부서번호");
			int deptno = sc.nextInt();
			sc.nextLine();

			System.out.println("급여");
			int sal = sc.nextInt();
			sc.nextLine();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			pstmt.setInt(2, deptno);
			pstmt.setInt(3, sal);

			int resultCnt = pstmt.executeUpdate();

			System.out.println("=============================");
			if (resultCnt > 0) {
				System.out.println("정상적으로 입력 되었숩니다.");
			} else {
				System.out.println("입력이 되지 않았습니다.");
			}
			System.out.println("=============================");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	void delete() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);

			String sql = "delete from emp31 where empno = ?";
			System.out.println("========================");
			System.out.println("삭제하실 사원번호입력");
			System.out.println("========================");
			
			int empno = sc.nextInt();
			sc.nextLine();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);

			int resultCnt = pstmt.executeUpdate();

			System.out.println("=============================");
			if (resultCnt > 0) {
				System.out.println("정상적으로 삭제 되었숩니다.");
			} else {
				System.out.println("삭제하실 정보가 없습니다.");
			}
			System.out.println("=============================");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	void search() {
		Connection conn = null;
		ResultSet rs = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			// 2. 데이터베이스에 접속
			conn = DriverManager.getConnection(url, user, pw);

			// 3. Statement : Connection
			Statement stmt = conn.createStatement();
			
			System.out.println("========================");
			System.out.println("회원의 이름을 입력해주세요");
			System.out.println("========================");
			
			String searchName = sc.nextLine();

			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp31" + " where ename = '"
					+ searchName + "'";

			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				System.out.print("사원번호" + "\t");
				System.out.print("이름" + "\t");
				System.out.print("직급" + "\t");
				System.out.print("관리자" + "\t");
				System.out.print("입사일" + "\t\t\t");
				System.out.print("급여" + "\t");
				System.out.print("보너스" + "\t");
				System.out.print("부서번호" + "\n");
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.print(rs.getInt(6) + "\t");
				System.out.print(rs.getInt(7) + "\t");
				System.out.print(rs.getInt(8) + "\n");
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	void allDate() {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";

			conn = DriverManager.getConnection(url, user, pw);

		
			System.out.println("========================");
			String sql = "select * from emp31";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			System.out.print("사원번호" + "\t");
			System.out.print("이름" + "\t");
			System.out.print("직급" + "\t");
			System.out.print("관리자" + "\t");
			System.out.print("입사일" + "\t\t\t");
			System.out.print("급여" + "\t");
			System.out.print("보너스" + "\t");
			System.out.print("부서번호" + "\n");
			while (rs.next()) {

				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.print(rs.getString(6) + "\t");
				System.out.print(rs.getString(7) + "\t");
				System.out.print(rs.getString(8) + "\n");
			}
			System.out.println("========================");
			rs.close();
			pstmt.close();
			// 4. close
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}