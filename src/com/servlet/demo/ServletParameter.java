package com.servlet.demo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletParameter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("userName"));
		System.out.println(request.getParameter("pwd"));
		System.out.println(request.getParameter("sex"));
		System.out.println(request.getParameter("like"));
		System.out.println(request.getParameter("city"));
		
		System.out.println("........................");
		
		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()){
			System.out.println(names.nextElement());;
		}
		
		System.out.println("........................");
	
		
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
