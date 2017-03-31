package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JinZhuUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JinZhuUserName() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName = "";
		String check = "";
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if ("userName".equals(cookies[i].getName())) {
					 userName = cookies[i].getValue();
					 check = "checked='checked'";
				}
			}
		}

		out.write("<form action='/javaWeb/DoUserName' method='post'>");
		out.write("用户名<input type='text' name='userName' value="+userName+"/><br/>");
		out.write("密码<input type='text' name='pwd'/><br/>");
		out.write("记住用户名密码<input type='checkbox' name='remember'"+check+"/><br/>");
		out.write("<input type='submit' value='提交'/><br/>");
		out.write("</form>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
