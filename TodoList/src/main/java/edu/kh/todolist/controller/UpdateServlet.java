package edu.kh.todolist.controller;

import java.io.IOException;

import edu.kh.todolist.dto.Todo;
import edu.kh.todolist.service.TodoListService;
import edu.kh.todolist.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todo/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int index = Integer.parseInt( req.getParameter("index") );
		
		try {
			// 수정 전 제목/ 내용 조회 == 상세내용조회
			TodoListService service = new TodoListServiceImpl();
			Todo todo = service.todoDetailView(index);
			
			// request scope 세팅
			req.setAttribute("todo", todo);
			
			// forward할 jsp 경로
			String path = "/WEB-INF/views/update.jsp";
			
			// 요청위임
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	
	/* 요청 주소가 같아도
	 * 데이터전달방식(method - GET/POSt)이 다르면
	 * 각각의 메서드에서 처리할 수 있다
	 * 
	 */
	// 할일 데이터 수정 (POST 방식 요청)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전달받은 파라미터 얻어오기
		String title = req.getParameter("title");
		String detail = req.getParameter("detail");
		// <input type="hidden" name="index">
		int index = Integer.parseInt( req.getParameter("index") );
		
		try {
			TodoListService service = new TodoListServiceImpl();
			
			boolean result = service.todoUpdate(index, title, detail);
			
			// 수정 성공시
			// 상세 조회 페이지로 redirect
			// "수정되었습니다"
			
			// 수정 실패시
			// 수정 화면으로 redirect 후 수정실패 alert
			String url = null;
			String message = null;
			if(result) {
				url = "/todo/detail?index=" + index;
				message = "수정되었습니다";
			} else {
				url = "/todo/update?index=" + index;
				message = "수정 실패";
			}
			
			// redirect는 GET 방식 요청
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(url);
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		
			
	}
}
