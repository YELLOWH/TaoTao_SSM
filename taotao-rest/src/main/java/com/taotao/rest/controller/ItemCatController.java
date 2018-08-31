package com.taotao.rest.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.rest.pojo.ItemsCatResult;
import com.taotao.rest.service.ItemCategoryListService;
import com.taotao.utils.JsonUtils;

@Controller
public class ItemCatController {

	
	@Autowired
	ItemCategoryListService itemCategoryListService;
	
	
	@RequestMapping(value="/item/cat/list",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback) {
		
		System.out.println("zzz");
		ItemsCatResult result = itemCategoryListService.getCategoryListByParentId((long) 0);
		
		if (StringUtils.isBlank(callback)) {
			return JsonUtils.objectToJson(result);
		}
		
		return callback + "(" + JsonUtils.objectToJson(result) + ");";
	}
	

}
