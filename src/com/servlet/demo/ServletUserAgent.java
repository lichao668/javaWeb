package com.servlet.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUserAgent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletUserAgent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求消息头
		String header = request.getHeader("User-Agent");
		if(header.toLowerCase().contains("msie")){
			System.out.println("IE");
		}else if (header.toLowerCase().contains("firefox")) {
			System.out.println("火狐");
		}else if (header.toLowerCase().contains("chrome")) {
			System.out.println("谷歌");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
