package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	//这是通过web。xml的欢迎页面设置过来的
	//
	@RequestMapping("/index")
	public String showIndexPage(){
		
		System.out.println("qqqqq");
		
		return "index";
	}
}
