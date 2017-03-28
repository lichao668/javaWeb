package com.servlet.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 下载图片
 * @author Administrator
 *
 */

public class ServletDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDownload() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取图片路径
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/img1.jpg");
		// 读取图片的输入流
		FileInputStream fis = new FileInputStream(path);
		// 向客户端响应人输出流
		ServletOutputStream sos = response.getOutputStream();
			
		//设置图片为下载方式打开
		String filename = path.substring(path.lastIndexOf("\\") + 1);
		filename = URLEncoder.encode(filename, "utf-8");
		response.setHeader("content-disposition", "attachment;filename=" + filename);
		response.setHeader("content-type", "image/jpeg");

		// 读取图片并响应给客户端
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = fis.read(buf)) != -1) {
			sos.write(buf, 0, len);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
