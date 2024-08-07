package due.kh.servlet2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 페키지는 구매한 도메인주소 포함해서 최소 3단계 이상으로 작성
// 도메인주소 거꾸로 들어감

// 해당 클래스를 서블릿으로 (web.xml에) 등록함
// + "/login" 요청 주소 차리하도록 매핑
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	// doGet 어제한거
	// 오늘은 form 태그에다가 method="post" 라고 적음
	/** "/login" POST방식 요청을 처리하는 메서드*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/** 요청시 제출된 값(파라미터) 모두 얻어오기*/
		String inputID = req.getParameter("inputID");
		String inputPW = req.getParameter("inputPW");
		String check   = req.getParameter("check");
		
		System.out.println("입력값 확인 : " + inputID+"/ "+inputPW+"/ "+check+"/");
		
		//-------------------------------------
		
		// 아이디가 user-01
		// 비밀번호가 pass01
		// check : 헬로 월드
		
		/** 모두 일치 하는 경우 -> 로그인 성공
		 *  불일치한 내용이 있을 경우
		 *  -> 000이 일치하지 않습니다.
		 *     (000은  ID, PW, CHECK)
		 *  */ 
		String result = ""; // 결과 저장 문자열
		
		if(inputID.equals("user-01")
			&& inputPW.equals("pass01!")
			&& check.equals("헬로 월드")) {
			
			result = "<h1 style='color:red;'>로그인 성공</h1>";
			
		} else{
			
			if(!inputID.equals("user-01")) {
				result += "<h3>ID가 일치하지 않습니다</h3>";
			}
			
			if(!inputPW.equals("pass01!")) {
				result += "<h3>PW가 일치하지 않습니다</h3>";
			}
			
			if(!check.equals("헬로 월드")) {
				result += "<h3>check가 일치하지 않습니다</h3>";
			}
			
		}
		
		
		
		
		//-------------------------------------
		
		/** 응답하기 */
		
		// 응답되는 문서의 형식, 인코딩 지정
		resp.setContentType("text/html; charset=utf-8");
		
		// 클라이언트와 연결된 출력용 스트림 얻어오기
		PrintWriter out = resp.getWriter();
		
		// 출력할 html
		StringBuilder sb = new StringBuilder();
		
		sb.append("""
		<!DOCTYPE HTML>
		<HTML>
		<HEAD>
		 <title>탭에들어갈제목</title>
		</HEAD>
		<body> <hr><hr>""");
		
		sb.append(result);
		sb.append("</body>");
		sb.append("</html>");
		
		out.write(sb.toString());
		
	}

}
