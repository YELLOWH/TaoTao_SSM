package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.KindeEditImageUploadResult;
import com.taotao.service.ImageUploadService;

@Controller
public class ImageUploadController {

	
	@Autowired
	ImageUploadService imageUploadService;
	
	@RequestMapping("pic/upload")
	@ResponseBody
	public KindeEditImageUploadResult imageUpload(@RequestParam("uploadFile") MultipartFile picFile){
		
		//这里为了解决火狐的兼容问题，我们自己把bean转成 json 字符串，不会走到jsp，因为有一个@ResponseBody注解
		return imageUploadService.uploadImage(picFile);
	}
}
