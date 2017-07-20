package kdata.project.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kdata.project.dao.BoardDAO;
import kdata.project.dto.BoardDTO;

public class CommentsWriteService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("커맨트 쓰기 서비스");
		String id = request.getParameter("id");
		String comments = request.getParameter("comments");
		String num = request.getParameter("num");
		int result =0;
		
		BoardDTO dto = new BoardDTO(id,comments,Integer.parseInt(num));
		try {
			result = BoardDAO.getInstance().insertComments(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		List<BoardDTO> list = new ArrayList<>();
		try {
			list = BoardDAO.getInstance().selectComments(Integer.parseInt(num));
			
			System.out.println("json--------------");
			// List랑 비슷하게 생김
			JSONArray array = new JSONArray();

			// Map과 비슷하게 생김 { key : value}의 형태
			
			for(int i=0; i<list.size();i++) {
				JSONObject obj = new JSONObject();
				obj.put("comment_num", list.get(i).getComment_num());
				obj.put("id", list.get(i).getId());
				obj.put("content", list.get(i).getContent());
				obj.put("write_date", String.valueOf(list.get(i).getWrite_date()));
				obj.put("num", list.get(i).getNum());
				array.add(obj);
			}
			
			System.out.println(array);
			PrintWriter out = response.getWriter();
			
			out.print(array);
			
			
		
		} catch (NumberFormatException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}

/*
//4. 이동할 다음 페이지 처리
			NextPage nextPage = new NextPage();
				//회원가입 실패
			if(result == 0) {
				//request영역에 메세지 담아서 보냄
				request.setAttribute("errorMsg", "게시글 업로드에 실패했습니다");
				nextPage.setPageName("./errors/error.jsp");
					
				// request영역은 redirect로 보내면 유지가 안됨
				nextPage.setRedirect(false);
			}else {
				//회원가입 성공
				System.out.println("게시글 업로드 성공");
					
				nextPage.setPageName("./user/login.jsp");
				// redirect방식은 주소가 바뀜, request유지 안함
				nextPage.setRedirect(true);
			}
			return nextPage;
*/