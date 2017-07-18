package kdata.project.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.UserDAO;
import kdata.project.dto.UserDTO;

public class UserDetailService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("2. UserDetailService execuete");
		// 1. 파라미터인 id를 받기
		String id = request.getParameter("id");
		
		// 2. DB처리
		UserDTO dto = null;
		try {
			dto = UserDAO.getInstance().selectById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3. DB결과처리
		request.setAttribute("dto", dto);
		
		//4. 이동할 다음 페이지 처리
		NextPage nextPage = new NextPage();
		nextPage.setPageName("./user/detail.jsp");
		// request유지 시킨다.
		nextPage.setRedirect(false);
		System.out.println(nextPage);
		return nextPage;
	}

}
