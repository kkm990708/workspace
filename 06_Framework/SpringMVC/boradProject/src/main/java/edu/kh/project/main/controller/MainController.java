package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Java 객체 : new연산자에 의해서 class내용대로 heap영역에 생성된것

//bean : Spring (Spring Container) 객체


@Controller
// bean 등록 + Controller 역할을 할 것이라고 명시
//- Controller 역할 : 요청/응답 제어
public class MainController {


	@RequestMapping("/")
	public String mainPage() {
		return "common/main";
		// -> /WEB-INF/views/common/main.js로 forward
	}
	
}
