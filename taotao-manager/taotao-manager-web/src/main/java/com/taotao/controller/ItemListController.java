package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIdatagridResult;
import com.taotao.service.ItemService;

@Controller
public class ItemListController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		
		return page;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIdatagridResult getItemsList(Integer page, Integer rows){
		
		
		EasyUIdatagridResult result=itemService.getItemList(page, rows);
		
		return result;
		
	}
	
}
