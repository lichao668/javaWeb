package com.servlet.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码
 * 
 * @author Administrator
 *
 */
public class ServletYanZhengMa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletYanZhengMa() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置浏览器不缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		
		int width = 110;
		int height = 25;

		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 创建画笔
		Graphics g = img.getGraphics();
		// 图片背景
		g.setColor(Color.GRAY);
		g.fillRect(1, 1, width - 2, height - 2);

		// 图片边框
		g.setColor(Color.RED);
		g.drawRect(1, 1, width - 2, height - 2);

		// 给图片添加文本
		g.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 15));
		g.setColor(Color.WHITE);
		Random rand = new Random();
		int position = 0;
		for (int i = 0; i < 4; i++) {
			g.drawString(rand.nextInt(10) + "", position += 20, 20);
		}
		
		//添加干扰线
		for (int i = 0; i < 6; i++) {
			g.setColor(Color.lightGray);
			g.drawLine(rand.nextInt(width), rand.nextInt(height),
					rand.nextInt(width), rand.nextInt(height));
		}

		// 将图片响应给客户端
		ImageIO.write(img, "jpg", response.getOutputStream());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
