package com.wzc.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzc.login.dao.ProjectDao;
import com.wzc.login.domain.Project;
import com.wzc.login.domain.User;

@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	private ProjectDao dao = new ProjectDao();

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
					toUpdatePage(request,response);
					break;
				case "select":
					selectAllUsers(request,response);
					break;
				case "insert":
					insertUser(request,response);
					break;
				case "update":
					updateUser(request, response);
					break;
				case "delete":
					deleteUser(request, response);
					break;
				default:selectAllUsers(request,response);
					break;
			}
		}else {
			response.getWriter().print("act参数不能位空，请检查是否传输了该参数！");
		}

	}

	private void toUpdatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		Integer id =Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		Project pro = dao.selectByUserId(id);
		request.setAttribute("updateUser", pro);
		request.getRequestDispatcher("pages/usermgr/project_insert.jsp").forward(request, response);
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Integer userid =Integer.valueOf(request.getParameter("userid"));
		if(dao.delete(userid)){
			request.getSession().setAttribute("resultMSG", "删除成功");
		}else {
			request.getSession().setAttribute("resultMSG", "删除失败");
		}
		response.sendRedirect("ProjectServlet?act=select");
	}


	private void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Project> list = dao.selectByMap(new HashMap<String,Object>(0));
		request.setAttribute("userList", list);
		request.getRequestDispatcher("pages/usermgr/Projt.jsp").forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		  
		
		String user = request.getParameter("user");
		String name = request.getParameter("name");
		String model = request.getParameter("model");

		Project pro = new Project();
		if(user!=null){
			pro.setUser(user);
		}
		if(name!=null){
			pro.setName(name);
		}
		if(model!=null){
			pro.setModel(model);
		}
		
		if(dao.insert(pro)){
			request.getSession().setAttribute("resultMSG", "新增成功");
			response.sendRedirect("ProjectServlet?act=select");
		}else {
			request.getSession().setAttribute("resultMSG", "新增失败");
			request.getRequestDispatcher("pages/usermgr/project_insert_true.jsp").forward(request, response);
		}
	}
	private void updateUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id =request.getParameter("id");
		String user = request.getParameter("user");
		String name = request.getParameter("name");
		String model = request.getParameter("model");
		Project pro = new Project();
		if(id!=null){
			pro.setid(Integer.valueOf(id));
		}
		if(user!=null){
			pro.setUser(user);
		}
		if(name!=null){
			pro.setName(name);
		}
		if(model!=null){
			pro.setModel(model);
		}
		if(dao.update(pro)){
			request.getSession().setAttribute("resultMSG", "修改成功");
			response.sendRedirect("ProjectServlet?act=select");
		}else {
			request.setAttribute("updateUser", pro);
			request.getSession().setAttribute("resultMSG","修改失败");
			request.getRequestDispatcher("pages/usermgr/project_insert_true.jsp").forward(request, response);
		}
	}

}
