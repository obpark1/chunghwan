package kdata.project.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("2. UserDeleteService execuete");
		String id = request.getParameter("id");
		int result=0;
		
		
		try {
			result = UserDAO.getInstance().deleteById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 4. 이동할 다음 페이지 처리
		NextPage nextPage = new NextPage();
			//회원가입 실패
		if(result == 0) {
			//request영역에 메세지 담아서 보냄
			request.setAttribute("errorMsg", "회원가입에 실패했습니다");
			nextPage.setPageName("./errors/error.jsp");
					
			// request영역은 redirect로 보내면 유지가 안됨
			nextPage.setRedirect(false);
		}else {
			//회원가입 성공
			System.out.println("성공");
					
			nextPage.setPageName("./user/login.jsp");
			// redirect방식은 주소가 바뀜, request유지 안함
			nextPage.setRedirect(true);
			}	
		
		return nextPage;
	}

}
