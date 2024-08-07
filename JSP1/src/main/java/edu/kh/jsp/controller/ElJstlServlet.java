package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/el_jstl")
public class ElJstlServlet extends HttpServlet {
	
	// a 태그 요청은 GET 방식
	// GET방식 요청시 지정된 JSP로 바로 요청위임
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/el_jstl.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		// 3. 요청위임(forward)
		dispatcher.forward(req, resp);
		
		
		
		
		
	}

}
