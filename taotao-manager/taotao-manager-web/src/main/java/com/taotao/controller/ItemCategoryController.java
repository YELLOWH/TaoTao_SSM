package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ItemCategoryService;
import com.taotao.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemCategoryController {

	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemCategoryService itemCategoryService;
	
	@RequestMapping("cat/list")
	@ResponseBody//把id，前端传过来的，拿到这个属性的值，赋值给parentID,这么写如果对方没传id过来会报错，所以给个默认值
	public List<EasyUITreeNode> getItemsCategory(@RequestParam(value="id",defaultValue="0")long parentID){
				
		return itemService.getItemCategoryByParent(parentID);
	}
	

	@RequestMapping("/param/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult getItemCategoryParamById(@PathVariable Long cid){
		
		
		return itemCategoryService.getItemCategoryById(cid);
	}
	
	@RequestMapping("/param/cid/{cid}")
	@ResponseBody
	public TaotaoResult test_getItemCategoryParamById(@PathVariable Long cid){
		
		
		System.out.println("zzzz");
		return itemCategoryService.getItemCategoryById(cid);
	}
	
	@RequestMapping("/param/save/{cid}")//这个cid是拼接到url上的，所以可以这么拿到
	@ResponseBody//@PathVariable是指从路径中拿，其他参数不是，自动根据名称匹配，get，post都一样（看传来的是不是json数据，是的话还要转一下@requestbody）
	public TaotaoResult addItemCategoryParam(@PathVariable Long cid, String paramData){//paramData和前端的属性名是一致的
		
		
		return itemCategoryService.addItemCategoryParam(cid, paramData);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
