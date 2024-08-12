package edu.kh.membership.controler;

import java.io.IOException;

import edu.kh.membership.service.MemberService;
import edu.kh.membership.service.MemberServiceImple;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/membership/addMember")
public class addMember extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		try {
			MemberService service = new MemberServiceImple();
			
			boolean result = service.addMember(name,phone);
			
			String message = null;
			
			if(result)  message = "멤버를 저장하였습니다.";
			else		message = "중복된 전화번호는 사용할 수 없습니다.";
			
			HttpSession session = req.getSession();
			session.setAttribute("message",message);
			
			resp.sendRedirect("/");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
