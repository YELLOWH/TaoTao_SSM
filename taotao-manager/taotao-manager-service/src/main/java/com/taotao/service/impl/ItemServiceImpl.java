package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.EasyUIdatagridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.ItemCategoryParam;
import com.taotao.mapper.TBItemCategoryMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;
import com.taotao.utils.IDUtils;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	TbItemMapper itemMapper;
	
	@Autowired
	TBItemCategoryMapper tBItemCategoryMapper;
	
	@Autowired
	ItemCategoryParam itemCategoryParam;
	
	
	@Override
	public TbItem getItemById(Long itemId) {

		
		TbItem item=itemMapper.selectItemById(itemId);
		
		//System.out.println(item.getSellPoint());
		return item;
	}

	//这里之所以返回 EasyUIdatagridResult 对象，是因为easyui里面规定，返回的对象必须有两个属性 total rows，所以我们自己定义一个这样的对象
	//而 rows 里面的对象的属性，又必须和 easyui 的 datagrid 里面的 field 属性同名，这样才能映射过去
	@Override
	public EasyUIdatagridResult getItemList(int page, int rows) {
		
		//这里设置分页插件，则下面执行的sql会被aop，sql会按照设置进行分页
		PageHelper.startPage(page, rows);
		List<TbItem> items=itemMapper.selectItemsByPage();
		
		PageInfo<TbItem> info=new PageInfo<>(items);
		
		EasyUIdatagridResult result=new EasyUIdatagridResult();
		result.setTotal(info.getTotal());
		result.setRows(items);
		
		return result;
	}

	@Override
	public List<EasyUITreeNode> getItemCategoryByParent(long parentid) {
		// TODO Auto-generated method stub
		
		List<TbItemCat> nodes=tBItemCategoryMapper.getItemCategoryList(parentid);
		
		List<EasyUITreeNode> easynodes=new ArrayList<>();
		
		for(TbItemCat item : nodes){
			
			EasyUITreeNode en = new EasyUITreeNode();
			en.setId(item.getId());
			en.setText(item.getName());
			en.setState(item.getIs_parent()?"closed":"open");
			easynodes.add(en);
		}
		
		
		return easynodes;
	}

	//这个方法会被插入事务 因为配置 aop 会扫描service包下的 create* 方法 事务是通过捕获异常进行的，所以这里不能自己进行异常处理，要处理可以抛出去
	@Override
	public TaotaoResult createItem(TbItem item, String desc,String itemParam) {
		// TODO Auto-generated method stub
		
		//商品id
		long itemid=IDUtils.genItemId();
		item.setId(itemid);
		
		//商品状态
		item.setStatus((byte) 1);
		
		Date date=new Date();
		item.setCreated(date);
		item.setUpdated(date);		
		itemMapper.createItem(item);
		
		TbItemDesc itemDesc=new TbItemDesc();
		itemDesc.setItemId(itemid);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);		
		itemMapper.createItemDesc(itemDesc);
		
		
		TbItemParamItem paramItem =new TbItemParamItem();
		paramItem.setCreated(date);
		paramItem.setUpdated(date);
		paramItem.setItemId(itemid);
		paramItem.setParamData(itemParam);		
		itemCategoryParam.addItem_paramitem(paramItem);
		
		return TaotaoResult.ok();
	}



}
