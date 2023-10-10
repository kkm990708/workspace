package edu.kh.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home") // 공통 주소
public class HomeController {
	
	// 상세주
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// @RequestMapping
	// 클래스에 작성 시 : 메서드에 작성된 @RequestMapping의 공통주소
	// 메서드에 작성 시 : 요청을 처리할 메서드 연결
	
	@RequestMapping(value = "/view1", method = RequestMethod.GET)
	public String home1() {
		// -> forward 또는 redirect 때문이
		// Controller 메서드 반환형은 대부분 String
		
		// forward할 JSP 경로에서
		// ViewResolver의 prefix, suffix 부분을 제외한 경로를
		// return 값으로 작성

		return "home/view1";
	}
	
	@RequestMapping(value = "/view2", method = RequestMethod.GET)
	public String home2() {
		
		return "home/view2";
	}
	
}
