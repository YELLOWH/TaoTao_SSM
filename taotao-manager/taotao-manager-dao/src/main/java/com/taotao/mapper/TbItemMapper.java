package com.taotao.mapper;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;

import java.util.List;

/**
 * 
 * 通常是一个表一个mapper
 * @author yellow
 *
 */
public interface TbItemMapper {


    TbItem selectItemById(Long id);
    

    List<TbItem> selectItemsByPage();
    
    void createItem(TbItem item);
    
    void createItemDesc(TbItemDesc desc);
    

}