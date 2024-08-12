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

@WebServlet("/membership/searchPhoneNum")
public class SearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/**
		 * 번호 입력받아서 검색리스트 + 등급배열 전달하기
		 */
		String searchPH = req.getParameter("searchPH");
		String[] gradeArray = {"일반", "동", "은", "금"};
		
		try {
			MemberService service = new MemberServiceImple();
			
			List<MemberDTO> searchMembership = service.searchMembership(searchPH);
			
			HttpSession session = req.getSession();
			session.setAttribute("gradeArray", gradeArray);
			session.setAttribute("searchMembership", searchMembership);
			
			resp.sendRedirect("/membership/addAmount");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
