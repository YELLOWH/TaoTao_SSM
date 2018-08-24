package com.taotao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.EasyUIdatagridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemCat;


public interface ItemService {

	TbItem getItemById(Long itemId);
	
	EasyUIdatagridResult getItemList(int page, int rows);
	
	List<EasyUITreeNode> getItemCategoryByParent(long parentid);
	
	
	TaotaoResult createItem(TbItem item,String desc,String itemParam);
	
}
