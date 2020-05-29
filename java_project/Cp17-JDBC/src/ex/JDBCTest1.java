package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest1 {

	public static void main(String[] args){
		
		Connection conn = null;		// 지역변수는 초기화 해준다.
		
		
		// 1. DB 드라이버 로드.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Oracle 드라이버 로드 성공");
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pw = "tiger";
		
		// 2. 데이터베이스에 접속.
		try {
			conn = DriverManager.getConnection(url, user, pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("데이터베이스에 접속했습니다.");
		
		
		// 3. sql로 데이터 처리.
		
		
		// 4. close
		conn.close();
				
	
	
	
	}

}
