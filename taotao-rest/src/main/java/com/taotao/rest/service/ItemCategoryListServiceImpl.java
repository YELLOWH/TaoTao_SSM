package com.taotao.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TBItemCategoryMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.ItemsCatResult;

@Service
public class ItemCategoryListServiceImpl implements ItemCategoryListService {

	@Autowired
	TBItemCategoryMapper tBItemCategoryMapper;
	
	
	//这里返回的是总的数据
	@Override
	public ItemsCatResult getCategoryListByParentId(Long id) {

		List catlist=getList((long) 0);
		
		ItemsCatResult result=new ItemsCatResult();		
		result.setData(catlist);
		return result;
	}
	
	/**
	 * 递归方法，根据parent查询一个树形列表
	 * <p>Title: getList</p>
	 * <p>Description: </p>
	 * @param parentId
	 * @return
	 */
	private List<?> getList(long parentId) {
		
		List<TbItemCat> list = tBItemCategoryMapper.getItemCategoryList(parentId);
		List resultList = new ArrayList<>();
		//循环计数
		int count = 0;
		for (TbItemCat tbItemCat : list) {
			//如果为父节点
			if (tbItemCat.getIs_parent()) {
				CatNode node = new CatNode();
				node.setUrl("/products/" + tbItemCat.getId() + ".html");
				//判断是否为第一层节点
				if (parentId == 0) {
					node.setName("<a href='"+node.getUrl()+"'>"+tbItemCat.getName()+"</a>");
				} else {
					node.setName(tbItemCat.getName());
				}
				node.setItems(getList(tbItemCat.getId()));
				resultList.add(node);
			} else {
				String node = "/products/"+tbItemCat.getId()+".html|" + tbItemCat.getName();
				resultList.add(node);
			}
			count++;
			//第一个层循环，只取14条记录
			if (parentId == 0 && count >= 14) {
				break;
			}
		}
		return resultList;
	}
//	//这里返回的是每次根据 pid 找出来的数据
//	public List getCatByPid(Long id){
//		
//		List<TbItemCat> li = tBItemCategoryMapper.getItemCategoryList(id);
//		
//		ArrayList<CatNode> cat_list=new ArrayList<>();
//		
//		for(TbItemCat item : li){
//			
//			CatNode node= new CatNode();
//			node.setUrl("/products/"+item.getId()+".html");
//			
//			if(item.getIs_parent()){				
//				
//				node.setName("<a href = '/products/"+item.getId()+".html'>"+item.getName());				
//				
//			}else{
//				
//				node.setName(item.getName());				
//			}
//			
//			node.setItems(getCatByPid(item.getId()));
//			cat_list.add(node);
//		}
//		
//		return cat_list;
//	}

}
