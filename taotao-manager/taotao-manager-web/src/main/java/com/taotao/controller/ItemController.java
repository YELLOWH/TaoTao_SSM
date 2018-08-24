package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;


@Controller
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping("/item/{itemId}")//这个就是url模板，也叫做restful api
	@ResponseBody//返回的是json字符串
	TbItem getItemById(@PathVariable Long itemId){
		
		System.out.println("*******");
		
		return itemService.getItemById(itemId);
	}
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST)//如果是post请求，要注明,如果提交的是get，会报错
	@ResponseBody
	TaotaoResult createItem(TbItem item,String desc,String itemParams){//要注意，这里的pojo属性和前端属性要一致，desc也是
		
		TaotaoResult result=itemService.createItem(item, desc,itemParams);

		return result;
	}
	
}
