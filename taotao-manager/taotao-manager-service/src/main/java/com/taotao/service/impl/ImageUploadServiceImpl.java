package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.KindeEditImageUploadResult;
import com.taotao.service.ImageUploadService;
import com.taotao.utils.FastDFSClient;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

	@Value("IMAGE_ADDRESS_IP")
	public String IMAGE_ADDRESS_IP;
	
	@Override
	public KindeEditImageUploadResult uploadImage(MultipartFile picFile) {
		
		KindeEditImageUploadResult result=new KindeEditImageUploadResult();
		if(picFile==null){
			
			System.out.println("kkkkkkk");
			result.setError(1);
			result.setMessage("上传图片为空");
			return result;
		}
		
		String originalName=picFile.getOriginalFilename();
		String extName=originalName.substring(originalName.lastIndexOf(".")+1);		
		String confPath="classpath:properties/client.conf";
		
		try {
			//这个工具包实在common项目里面的，和manager不是同一个项目
			FastDFSClient client = new FastDFSClient(confPath);
			String path =client.uploadImage(picFile.getBytes(), extName);
			
			//path=IMAGE_ADDRESS_IP+path;
			//http://123.56.23.134/group1/M00/00/00/wKgB1lt-LKmAAAvWAABUURCi9O8438.png
			
			System.out.println(IMAGE_ADDRESS_IP);
			path="http://123.56.23.134/group1/"+path;
			result.setError(0);
			result.setUrl(path);
			
			System.out.println(path);
			
		} catch (Exception e) {

			e.printStackTrace();
			result.setError(1);
			result.setMessage("图片上传失败");
			
		}
		
		return result;
	}

	
}
