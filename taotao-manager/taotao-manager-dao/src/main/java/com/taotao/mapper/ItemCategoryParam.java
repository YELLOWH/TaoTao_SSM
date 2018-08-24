package com.taotao.mapper;

import java.util.List;

import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamItem;

public interface ItemCategoryParam {
	
	
	
	List<TbItemParam> getItemCategoryParamById(long cid);
	
	void addItemCategoryParam(TbItemParam itemParam);
	
	void addItem_paramitem(TbItemParamItem paramItem);

}
