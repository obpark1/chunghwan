package kdata.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.service.NextPage;
import kdata.project.service.UserDeleteService;
import kdata.project.service.UserDetailService;
import kdata.project.service.UserListService;
import kdata.project.service.UserRegisterService;
import kdata.project.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
//@WebServlet("*.kdata")
// Controller
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("User Servlet");
		
		//요청하는 정보에서  
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		System.out.println("uri is " + uri);
		System.out.println("path is " + path);
		
		UserService service=null;
		NextPage nextPage = null;
		String cmd = uri.substring(path.length()+1);
		System.out.println("cmd is " + cmd);
		if(cmd.equals("register.kdata")) {
			System.out.println("1. 회원가입");
			//유저서비스 객체 생성
			service = new UserRegisterService();
			// 다음페이지 이동할 페이지 이름과 어떻게 이동할지(redirect인지 foward인지)가 반환됨 
			nextPage= service.execute(request, response);
			
		}else if(cmd.equals("list.kdata")) {
			System.out.println("회원리스트");
			service = new UserListService();
			nextPage= service.execute(request, response);
		}else if(cmd.equals("detail.kdata")) {
			System.out.println("회원 상세정보");
			service = new UserDetailService();
			nextPage= service.execute(request, response);
		}else if(cmd.equals("delete.kdata")) {
			System.out.println("회원 정보삭제");
			service = new UserDeleteService();
			nextPage= service.execute(request, response);
		}
		System.out.println(nextPage);
		// 2. 다음 페이지 이동
		if(nextPage == null) {
			System.out.println("Null을 반환하지마!");
		}
		else {
			// redirect가 true면 redirect로 이동
			if(nextPage.isRedirect()) {
				//true일 경우 다음에 이동할 페이지 정보 매개변수에 넣는다
				response.sendRedirect(nextPage.getPageName());
			}
			else {
				// redirect가 false면 forward방식으로 감
				// request유지 시키는 것 포워드
				// 포워드는 요청이 들어가면 서버상에서 이동해서 주소가 안바뀜
				System.out.println("포워드");
				request.getRequestDispatcher(nextPage.getPageName())
				.forward(request, response);
			}
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 doGet(request, response);
	}

}
