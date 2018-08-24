package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;

public interface ItemCategoryService {

	
	TaotaoResult getItemCategoryById(long cid);
	
	TaotaoResult addItemCategoryParam(Long cid, String paramString);
}
