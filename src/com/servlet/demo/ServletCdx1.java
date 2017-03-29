package com.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCdx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCdx1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("我这里没有你要的资源，你可以访问×××");
		// 重定向访问路径
		// response.setStatus(302);
		// response.setHeader("location", "/javaWeb/ServletCdx2");
		// 重定向访问路径，可以替代以上两行代码
//		response.sendRedirect("/javaWeb/ServletCdx2");
		
		//请求转发
		request.getRequestDispatcher("/ServletCdx2").forward(request, response);
		
		
		//获取消息头
		System.out.println(response.getHeader("location"));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}















