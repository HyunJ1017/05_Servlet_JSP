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

@WebServlet("/membership/addAmount/addOne")
public class AddAmountAddMoney extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] gradeArray = {"일반", "동", "은", "금"};
		
		try {
			int amount = Integer.parseInt(  req.getParameter("addMoney") );
			String phone = req.getParameter("phone");
			
			MemberService service = new MemberServiceImple();
			
			// 돈 추가하고 성공여부 메세지 띄워주고
			// 해당객체 받아서 반환
			String message = null;
			
			boolean result = service.addAmount(phone, amount);
			
			if(result) message = "성공!";
			else	   message = "실패!?";
			
			MemberDTO selectMember = service.searchMember(phone);
			HttpSession session = req.getSession();
			
			session.setAttribute("selectMember", selectMember);
			session.setAttribute("gradeArray", gradeArray);
			session.setAttribute("message", message);
			resp.sendRedirect("/membership/addAmount");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
