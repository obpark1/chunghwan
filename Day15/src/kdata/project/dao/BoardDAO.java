package kdata.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kdata.project.dto.BoardDTO;
import kdata.project.dto.UserDTO;
import kdata.project.util.DBUtil;

public class BoardDAO {
	
	// 싱글턴 패턴
	private static BoardDAO dao = new BoardDAO();
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		return dao;
	}
	
	// 댓글 쓰기
	public int insertComments(BoardDTO dto) throws SQLException {
		System.out.println("3. BoardDAO insert()");
		//이 연결 객체를 이 기능만 쓰고 버리겠다
		Connection con = null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
		//2. DB서버 연결
		con = DBUtil.getConnection();
		String sql = "insert into comments values(comment_seq.nextval,?,?,default,?)";
		
		
		// 3. Statement 객체 생성
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getContent());
		pstmt.setInt(3, dto.getNum());
		
					
					
		// 4. SQL문 전송
		result = pstmt.executeUpdate();
		}finally {
			DBUtil.close(con, pstmt);	
		}
		return result;
	}
	
	// 댓글 리스트
	public List<BoardDTO> selectComments(int num) throws SQLException {
		System.out.println("3. BoardDAO selectComments()");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<>();
		
		try {
			con = DBUtil.getConnection();
			String sql = "select * from comments where num=?";
			//3. Statement 객체 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			// 4. SQL문 전송
			rs = pstmt.executeQuery();
			
			// rs.으로 접근하면 테이블에 있는 행에 접근하는 것
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(rs.getInt(1),
						rs.getString("id"),
						rs.getString("content"),
						rs.getDate("write_date"),
						rs.getInt(5));
				
				list.add(dto);
			}
			
		}finally {
			DBUtil.close(con, pstmt, rs);
		}
		
		return list; 
	}
	// 댓글 삭제
	public int deleteComments(int comment_num) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
		//2. DB서버 연결
		con = DBUtil.getConnection();
		String sql = "delete from comments where comment_num=?";
		
		// 3. Statement 객체 생성
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, comment_num);;
							
		// 4. SQL문 전송
		result = pstmt.executeUpdate();
		}finally {
			DBUtil.close(con, pstmt);	
		}
		return result;
	}
}
