package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
	
	
	//BeanNameViewResolver 사용
	@RequestMapping("/login.do")
	public ModelAndView login() {
		System.out.println("login 클릭...");
		
		return new ModelAndView("redirect:login_success.jsp");
	}
	
	
	//BeanNameViewResolver 사용
	@RequestMapping("/findProduct.do")
	public ModelAndView findProduct() {
		System.out.println("findProduct.do....진입...");
		
		return new ModelAndView("product/result/find_ok.jsp");
	}
		
	//InternalResourceViewResolver 사용
	@RequestMapping("/register.do")
	public ModelAndView register() {
		System.out.println("register.do....진입...");
		
		return new ModelAndView("response/register_result.jsp","info","InternalResourceViewResolver");
	}
	/* 결과 페이지가 따로 존재하지 않는 기술 Ajax, 비동기화, FileUpload, InternalViewResource, InternalViewResolver
	 * 
	 * 
	 */
}

