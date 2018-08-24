package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.ItemCategoryParam;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemCategoryService;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

	@Autowired
	ItemCategoryParam itemCategoryParam;
	@Override
	public TaotaoResult getItemCategoryById(long cid) {
		// TODO Auto-generated method stub
		
		
		List<TbItemParam> li=itemCategoryParam.getItemCategoryParamById(cid);
		
		if(li!=null&&li.size()!=0){
			
			TbItemParam tb =li.get(0);
			System.out.println(tb.getParamData());
			return TaotaoResult.ok(li.get(0));
			
		}
		return TaotaoResult.ok();
	}
	
	@Override
	public TaotaoResult addItemCategoryParam(Long cid, String paramString) {
		// TODO Auto-generated method stub
		
		TbItemParam param = new TbItemParam();
		Date date=new Date();
		
		param.setCreated(date);
		param.setUpdated(date);
		param.setItemCatId(cid);
		param.setParamData(paramString);
		
		itemCategoryParam.addItemCategoryParam(param);
		
		
		
		return TaotaoResult.ok();
	}

}
