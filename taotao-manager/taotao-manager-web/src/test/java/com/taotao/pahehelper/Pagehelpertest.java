package com.taotao.pahehelper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;

public class Pagehelpertest {

	//@Test
	public void testPageHelper(){
		
		ApplicationContext ctx= new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
		
		TbItemMapper bean=ctx.getBean(TbItemMapper.class);
		
		PageHelper.startPage(1, 30);
				
		List<TbItem> items=bean.selectItemsByPage();
		
		PageInfo<TbItem> pageInfo=new PageInfo<>(items);
		
		long total =pageInfo.getTotal();
		
		System.out.println(pageInfo.getPageSize());
		System.out.println(total);		
		System.out.println(pageInfo.getPages());
		
	}
	//@Test
	public void testdate(){
		System.out.println("***"+new Date());
	}
	
}
