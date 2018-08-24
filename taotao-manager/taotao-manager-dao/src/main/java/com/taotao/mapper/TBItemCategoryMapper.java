package com.taotao.mapper;

import java.util.List;

import com.taotao.pojo.TbItemCat;

public interface TBItemCategoryMapper {

    List<TbItemCat> getItemCategoryList(long parent);

}
