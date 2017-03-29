package com.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletRefresh() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置自动刷新
		// response.setIntHeader("refresh", 1);
		//三秒自动跳转到指定页面
		response.setHeader("refresh", "3;url=/javaWeb/");

		PrintWriter out = response.getWriter();
		out.write(new Random().nextInt() + "");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
