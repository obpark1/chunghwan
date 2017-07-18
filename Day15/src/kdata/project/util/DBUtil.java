package kdata.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	/** 
	 * DB 서버 연결 관리하는 클래스
	 * @author cse
	 * Connection 생성, 종료
	 */
	// 상수는 반드시 초기화 시켜야
	private static final String CON_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER_ID = "rladkdlwkd";
	private static final String USER_PASSWD = "1234";
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	
	//클래스 로드할 때 이 부분에 대한 것이 한 번 실행되고 실행되지 않음
	static {
		try {
			//JDBC 드라이버 로드
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 데이터 베이스 서버 연결하는 메소드
		static을 쓰면 객체를 생성하지 않아도 접근할 수 있음
		클래스 이름.메소드
		@return Connection 데이버베이스 연결 정보 객체 반환
		@throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(CON_URL,USER_ID,USER_PASSWD);
		return con;
	}
	//객체가 생성될 때마다 실행됨
	DBUtil(){
		
	}
	
	public void connect() {
		
	}
	
	/**
	 * 데이터베이스 연결시 사용한 자원 해제
	 * @param
	 * @return
	 * @throws SQLException 
	 */
	public static void close(Connection con, PreparedStatement pstmt) throws SQLException {
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();	
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null)
			pstmt.close();
		if(con != null)
			con.close();	
	}
}
