package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/fr/redirect")
public class RedirectServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// request scope의 값 호출	=> 안넘어감
		req.setAttribute("str2",  "request scope의 값 호출 str2");
		
		// session scope에 값 추가	=> 넘어감
		HttpSession session = req.getSession();
		session.setAttribute("sessionNum", 10000);
		
		// resp.sendRedirect("다시요청할주소작성")
		// -> 파일 경로가 아닌 다시 요청할 Servlet의 @WebServlet()에 작성될 주소
		resp.sendRedirect("/fr/result");
		
	}

}
