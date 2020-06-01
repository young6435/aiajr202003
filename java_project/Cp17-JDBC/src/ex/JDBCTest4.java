package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest4 {

	public static void main(String[] args){
		
		Connection conn = null;
		Statement stmt = null;
		
		
		try {
			
			//1. DB 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Oracle 드라이버 로드 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			//2. 데이터베이스에 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스에 접속했습니다.");

			
			//3. Statement
			
			stmt = conn.createStatement();
			
			String sql = "insert into dept (deptno, dname, loc) "
					+ " values (60, 'design', 'jeju')";
			
			int resultCnt = stmt.executeUpdate(sql);		// 실행횟수를 반환한다.
			
			System.out.println(resultCnt + "개 행이 입력되었습니다.");
			
			
			

			//4. close
			conn.close();		//close 안하면, 객체가 남아있어서 성능저하 온다.
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			

			e.printStackTrace();
		}
		
		
		
	}

}
