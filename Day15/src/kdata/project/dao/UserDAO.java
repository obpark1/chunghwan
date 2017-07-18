package kdata.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kdata.project.dto.UserDTO;
import kdata.project.util.DBUtil;

public class UserDAO {
	
	// 싱글턴 패턴, 이 객체는 한 개만 만들어진다.-------------------
	private static UserDAO dao = new UserDAO();
	
	//이 클래스 내부에서만 접근 가능
	private UserDAO() {
		
	}
	
	// 외부에서 부를 수 있게 static으로 만듬
	public static UserDAO getInstance() {
		return dao;
	}
	// ------------------------------------------
	// 회원가입, 반환형은 성공했다 or 실패했다를 알려주는 int, boolean으로 해도 됨
	public int insert(UserDTO dto) throws SQLException {
		System.out.println("3. UserDAO insert()");
		//이 연결 객체를 이 기능만 쓰고 버리겠다
		Connection con = null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
		//2. DB서버 연결
		con = DBUtil.getConnection();
		String sql = "insert into users values(?,?,?,?,default)";
		
		
		// 3. Statement 객체 생성
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(3, dto.getName());
		pstmt.setString(4, dto.getProfile());
					
					
		// 4. SQL문 전송
		result = pstmt.executeUpdate();
		}finally {
			DBUtil.close(con, pstmt);	
		}
		return result;
	}
	
	// 회원리스트
	public List<UserDTO> selectAll() throws SQLException {
		System.out.println("3. UserDAO selectAll()");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserDTO> list = new ArrayList<>();
		
		try {
			con = DBUtil.getConnection();
			String sql = "select * from users order by id";
			//3. Statement 객체 생성
			pstmt = con.prepareStatement(sql);
			
			// 4. SQL문 전송
			rs = pstmt.executeQuery();
			
			// rs.으로 접근하면 테이블에 있는 행에 접근하는 것
			while(rs.next()) {
				UserDTO dto = new UserDTO(rs.getString("id"),
						rs.getString("name"),
						rs.getString("profile"),
						rs.getDate("reg_date"));
				
				list.add(dto);
			}
			
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		return list; 
	}
	
	// 회원상세정보
	public UserDTO selectById(String id) throws SQLException {
		System.out.println("3. UserDAO selectById()");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO dto = null;
		
		try {
			con = DBUtil.getConnection();
			String sql = "select * from users where id= ?";
			//3. Statement 객체 생성
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			// 4. SQL문 전송
			rs = pstmt.executeQuery();
			
			// rs.으로 접근하면 테이블에 있는 행에 접근하는 것
			while(rs.next()) {
				dto = new UserDTO(rs.getString("id"),
						rs.getString("name"),
						rs.getString("profile"),
						rs.getDate("reg_date"));
			}
			
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		
		System.out.println(dto);
		return dto;
	}
	
	// 로그인
	public void login() {
		System.out.println("3. UserDAO login()");
	}
	
	// 회원정보 삭제
	public int deleteById(String id) throws SQLException {
		System.out.println("3. UserDAO deleteById()");
		Connection con = null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
		//2. DB서버 연결
		con = DBUtil.getConnection();
		String sql = "delete from users where id=?";
		
		// 3. Statement 객체 생성
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
							
		// 4. SQL문 전송
		result = pstmt.executeUpdate();
		}finally {
			DBUtil.close(con, pstmt);	
		}
		return result;
		
	}
}
