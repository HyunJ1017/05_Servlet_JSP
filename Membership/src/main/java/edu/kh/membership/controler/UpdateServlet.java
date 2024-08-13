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

@WebServlet("/membership/updateMember")
public class UpdateServlet extends HttpServlet {
	
	// 회원정보, 전체회원 창에서도 링크다고 여기로 오게만들거임
	// 연결된 jsp에서도 오게
	// 걸쳐온것들은 post로 온것들은 다음페이지로
	// 처음온 화면은 doget으로
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/update.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전달받은 member가 있으면 쓰고 없으면 전화번호로 검색해줌
		// 그런거 여기 못오는듯... 다 핸드폰번호로 넘김
		// 확실히 못옴 ㅋㅋ
		if(req.getParameter("member")==null) {
			try {
				MemberService service = new MemberServiceImple();
				
				MemberDTO member = service.searchMember( req.getParameter("phone") );
				
				if(member==null) {
					HttpSession session = req.getSession();
					session.setAttribute("message", "일치하는 전화번호가 없습니다.");
					req.getRequestDispatcher("/").forward(req, resp);
					return;
				} else req.setAttribute("member", member);
				
			} catch (Exception e ) {
				e.printStackTrace();
			}
		}else{
			req.setAttribute("member", req.getParameter("member"));
		}
		
		
		String path = "/WEB-INF/views/updateID.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
