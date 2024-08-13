package edu.kh.membership.controler;

import java.io.IOException;
import java.util.List;

import edu.kh.membership.dto.MemberDTO;
import edu.kh.membership.service.MemberService;
import edu.kh.membership.service.MemberServiceImple;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainPage extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 전체회원수, 등급별 회원수, 누적판매금 request scope
			MemberService service = new MemberServiceImple();
			
			List<MemberDTO> memberList = service.getAllMembers();
			
			int count  = 0; 	// 전체 회원수
			int nomal  = 0;		//등급별 회원수
			int bronz  = 0;
			int silver = 0;
			int gold   = 0;
			long amount = 0;		// 누적매출량
			
			for(MemberDTO member : memberList) {
				count++;
				amount+=member.getAmount();
				int grade = member.getGrade();
				
				if     (grade<1) nomal++;
				else if(grade<2) bronz++;
				else if(grade<3) silver++;
				else			 gold++;
				
			}
			
			req.setAttribute("count", count);
			req.setAttribute("nomal", nomal);
			req.setAttribute("bronz", bronz);
			req.setAttribute("silver", silver);
			req.setAttribute("gold", gold);
			req.setAttribute("amount", amount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String path = "/WEB-INF/views/main.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}

}
