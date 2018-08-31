package com.taotao.rest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//这里其实是在构造返回给请求端的 json 数据
public class CatNode {
	
	@JsonProperty("u")
	private  String url;

	@JsonProperty("n")
	private String name;
	
	@JsonProperty("i")
	private List items;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getItems() {
		return items;
	}

	public void setItems(List items) {
		this.items = items;
	}
	
	

}
