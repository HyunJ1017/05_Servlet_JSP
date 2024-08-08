package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/el/scope")
public class LETestServlet2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/** 요청처리 */
		
		// 1. page scope -> JSP에서만 확인 가능
		
		
		// 2. request scope
		// - 요청 받은 Serlvet/JSP와
		//   요청이 위임된 Servlet/JSP에서 유지되는 객체
		
		// * Servlet/JSP 범위 객체에
		//  1. 추가적인 값(속성) 추가하는 방법
		//  범위객체.setAttribute("key", value);
		
		//  2. 추가적인 값(속성) 얻어오는 방법
		//  Object 범위객체.getAttribute("key", value);
		//  -> 반환형 Object -> 필요시 다운 캐스팅
		
		req.setAttribute("requestValue", "Request Scope 객체에 세팅한 값");
		
		System.out.println(req.getAttribute("requestValue"));
		
		
		//===============================================================
		
		// 3. session(입회, 접속) scope
		// - 클라이언트가 서버에 첫 요청 시
		//	 서버쪽에 생성되는 객체
		
		// - 클라이언트가 브라우저를 종료하거나
		//	 지정된 세션 만료 시간이 지나면 사라짐
		//   -> 위 상황이 아니면 계속 유지되는 객체
		
		// 1) session scope 객체 얻어오기
		HttpSession session = req.getSession();
		
		// 2) session scope 객체에 값 세팅하기
		session.setAttribute("sessionValue", "Seeeion Scope 객체에 세팅한 값");
		
		
		//--------------------------------------------------------
		/** 응답처리 */
//		String path = "/WEB-INF/views/el/scope.jsp";
//		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
//		dispatcher.forward(req, resp);
		
		req.getRequestDispatcher("/WEB-INF/views/el/scope.jsp").forward(req, resp);
		
	}

}
