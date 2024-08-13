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

@WebServlet("/membership/update")
public class Update extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String beforePhone = req.getParameter("beforePhone");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		
		System.out.println(beforePhone + ", " + name + ", " +  phone);
		
		try {
			MemberService service = new MemberServiceImple();
			boolean result = service.updateMember(beforePhone, name, phone);
			HttpSession session = req.getSession();
			String message=null;
			
			if(result) {
				message = String.format("%s 님의 정보를 변경 하였습니다.", name);
			} else {
				message = "변경하지 못하였습니다. 전화번호를 확인해 주세요";
			}
			session.setAttribute("message", message);
			
			resp.sendRedirect("/");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
