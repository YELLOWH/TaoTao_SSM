package com.taotao.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSClient {
	
	private TrackerClient trackerClient=null;
	private TrackerServer trackerServer=null;
	private StorageServer storageServer=null;
	private StorageClient1 storageClient1=null;
	
	
	/**
	 * 注意 java 的构造方法（初始化方法） 是没有返回值的
	 * @param confPath
	 * @throws Exception
	 */
	public FastDFSClient(String confPath) throws Exception{		
		
		if(confPath.contains("classpath")){
			
			//this.getClass().getResource("/").getPath() 这个取得的就是这类在运行时项目的 Resource 路径，他是webapp/web-inf/resources 
			confPath=confPath.replace("classpath:", this.getClass().getResource("/").getPath());
			System.out.println(confPath);
		}
		ClientGlobal.init(confPath);
		trackerClient=new TrackerClient();//初始化一个访问 dfs 服务器的客户端
		trackerServer=trackerClient.getConnection();//根据这个客户端拿到服务器操作的连接
		storageServer=null;
		storageClient1=new StorageClient1(trackerServer, storageServer);
		
		
				
	}
	
	public String uploadImage(byte[] imageContent,String extName) throws Exception{
		
		/**
		 * imageContent:文件的二进制数据
		 * extName：文件的扩展名
		 * metas：文件的扩展信息
		 * 
		 * 放回信息：组、路径
		 */
		String[] result= storageClient1.upload_file(imageContent, extName, null);		
		return result[1];		
		
	}
	
	
	

}
