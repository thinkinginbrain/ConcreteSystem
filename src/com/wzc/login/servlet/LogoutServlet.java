package com.wzc.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzc.login.dao.LogtimeDao;
import com.wzc.login.domain.Logintime;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
    	super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//记录登出时间
		LogtimeDao logDao=new LogtimeDao(); 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println("1");
		// new Date()为获取当前系统时间 df.format(new Date())
		Boolean i =logDao.updateMaxId((String)df.format(new Date()));
		System.out.println(i);
		System.out.println(df.format(new Date()));
		request.getSession().removeAttribute("user");
		response.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        //记录登出时间
				LogtimeDao logDao=new LogtimeDao(); 
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				System.out.println("2");
				// new Date()为获取当前系统时间 df.format(new Date())
				logDao.updateMaxId(df.format(new Date()));
		        doGet(request, response);
	}

}
