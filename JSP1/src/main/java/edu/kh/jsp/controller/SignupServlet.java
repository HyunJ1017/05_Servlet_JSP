package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	
	// "/signup" POST 방식 요청을 처리하는 메서드 오버라이딩
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/**별토 처리 없이 바로 jsp로 요청위임*/
		// 1. 주소 만들고
		// 1. 요청 위임할 JSP 경로 작성
		//    -> webapp 폴더가 기본이어서 "/"부터 시작하면 프로그램이 webapp폴더부터 찾아감
		String path = "/WEB-INF/views/signup_result.jsp";
		
		// 2. 객체만들기 + 위에꺼 쓰기
		//    문서 부르면서 생기는 req 안에 있나봄
		// 2. 요청을 위임시켜줄 객체 얻어오기 + 어디로 위임할지 매개변수에 작성
		//    -> RequestDispatcher (요청발송자)
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		// 3. HttpServletRequest HttpServletResponse 두 객체를
		//    요청 위임(forward)할 JSP에 넘기기
		dispatcher.forward(req, resp);
		
	}

}
