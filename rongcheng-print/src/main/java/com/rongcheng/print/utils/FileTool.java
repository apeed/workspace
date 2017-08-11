package com.rongcheng.print.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


public class FileTool {
	/**
	 * 将HttpServletRequest 转换�? MultipartHttpServletRequest
	 * 目的是为了能够接受fromdata数据
	 * 
	 * @param request 
	 * @return
	 */
	public static MultipartHttpServletRequest requestTransition(HttpServletRequest request) {
		MultipartHttpServletRequest multipartRequest = null;
		// 转型为MultipartHttpRequest
		if (request instanceof MultipartHttpServletRequest) {
			multipartRequest = (MultipartHttpServletRequest) request;
		} else {
			CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			commonsMultipartResolver.setDefaultEncoding("utf-8");
			multipartRequest = commonsMultipartResolver.resolveMultipart(request);
		}
		return multipartRequest;
	}
	/**
	 * 获取项目根路�?
	 */
	public static String getProjectPath(HttpServletRequest request,String path){
		String projectPath = request.getServletContext().getRealPath(path);
		return projectPath;
	}
	/**
	 * 保存文件�?
	 * 
	 * @param request 
	 * @param path				保存路径（目标文件夹）�??
	 * @param fileName			指定保存文件的文件名（如果已存在则会覆盖原文件，如果留空则随机生成文件名�? 
	 * @param filePrefixName	设置文件前缀名（fileName留空时生效）�?
	 * 
	 * @return					保存成功则返回保存文件名，否则返回error�?
	 */
	public static String fileSaveSrc(MultipartHttpServletRequest multipartRequest,
		String projectPath, String path, String fileName, String filePrefixName) {
		
		// 获取表单内所有文件域(<input name="value"/>)name属�?�的�?(value)
		Iterator<String> names = multipartRequest.getFileNames();
		
		while (names.hasNext()) {
			
			// 获取下一个name属�?��??
			String name = (String) names.next();
			
			System.out.println("文件域name属�?�名�?" + name);
			// 获取文件
			MultipartFile multipartFile = multipartRequest.getFile(name);
			// 确保传入file不是�?
			if (multipartFile != null) {
				// 原始文件�?
				String originalFilename = multipartFile.getOriginalFilename();
				System.out.println("原始文件名：" + originalFilename);
				
				if(originalFilename==null || originalFilename.equals("")){
					return "error";
				}
				// 获取文件后缀�?
				String fileSuffixName = originalFilename.substring(originalFilename.lastIndexOf("."));

				// 如果fileName留空则按�?定格式随机生成保存文件名
				if(fileName == null || fileName.trim().equals("")){
					// 生成时间字符�?"yyyyMMddHHmmss"
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					String timeStr = sdf.format(new Date());
					// 生成100000-999999之间的随机数
					int max = 999999;
					int min = 100000;
					int randomNum = new Random().nextInt(max) % (max - min + 1) + min;
					// 重组保存文件�?
					fileName = filePrefixName + timeStr + randomNum + fileSuffixName;
					
				}
				
				// 完整保存路径+文件�?
				String filePath = projectPath + path + fileName;
				System.out.println("文件绝对路径�?"+filePath);
				// 将文件重新组装起�?
				File file = new File(filePath);
				// 如果没有则创建文�?
				if (!file.exists()) {
					file.mkdirs();
				}
				try {
					// 将文件写入硬�?
					multipartFile.transferTo(file);
				} catch (IOException e) {
					e.printStackTrace();
					file.delete();
					return "error";
				}
				return fileName;// 成功则返回文件相对项目的路径
			}
		}
		return "error";
	}
	/**
	 * 删除文件
	 * 
	 * @param request
	 * @param path		文件相对项目根路径的url（需包含文件名）
	 * @return			删除成功返回1，否则返�?0
	 */
	public static int deleteFile(HttpServletRequest request, String path) {
		String projectPath = request.getServletContext().getRealPath("/");
		// 绝对路径（含文件名）
		String filePath = projectPath + path;
		System.out.println("文件绝对路径�?"+filePath);
		File file = new File(filePath);
		// 有则删除文件
		if (file.exists()) {
			file.delete();
			return 1;
		}
		return 0;
	}
}
