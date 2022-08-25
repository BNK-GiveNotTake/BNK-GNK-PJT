package com.service.gnt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.ApiOperation;


@Controller
public class MainController {
	
	/*
	 * @Autowired private GntService gntService;
	 */
	
	@ApiOperation(value="index", notes="index")
	@GetMapping("/")
	public String index() {
		return "redirect:Main/Start.html";
	}
	
	@ApiOperation(value="swagger", notes="Redirect To Swagger-ui page")
	@GetMapping("/swagger")
	public String swagger() {
		return "redirect:swagger-ui.html";
	}
}
