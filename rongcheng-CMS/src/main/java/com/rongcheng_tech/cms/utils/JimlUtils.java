package com.rongcheng_tech.cms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 
 * @author jxb
 *
 */
public class JimlUtils {

	/**
	 * 获取项目根路径（重载方法1）
	 * 
	 * @param request
	 * @return
	 */
	public static String getProjectPath(HttpServletRequest request) {
		return request.getServletContext().getRealPath(File.separator);
	}

	/**
	 * 获取项目根路径（重载方法2）
	 *
	 * @param classFullName
	 *            类全名
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static String getProjectPath(String classFullName) throws ClassNotFoundException {
		return Class.forName(classFullName).getResource(File.separator).getPath().replaceAll("^(" + File.separator + ")|(" + File.separator + "WEB-INF" + File.separator + "classes" + File.separator + ")$", "");
	}

	/**
	 * 将HttpServletRequest 转换为 MultipartHttpServletRequest ，当有文件上传时需要此转换。
	 * （当在springMVC配置文件中配置了 
	 * 		<bean id="multipartResolver" class= "org.springframework.web.multipart.commons.CommonsMultipartResolver"></bean>
	 *   时，不再需要此步骤。
	 *  ）
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
	 * 保存请求头内所有文件（文件名随机）。
	 * 
	 * @param request
	 * @param path
	 *            文件保存目录路径（相对项目根目录）。
	 * @param filePrefixName
	 *            设置文件前缀名。
	 * 
	 * @return 保存成功后返回 Map<文件域name属性名, 已保存的文件的文件名>，失败返回null（中途保存失败会删除已保存的内容）。
	 */
	public static Map<String, String> fileSaveSrc(HttpServletRequest request, String path, String filePrefixName) {
		MultipartHttpServletRequest multipartRequest = requestTransition(request);
		// 获取表单内所有文件域(<input name="value"/>)name属性的值(value)
		Iterator<String> names = multipartRequest.getFileNames();
		// 已保存的文件对象的缓存，便于有保存失败时删除已保存的文件。
		List<File> maybeDeleteFileTemp = new ArrayList<File>();
		// 保存成功后返回 文件域name属性名 对应 已保存的文件的文件名
		Map<String, String> map = new HashMap<String, String>();

		while (names.hasNext()) {

			// 获取下一个name属性值
			String name = (String) names.next();

			System.out.println("文件域name属性名：" + name);
			// 获取文件
			MultipartFile multipartFile = multipartRequest.getFile(name);
			// 确保传入file不是空
			if (multipartFile != null) {
				// 原始文件名
				String originalFileName = multipartFile.getOriginalFilename();
				// 获取文件后缀名
				String fileSuffixName = originalFileName.substring(originalFileName.lastIndexOf("."));
				// 生成时间字符串"yyyyMMddHHmmss"
				SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
				String timeStr = sdf.format(new Date());
				// 生成1000-9999之间的随机数
				int max = 10000;
				int min = 1000;
				int randomNum = new Random().nextInt(max - min) + min;
				// 重组新的文件名
				String newFileName = filePrefixName + timeStr + randomNum + fileSuffixName;
				// 文件保存目录路径
				String savePath = getProjectPath(multipartRequest) + path;
				// 创建文件对象
				File uploadedFile = new File(savePath, newFileName);
				// 如果硬盘没有此文件则创建文件
				if (!uploadedFile.exists()) {
					uploadedFile.mkdirs();
				}
				try {
					// 将文件写入硬盘
					multipartFile.transferTo(uploadedFile);
					maybeDeleteFileTemp.add(uploadedFile);
				} catch (IOException e) {
					e.printStackTrace();
					// 清除已保存的文件
					for (File deleteFile : maybeDeleteFileTemp) {
						deleteFile.delete();
					}
					return null;
				}
				map.put(name, newFileName);
			}
		}
		return map;
	}

	
	/**
	 * 保存请求头内所有文件（文件名使用文件域name属性名(相对项目根目录的文件路径)的文件名称，会覆盖旧文件）。
	 * 
	 * @param request
	 * @param path
	 *            文件保存目录路径（相对项目根目录）。
	 * @param fileLastName
	 *            设置文件结尾名称。
	 * @return 保存成功后返回 Map<文件域name属性名, 已保存的文件的文件名>，失败返回null（中途更新失败不会恢复已更新的内容）。
	 */
	public static Map<String, String> fileSaveSrc2(HttpServletRequest request, String path, String fileLastName) {
		MultipartHttpServletRequest multipartRequest = requestTransition(request);
		// 获取表单内所有文件域(<input name="value"/>)name属性的值(value)
		Iterator<String> names = multipartRequest.getFileNames();
		// 保存成功后返回 文件域name属性名 对应 已保存的文件的文件名
		Map<String, String> map = new HashMap<String, String>();

		while (names.hasNext()) {

			// 获取下一个name属性值
			String name = (String) names.next();

			System.out.println("文件域name属性名：" + name);
			// 获取文件
			MultipartFile multipartFile = multipartRequest.getFile(name);
			
			String fileName = "";
			/*if(name.contains(File.separator)){
				fileName = name.substring(name.lastIndexOf(File.separator)+1, name.lastIndexOf("."));
			}else{
				fileName = name.substring(0, name.lastIndexOf("."));
			}*/
			fileName = name;
			// 确保传入file不是空
			if (multipartFile != null && !multipartFile.getOriginalFilename().equals("")) {
				// 原始文件名
				String originalFileName = multipartFile.getOriginalFilename();
				System.out.println(originalFileName);
				// 获取文件后缀名
				String fileSuffixName = originalFileName.substring(originalFileName.lastIndexOf("."));
				// 文件保存目录路径
				String savePath = getProjectPath(multipartRequest) + path;
				// 创建删除文件对象
				//File deleteFile = new File(savePath, name);
				//deleteFile.delete();
				// 创建保存文件对象
				File uploadedFile = new File(savePath, fileName+fileLastName+fileSuffixName);
				// 如果硬盘没有此文件则创建文件
				if (!uploadedFile.exists()) {
					uploadedFile.mkdirs();
				}
				try {
					// 将文件写入硬盘
					multipartFile.transferTo(uploadedFile);
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
				map.put(name, fileName+fileLastName+fileSuffixName);
			}
		}
		return map;
	}
	/**
	 * 保存请求头内单个文件（只保存文件域内第一个文件）
	 * 
	 * @param request
	 * @param path
	 *            文件保存目录路径（相对项目根目录）。
	 * @param fileName
	 *            设置文件名称。
	 * @return 保存成功后返回 Map<文件域name属性名, 已保存的文件的文件名>，失败返回null。
	 */
	public static Map<String, String> fileSaveSingle(HttpServletRequest request, String path, String fileName) {
		MultipartHttpServletRequest multipartRequest = requestTransition(request);
		// 获取表单内所有文件域(<input name="value"/>)name属性的值(value)
		Iterator<String> names = multipartRequest.getFileNames();
		// 保存成功后返回 文件域name属性名 对应 已保存的文件的文件名
		Map<String, String> map = new HashMap<String, String>();
		
		while (names.hasNext()) {
			
			// 获取下一个name属性值
			String name = (String) names.next();
			
			System.out.println("文件域name属性名：" + name);
			// 获取文件
			MultipartFile multipartFile = multipartRequest.getFile(name);
			
			// 确保传入file不是空
			if (multipartFile != null && !multipartFile.getOriginalFilename().equals("")) {
				// 原始文件名
				String originalFileName = multipartFile.getOriginalFilename();
				System.out.println(originalFileName);
				// 获取文件后缀名
				String fileSuffixName = originalFileName.substring(originalFileName.lastIndexOf("."));
				// 文件保存目录路径
				String savePath = getProjectPath(multipartRequest) + path;
				// 创建删除文件对象
				//File deleteFile = new File(savePath, name);
				//deleteFile.delete();
				// 创建保存文件对象
				File uploadedFile = new File(savePath, fileName+fileSuffixName);
				// 如果硬盘没有此文件则创建文件
				if (!uploadedFile.exists()) {
					uploadedFile.mkdirs();
				}
				try {
					// 将文件写入硬盘
					multipartFile.transferTo(uploadedFile);
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
				map.put(name, fileName+fileSuffixName);
			}
		}
		return map;
	}
	
	
	/**
	 * 复制文件（都是绝对路径）
	 * 
	 * @param originalFile
	 *            源文件
	 * @param targetFile
	 *            目标文件（如果存在会覆盖）
	 * @return 复制成功返回true，否则将抛出异常。
	 * @throws IOException 
	 */
	public static boolean copyFile(String originalFile, String targetFile) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			String path = targetFile.substring(0, targetFile.lastIndexOf("/"));
			File file = new File(path);
			File file1 = new File(targetFile);
			// 如果没有则创建文件
			if (!file.exists()) {
				file.mkdirs();
				if (!file1.exists()) {
					file1.createNewFile();
				}
			}
			fis = new FileInputStream(originalFile);
			fos = new FileOutputStream(targetFile);
			int d = -1;
			while ((d = fis.read()) != -1) {
				fos.write(d);
			}
		
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	///////// 删除-开始/////////////
	/**
	 * 删除 文件夹 或 文件（删除成功后会逐层删除与之有直接联系的父类空文件夹。）
	 * 
	 * @param path
	 *            文件绝对路径
	 * @return 不存在或删除成功返回true，否则返回false
	 */
	public static boolean delete(String filePath) {
		String directoryPath = filePath.substring(0, filePath.lastIndexOf(File.separator));// 文件所在文件夹路径;
		File file = new File(filePath);
		File directory = new File(directoryPath);
		boolean flag = true;
		if (file.exists()) {// 目录或文件存在
			if (!file.delete()) return false;// 删除失败
			flag = directory.delete();// 所在文件夹如果为空则删除空文件夹，返回true
		}
		while(flag){
			directoryPath = directoryPath.substring(0, directoryPath.lastIndexOf(File.separator));// 文件所在文件夹路径;
			directory = new File(directoryPath);
			flag=directory.delete();// 所在文件夹如果为空则删除空文件夹，返回true
		}
		return true;
	}

	/**
	 * 清空 文件夹 或 删除文件
	 * 
	 * @param path
	 *            绝对路径
	 * 
	 * @return 不存在或者清除/删除成功返回true，否则返回false。
	 */
	public static boolean emptyFile(String path) {
		File folder = new File(path);
		if (!folder.exists()) {// 此抽象路径名表示的文件或目录不存在
			return true;
		}
		if (folder.isDirectory()) {// 此抽象路径名表示的是一个目录
			// 返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。
			String[] nameList = folder.list();
			File temp = null;
			for (String name : nameList) {
				if (path.endsWith(File.separator)) {
					temp = new File(path + name);
					System.out.println(1);
				} else {
					temp = new File(path + File.separator + name);
				}
				if (temp.isDirectory()) {// 此抽象路径名表示的是一个目录
					// 先删除文件夹里面的文件
					if (!emptyFile(path + File.separator + name)) {// 删除失败
						return false;
					}
					// 再删除空文件夹
					if (!new File(path + File.separator + name).delete()) {// 删除失败
						return false;
					}
				} else {// 此抽象路径名表示的是一个文件
					if (!temp.delete()) {
						return false;
					}
				}
			}
			return true;
		} else {// 此抽象路径名表示的是一个文件
			return folder.delete();
		}
	}

	/**
	 * 删除 文件夹 或 文件
	 * 
	 * @param path
	 *            绝对路径
	 * 
	 * @return 不存在或者删除成功返回true，否则返回false。
	 */
	public static boolean deleteFile(String path) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				return true;
			}
			if (file.isDirectory()) {// 是目录
				emptyFile(path); // 删除目标文件夹下所有内容
				System.out.println(1);
				return new File(path).delete(); // 删除空的目标文件夹
			}
			// 是文件
			System.out.println(2);
			return new File(path).delete(); // 删除文件
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	///////// 删除-结束/////////////
	
	/**
	 * 获取客户端ip
	 *
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if ("".equals(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			int index = ip.indexOf(",");
			if (index != -1)
				return ip.substring(0, index).equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip.substring(0, index);
			else
				return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
		}
		ip = request.getHeader("X-Real-IP");
		if ("".equals(ip) && !"unKnown".equalsIgnoreCase(ip))
			return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
		else
			return request.getRemoteAddr().equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : request.getRemoteAddr();
	}
	
//////主内容编辑使用/////////////////////////////////////////////
	// URL取出
	public static List<String> findURL(Pattern pattern, String text) {
		List<String> list = new ArrayList<String>();
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			String s = matcher.group();
			s = s.substring(0, s.length() - 1);
			list.add(s);
		}
		return list;
	}

	////////////////////////////////////////////////////
}
