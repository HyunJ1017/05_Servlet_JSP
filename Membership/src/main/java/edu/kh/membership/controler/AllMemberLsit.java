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

@WebServlet("/membership/allMemberList")
public class AllMemberLsit extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] gradeArray = {"일반", "동", "은", "금"};
		// 회원 전체리스트 불러다가 전달해주기
		
		try {
			MemberService service = new MemberServiceImple();
			
			List<MemberDTO> memberList = service.getAllMembers();
			
			req.setAttribute("memberList", memberList);
			req.setAttribute("gradeArray", gradeArray);
			
			String path = "/WEB-INF/views/allMemberList.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		
		
		
	}

}
