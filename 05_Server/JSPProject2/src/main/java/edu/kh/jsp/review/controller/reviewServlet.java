package edu.kh.jsp.review.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
// 톰캣에서 제공하는 클래스
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 클라이언트의 요청 주소를 처리할 클래스를 매핑
@WebServlet("/review")
public class reviewServlet extends HttpServlet{

	// doGet(req, resp) : GET 방식 요청 처리 메서드
	// HttpServletRequest : 클라이언트의 요청 정보(파라미터, ip)
	// HttpServletResponse : 서버 -> 클라이언트 응답하는 방법을 제공
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// req.getParameter("name 속성값") : 파라미터 얻어오기
		// String[] req.getParameter("name 속성값") : 파라미터 모두 얻어오기
		
		String inputName = req.getParameter("inputName");
		String inputAge = req.getParameter("inputAge");
		String gender = req.getParameter("gender");
	
		String[] hobbyArr = req.getParameterValues("hobby");
		// 체크된 값이 없으면 null
		
		
		// hobbyArr 에 값이 있을 때, 없을 때에 따라
		// 알맞은 문자열 생성
		
		// 있을 때 : 취미는 게임, 유튜브 입니다
		// 없을 때 : 선택된 취미가 없습니다
	
		String str = null;
		if (hobbyArr == null) {
			str = "선택된 취미가 없습니다";
		} else {
			str = String.format("취미는 %s 입니다.", String.join(", ", hobbyArr) );
		}
		
		//----------------------------------------
		
		// JSP 로 요청 위임
		
		// JSP 파일 경로 작성(webapp 폴더 기준)
		String path = "/WEB-INF/views/review_result.jsp";
		
		// 요청 발송자(RequestDispatcher) 얻어오기
		
		RequestDispatcher dispatcher =
				req.getRequestDispatcher(path);
		
		// Servlet 에서 생성한 변수(str)을
		// 요청 위임된 JSP 에서 사용할 수 있도록
		// HttpServletRequest 에 속성(필드) 추가
		
		req.setAttribute("str", str);
		
		// 요청 위임(forward) 수행
		dispatcher.forward(req, resp);
		
	}
	
	
	
	
	
	

}