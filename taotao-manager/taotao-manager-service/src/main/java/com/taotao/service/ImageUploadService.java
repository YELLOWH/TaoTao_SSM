package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.KindeEditImageUploadResult;

public interface ImageUploadService {

	KindeEditImageUploadResult uploadImage(MultipartFile picFile);
}
