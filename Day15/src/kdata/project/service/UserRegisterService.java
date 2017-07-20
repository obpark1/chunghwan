package kdata.project.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kdata.project.dao.UserDAO;
import kdata.project.dto.UserDTO;

public class UserRegisterService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("2. UserRegisterService execuete");
		String path = request.getServletContext().getRealPath("profile");
		System.out.println(path);
		int result=0;
		MultipartRequest multi = null;
		//최대크기 10mb
		try {
			multi = new MultipartRequest(
					request,path,1024*1024*10, "UTF-8"
					,new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String id = multi.getParameter("id");
		String pw = multi.getParameter("pw");
		String name = multi.getParameter("name");
		
		String fileSystemName = multi.getFilesystemName("file");
		//String originalFileName = multi.getOriginalFileName("file");
		
		System.out.println("파일시스템" + fileSystemName);
		//System.out.println("오리지날" + originalFileName);
		
		
		UserDTO dto = new UserDTO(id,pw,name,fileSystemName);
		System.out.println("dto끝");
		try {
			result = UserDAO.getInstance().insert(dto);
			System.out.println("insert 결과" + result);
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

//1. 요청 파라미터 처리
		/*String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String profile = request.getParameter("profile");
		int result=0;
		// 2. DB처리, insert해야댐, 즉 DAO에 메소드 호출
		//UserDAO dao = new UserDAO.getInstance();
		//dao.insert();
		
		// 위에꺼 한줄로
		UserDTO dto = new UserDTO(id, pw, name);
		try {
			result = UserDAO.getInstance().insert(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// 3. DB결과 처리, DAO에서 성공 or 실패의 결과를 처리
*/
