package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전달받은 값을 h1테그에 각각 다른색상으로 출력되고록
		// html코드를 작성해여 응답하기

		// 요청시 제출된 파라미터 가져오기
		// req.getParameter("input1")
		
		//-----------------------------------------------
		
		/*응답처리*/
		// -> Servlet이 직접 HTML 코드를 작성하지 않고
		//    JSP한테 대신 화면을 만들어 클라이언트에게 응답(출력)
		//    하라고 요청을 떠넘김
		//    -> 요청위임
		
		// 요청위임방법 1)
		// 떠넘길(위임할) JSP 경로 작성하기
		// -> 웹 앱 폴더를 기준으로 경로작성
		//  제일 앞"/" == webapp 폴더
		
		String path = "/WEB-INF/views/test_result.jsp";
		
		// 요청위임방법 2)
		// 요청을 전달할 객체(RequestDispatcher) 얻어오기
		// 객체 얻어올 때 어떤 JSP로 전달할 지 매개변수로 기입
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		// 요청위임방법 3)
		// RequestDispatcher 객체에게
		// HttpServletRequest	(요청데이터)
		// HttpServletRespronse	(응답방법)
		// 를 주고
		// JSP로 떠넘기는(위임하는) 메서드 호출
		dispatcher.forward(req, resp);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
