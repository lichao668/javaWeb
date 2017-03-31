package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CookieDelete() {
        super();
    }    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		Cookie cookie = new Cookie("lastAccessTime", "");
		//设置路径，否则将会删除错对象
		cookie.setPath("/");
		cookie.setMaxAge(0);
		
		response.addCookie(cookie);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
