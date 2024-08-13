package edu.kh.membership.controler;

import java.io.IOException;
import java.util.List;

import edu.kh.membership.dto.MemberDTO;
import edu.kh.membership.service.MemberService;
import edu.kh.membership.service.MemberServiceImple;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/membership/searchName/search")
public class SearchNameSearch extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String[] gradeArray = {"일반", "동", "은", "금"};
		
		try {
			
			MemberService service = new MemberServiceImple();
			List<MemberDTO> searchList = service.searchName(name);
			
			String message = null;
			if(searchList.isEmpty())message = "해당하는 이름의 회원이 없습니다.";
			
			HttpSession session = req.getSession();
			session.setAttribute("searchList", searchList);
			session.setAttribute("message", message);
			session.setAttribute("gradeArray", gradeArray);
			
			resp.sendRedirect("/membership/searchName");
			
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	
}
