package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoUserName() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String userName =  request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String remember = request.getParameter("remember");
		
		
		PrintWriter out = response.getWriter();
		out.println(userName);
		out.println(pwd);
		out.println(remember);
		Cookie cookie = new Cookie("userName", userName);
		cookie.setPath("/");
		if (remember != null) {
			cookie.setMaxAge(1*60*60);
		}else{
			cookie.setMaxAge(0);//删除cookie
		}
		response.addCookie(cookie);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
