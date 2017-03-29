package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CookieDemo1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 获取客户端最后访问时间
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if ("lastAccessTime".equals(cookies[i].getName())) {
					long time = Long.parseLong(cookies[i].getValue());
					out.write("最后访问时间为："+new Date(time).toLocaleString());
				}
			}
		}
		
		//创建cookie，并保存到客户端
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		
		//保存有效时间
		cookie.setMaxAge(60*5);
		//保存
		response.addCookie(cookie);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
