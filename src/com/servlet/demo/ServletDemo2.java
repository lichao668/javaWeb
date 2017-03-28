package com.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDemo2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置响应文本字符集
		response.setCharacterEncoding("utf-8");
		//告诉浏览器以何种方式解析响应信息
		response.setHeader("content-type", "text/html;charset=utf-8");
		//设置字符编码简便方式，可以替代上面两行代码
//		response.setContentType("text/html;charset=utf-8");
		
		
		// 字符输出流
		PrintWriter out = response.getWriter();
		//三种方式向客户端响应文本内容
		out.println("中国<br/>");
		out.print("java<br/>");
		out.write("hello<br/>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
