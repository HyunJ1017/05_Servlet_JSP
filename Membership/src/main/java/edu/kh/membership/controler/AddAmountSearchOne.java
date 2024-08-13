package edu.kh.membership.controler;

import java.io.IOException;

import org.eclipse.jdt.internal.compiler.parser.RecoveredPackageVisibilityStatement;

import edu.kh.membership.dto.MemberDTO;
import edu.kh.membership.service.MemberService;
import edu.kh.membership.service.MemberServiceImple;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/membership/addAmount/downOne")
public class AddAmountSearchOne extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String phone = req.getParameter("phone");
		String[] gradeArray = {"일반", "동", "은", "금"};
		
		try {
			MemberService service = new MemberServiceImple();
			
			MemberDTO selectMember = service.searchMember(phone);
			
			HttpSession session = req.getSession();
			session.setAttribute("selectMember", selectMember);
			session.setAttribute("gradeArray", gradeArray);
			resp.sendRedirect("/membership/addAmount");
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
	}

}
