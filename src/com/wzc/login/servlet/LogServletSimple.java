package com.wzc.login.servlet;

import com.wzc.login.dao.LogtimeDao;
import com.wzc.login.domain.Logintime;
import com.wzc.login.domain.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
@WebServlet("/LogServletSimple")
public class LogServletSimple extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LogtimeDao dao = new LogtimeDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String act =request.getParameter("act");
		if(act!=null){
			//根据传输的act调用不同的方法进行处理
			switch (act) {
				case "toUpdatePage":
	//				toUpdatePage(request,response);
					break;
				case "select":
					selectAllUsers(request,response);
					break;
				case "insert":
		//			insertUser(request,response);
					break;
				case "update":
		//			updateUser(request, response);
					break;
				case "delete":
		//			deleteUser(request, response);
					break;
				default:selectAllUsers(request,response);
					break;
			}
		}else {
			response.getWriter().print("act参数不能位空，请检查是否传输了该参数！");
		}

	}


//	
	private void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Logintime> list = dao.selectByMap(new HashMap<String,Object>(0));
		request.setAttribute("logList", list);
		request.getRequestDispatcher("pages/usermgr/logSimple.jsp").forward(request, response);
	}
}
