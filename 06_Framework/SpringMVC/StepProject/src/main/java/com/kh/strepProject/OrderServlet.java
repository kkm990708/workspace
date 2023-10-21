package com.kh.strepProject;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderServlet {
	

	
	
	
	@GetMapping("order")
	public String order(
			String name,
			int blackPen,
			int redPen,
			int bluePen,
			int white,
			Model model) {
		
		int total = blackPen + redPen + bluePen+ white;
		
		if (total == 0) {
		return "redirect:error";	
		}
		
		model.addAttribute("name",name);
		model.addAttribute("blackPen",blackPen);
		model.addAttribute("redPen",redPen);
		model.addAttribute("bluePen",bluePen);
		model.addAttribute("white",white);
		
		blackPen *= 500;
		redPen *= 700;
		bluePen *= 700;
		white *= 1000;
		
		model.addAttribute("blackPenPrice",blackPen);
		model.addAttribute("redPenPrice",redPen);
		model.addAttribute("bluePenPrice",bluePen);
		model.addAttribute("whitePrice",white);

		
		total = blackPen + redPen + bluePen + white;
		
		model.addAttribute("total",total);
		
		
		return "resultPage";
	}
		
	
}
