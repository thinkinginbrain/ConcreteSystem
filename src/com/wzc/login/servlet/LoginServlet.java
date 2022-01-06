package com.wzc.login.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzc.login.dao.UserDao;
import com.wzc.login.domain.User;
import com.wzc.login.dao.LogtimeDao;
import com.wzc.login.domain.Logintime;

/**
 * @description 登录请求处理类
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//接收表单信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verifyc  = request.getParameter("verifycode");
		//设置回显
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("verifycode", verifyc);
		//获取验证码
		String svc =(String) request.getSession().getAttribute("sessionverify");
		//根据用户名查询用户
		User user =new UserDao().selectByUsername(username);
		if(!svc.equalsIgnoreCase(verifyc)){
			request.setAttribute("loginError", "* 验证码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if(user!=null){
			if(user.getPassword().equals(password)){
				request.getSession().setAttribute("user", user);
				//记录登录时间
				LogtimeDao logDao=new LogtimeDao(); 
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				Logintime logintime =new Logintime();
				logintime.setUsername(username);
				logintime.setLoginTime(df.format(new Date()));// new Date()为获取当前系统时间
           //     logintime.setLogoutTime("0");
                logDao.insert(logintime);
                
				if(username.equals("admin")||username.equals("2018012991")) {
					response.sendRedirect("index.jsp");
				}else {
					response.sendRedirect("indexs.jsp");
				}
			}else {
				request.setAttribute("loginError", "* 密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("loginError", "* 用户不存在");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
