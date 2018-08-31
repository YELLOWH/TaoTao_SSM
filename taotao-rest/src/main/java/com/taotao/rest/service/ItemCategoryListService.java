package com.taotao.rest.service;

import java.util.List;

import com.taotao.rest.pojo.ItemsCatResult;

public interface ItemCategoryListService {

	
	ItemsCatResult getCategoryListByParentId(Long id);
	
}
