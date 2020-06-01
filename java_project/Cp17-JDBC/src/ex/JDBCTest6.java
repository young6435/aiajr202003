package ex;				//20.06.01 월요일

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest6 {

	public static void main(String[] args) {
		
		// jdbc 사용 객체. import 해야된다.
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			// 0. 드라이버 라이브러리(LIB) 추가.
			// 1. 데이터베이스 드라이버 로드.
			// class.forName(드라이버 클래스 전체이름)
			// Oracle : oracle.jdbc.driver.OracleDriver
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			// 2. 데이터베이스 연결.
			
			// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
			// 주소 : localhost or 127.0.0.1
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pw = "tiger";
			
			//  Connection 객체 생성
			conn = DriverManager.getConnection(url, user, pw);
			
			
			
			
			// 3. sql 처리
			// Statement or PreparedStatement
			//pstmt = conn.prepareStatement(sql 문장)
			
			String sql = "insert into dept (deptno, dname, loc) "
					+ " values (?, ?, ?)";		// 문자열이든 정수타입이든 그냥 물음표.
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 70);
			pstmt.setString(2, "마케팅");
			pstmt.setString(3, "서울");
			
			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt > 0) {	// 정상적으로 입력되면 값이 0보다 크다.
				System.out.println("정상적으로 입력되었습니다.");
				System.out.println(resultCnt + "행이 입력되었습니다.");
			}else {
				System.out.println("입력이 되지 않았습니다. 확인후 다시 시도해주세요.");
			}
			
			
			
			// 4. 데이터베이스 연결 종료
			
			//pstmt.close();
			
			//conn.close();
		
		
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {	
			
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
					e1.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			

			
		}
		
		
		
	}

}
