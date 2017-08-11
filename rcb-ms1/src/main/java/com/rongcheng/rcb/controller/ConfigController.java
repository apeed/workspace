package com.rongcheng.rcb.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rongcheng.rcb.entity.Config;
import com.rongcheng.rcb.service.Config.ConfigService;
import com.rongcheng.rcb.utils.FileTool;
@Controller
@RequestMapping("/admin")
public class ConfigController {
	@Resource
	private ConfigService configService;
	
	@RequestMapping("/info.do")
	public String info(HttpServletRequest request) {
		List<Config> list = configService.listConfig();
		request.setAttribute("configList", list);
		return "backstage/info";
	}
	
	@RequestMapping("/set.do")
	public void set(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		try {
			out = response.getWriter();

			MultipartHttpServletRequest multipartRequest = FileTool.requestTransition(request);

			Map<String, String[]> map = multipartRequest.getParameterMap();
			String projectPath = request.getServletContext().getRealPath("/");
			String result = saveFile(multipartRequest, projectPath + "images/");
			if (result != null && !result.equals("error")) {// logo图片保存成功
				map.put("logo", new String[] { "images/" + result });
			}
			int n = configService.modifyConfig(map);
			out.print(n);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	
	
	public static String saveFile(MultipartHttpServletRequest multipartRequest,String path) {
			
			// 获取表单内所有文件域(<input name="value"/>)name属性的值(value)
			Iterator<String> names = multipartRequest.getFileNames();
			
			while (names.hasNext()) {
				
				// 获取下一个name属性值
				String name = (String) names.next();
				
				System.out.println("文件域name属性名：" + name);
				// 获取文件
				MultipartFile multipartFile = multipartRequest.getFile(name);
				// 确保传入file不是空
				if (multipartFile != null) {
					// 原始文件名
					String originalFilename = multipartFile.getOriginalFilename();
					System.out.println("原始文件名：" + originalFilename);
					
					if(originalFilename==null || originalFilename.equals("")){
						return "error";
					}
					// 获取文件后缀名
					String fileSuffixName = originalFilename.substring(originalFilename.lastIndexOf("."));

					// 完整保存路径+文件名
					String filePath = path + "logo"+fileSuffixName;
					System.out.println("文件绝对路径："+filePath);
					// 将文件重新组装起来
					File file = new File(filePath);
					// 如果没有则创建文件
					if (!file.exists()) {
						file.mkdirs();
					}
					try {
						// 将文件写入硬盘
						multipartFile.transferTo(file);
					} catch (IOException e) {
						e.printStackTrace();
						file.delete();
						return "error";
					}
					return "logo"+fileSuffixName;// 成功则返回文件名
				}
			}
			return "error";
		}
}
