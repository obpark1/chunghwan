package kdata.project.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdata.project.service.NextPage;
import kdata.project.service.UserService;

/**
 * Servlet implementation class Controller
 */

//파라미터가 여러 개 들어갈 때 {}쓴다.                    웹에서 쓰는 파라미터다.
@WebServlet(value="*.kdata", initParams =
{@WebInitParam(name="url", value="/kdata/project/util/url.properties")})
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// <URL, ServiceClassName>
	private Map<String, UserService> map = new HashMap<>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
    	Properties prop = new Properties();
    	//config.getInitParameter("url");
		System.out.println("init 들어옴");
    	try {
			// url에 해당하는 애들을 Stream으로 읽어와서 load하겠다.
			prop.load(getClass().getResourceAsStream(config.getInitParameter("url")));
			System.out.println(prop);
    	Iterator<Object> it = prop.keySet().iterator();
    	
    	while(it.hasNext()) {
    		String key = (String) it.next();
    		
    		// 클래스 로딩
        	Class clazz = Class.forName(prop.getProperty(key));
        				
        	// 객체 생성
        	UserService service = (UserService) clazz.newInstance();
        	
        	map.put(key, service);
    	}
    	}catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		int cmdIdx = url.lastIndexOf("/")+1;
		String cmd = url.substring(cmdIdx);
		System.out.println("doGet들어옴");
		//System.out.println(cmd);
		
		UserService service = map.get(cmd);
		//service.execute(request, response);
		
		NextPage nextPage = service.execute(request, response);
		
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
					//System.out.println("포워드");
					request.getRequestDispatcher(nextPage.getPageName())
					.forward(request, response);
					
				}
			}		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
