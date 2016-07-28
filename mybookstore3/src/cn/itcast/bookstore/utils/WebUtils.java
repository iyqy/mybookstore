package cn.itcast.bookstore.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import cn.itcast.bookstore.exception.WebException;

public class WebUtils {
	
	private WebUtils(){}

	public static void forward(HttpServletRequest request,HttpServletResponse response, String message) throws ServletException, IOException {

		request.setAttribute("message", message);
		
		request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		
	}
	
	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			// 添加uuid
			String id  = UUID.randomUUID().toString();
			BeanUtils.setProperty(bean, "id", id);

			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (Exception e) {
			throw new WebException(e);
		}
	}
	

	public static void copyBean(Object orig, Object dest) {
		try {
			// ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(dest, orig);
			BeanUtils.setProperty(dest, "id", UUID.randomUUID().toString());
		} catch (Exception e) {
			throw new WebException(e);
		}
	}
	
	// 在封装表单参数的同时 处理文件上传
	public static<T> T doUpload(HttpServletRequest request, Class<T> beanClass) {
		try {
			// 实例化bean
			T bean = beanClass.newInstance();
			// 添加uuid
			String id = UUID.randomUUID().toString();
			BeanUtils.setProperty(bean, "id", id);
			
			// 处理文件上传
			ServletFileUpload fileupload = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> fielitems = fileupload.parseRequest(request);
			
			for(FileItem fileitem : fielitems) {
				if(fileitem.isFormField()) {
					// 普通表单字段
					String name = fileitem.getFieldName();
					String value = fileitem.getString("utf-8");
					BeanUtils.setProperty(bean, name, value);
				} else {
					// 文件上传字段
					String filename = fileitem.getName();
					String extname = filename.substring(filename.lastIndexOf("."));
					// 让文件名唯一
					filename = id + extname;
					
					// 拼写出 webPath
					String webPath = "/images/" + filename;
					// 获得绝对路径
					String path = request.getSession().getServletContext().getRealPath(webPath);
					System.out.println(path);
					// 封装 file
					File file = new File(path);
					// 创建文件
					file.getParentFile().mkdirs();
					file.createNewFile();
					// 流对拷
					InputStream in = fileitem.getInputStream();
					OutputStream out = new FileOutputStream(file);
					Streams.copy(in, out, true);
					// 删除临时文件
					fileitem.delete();
					// 将路径封装到javabean
					BeanUtils.setProperty(bean, fileitem.getFieldName(), webPath);
				}
			}
			
			return bean;
			
		} catch (Exception e) {
			throw new WebException(e);
		}
		
	}
}
