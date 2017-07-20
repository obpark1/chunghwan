package kdata.project.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.BoardDAO;

public class CommentsDeleteService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("커맨트 지우기 서비스");
		String comment_num = request.getParameter("comment_num");
		int result =0;
		try {
			result = BoardDAO.getInstance().deleteComments(Integer.parseInt(comment_num));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result != 0) {
			System.out.println("삭제 성공");
		}
		return null;
	}
}
