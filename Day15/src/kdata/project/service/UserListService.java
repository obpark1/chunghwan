package kdata.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.UserDAO;
import kdata.project.dto.UserDTO;

public class UserListService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("2. UserListService execuete");
		// 1. 요청 파라미터 처리
		//	없음
		
		
		// 2. DB 처리
		List<UserDTO> list = new ArrayList<>();
		
		try {
			list = UserDAO.getInstance().selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 3. DB결과 처리
		request.setAttribute("list", list);
		System.out.println(list.size());

		// 4. 이동할 다음 페이지 처리
		NextPage nextPage = new NextPage();
		nextPage.setPageName("./user/list.jsp");
		// request유지 시킨다.
		nextPage.setRedirect(false);
		
		return nextPage;
	}

}
