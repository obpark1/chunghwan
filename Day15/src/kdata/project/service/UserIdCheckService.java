package kdata.project.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.dao.UserDAO;

public class UserIdCheckService implements UserService{

	@Override
	public NextPage execute(HttpServletRequest request,
			HttpServletResponse response) {
		int result=0;
		System.out.println("UserIdCheckService excute");
		String id = request.getParameter("id");
		System.out.println(id);
		try {
			result = UserDAO.getInstance().idcheck(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			out.print(result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
