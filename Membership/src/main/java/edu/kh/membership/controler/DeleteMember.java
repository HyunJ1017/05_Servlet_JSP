package edu.kh.membership.controler;

import java.io.IOException;

import edu.kh.membership.dto.MemberDTO;
import edu.kh.membership.service.MemberService;
import edu.kh.membership.service.MemberServiceImple;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/membership/deleteMember")
public class DeleteMember extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String phone = req.getParameter("phone");
		
		try {
			MemberService service = new MemberServiceImple();
			
			MemberDTO result = service.deleteMember(phone);
			
			String message = null;
			if(result == null) message = "해당하는 번호가 없습니다.";
			else {
				message = String.format("%s 회원님을 탈퇴시켰습니다.", result.getName());
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			resp.sendRedirect("/");
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
