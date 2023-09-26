package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1) HTTPservlet 상속받기
// 2) doGet() 또는 doPost(오버라이딩)
// 3) 제출된 데이터(파라미터) 꺼내기
// 4) 필요한 로직 처리
// 5) 응답 형태 지정(setContet Type)
// 6) 응답용 스트림 얻어오기
// 7) html 코드 출력

// 어노테이션 : 컴파일러가 잃는 주석(설명)

//@WebServlet("/연결할 요청 주소) 이 어노테이션
// -해당 클래스를 servlet으로 등록하고
// () 내부에 작성된 주소 요청 시 해당클래스와 연결

// web.xml의 <servlet>. <
@WebServlet("/example2")
public class ExampleServlet2 extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//req.getParameter("속성") : 
		// - 제출된 input 값 중 name이 일치하는 input의 value 얻어오기
		// 같은 name 이 여러개이 경우 여러 개중 하나만 얻어옴
	
		// String[] req.getParameterValues("name속성")
//		-- name 이 일치하는 모든 세상의 input의 value값을
	// 하나의 Strinf 배열도반환
	
	String orderer = req.getParameter("orderer");
	String coffee = req.getParameter("coffee");
	String type = req.getParameter("type");
	String[] opt= req.getParameterValues("opt");
	
	System.out.println("디버그 모드로 파라미터 확인");
	
	
	// 커피 종류 따라서 가격 설정
	int price = 0;
	
	switch (coffee) {
	case "아메리카노": price = 1000; break;
	case "에스프레소" : price = 1000; break;
	case "카푸치노" : price = 2000; break;
	case "민초라떼" : price = 3000; break;
	case "돌체콜드브루" : price = 4000; break;
	}
	
	if(type.equals("ICE")) price += 500;
	
	// 5) 응답 형태 지정(setContet Type)
	resp.setContentType("text/html; charset=UTF-8");
	
	// 6) 응답용 스트림 얻어오기
	PrintWriter out = resp.getWriter();
	
	// 7) html 코드 출력
	out.print("<!DOCTYPE html>\r\n"
			+ "<html lang=\"en\">\r\n"
			+ "<head>\r\n"
			+ "  <title>" + orderer + "</title>\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+ "  <h3>주문자명 : " + orderer +"</h3>\r\n"
			+ "  <h3>커피 : " +type+ " " +coffee+ "</h3>\r\n");
	
	if(opt != null) {
		out.print("<h3>선택한 옵션 : ");
		for(String o : opt) {
			switch (o){
				case "mild" : out.print("연하게 "); break;
				case "addIce" : out.print("얼음추가 "); break;
			}
		}
		out.print("</h3>");
		
	}
	
	out.print("  <h3>결제 금액 : "+price+"원</h3>\r\n"
			+ "</body>\r\n"
			+ "</html>");
	
	
	//  옵션이 선택되어 있는지 확인
	
	}
}
