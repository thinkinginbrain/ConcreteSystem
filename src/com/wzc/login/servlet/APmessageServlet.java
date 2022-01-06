package com.wzc.login.servlet;

import com.wzc.login.dao.APDao;
import com.wzc.login.domain.APmessage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/APmessageServlet")
public class APmessageServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private APDao dao = new APDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
		Integer userid =Integer.valueOf(request.getParameter("userid"));
		APmessage user = dao.selectByUserId(userid);
		request.setAttribute("updateUser", user);
		request.getRequestDispatcher("pages/usermgr/AP_update.jsp").forward(request, response);
	}

	private void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<APmessage> list = dao.selectByMap(new HashMap<String,Object>(0));
		request.setAttribute("userList", list);
		request.getRequestDispatcher("pages/usermgr/data.jsp").forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String model = request.getParameter("model");
		String ip = request.getParameter("ip");
		String groupmessage = request.getParameter("groupmessage");
		String state = "在线";
		//String state = request.getParameter("state");
		APmessage user = new APmessage();
		if(name!=null){
			user.setname(name);
		}
		if(address!=null){
			user.setAddress(address);
		}
		if(model!=null){
			user.setModel(model);
		}
		if(ip!=null){
			user.setIp(ip);
		}
		if(groupmessage!=null){
			user.setGroupmessage(groupmessage);
		}
		if(state!=null){
			user.setState(state);
		}

		if(dao.insert(user)){
			request.getSession().setAttribute("resultMSG", "新增成功");
			response.sendRedirect("APmessageServlet?act=select");
		}else {
			request.getSession().setAttribute("resultMSG", "新增失败");
			request.getRequestDispatcher("pages/usermgr/APinsert.jsp").forward(request, response);
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		Integer userid =Integer.valueOf(request.getParameter("userid"));
		if(dao.delete(userid)){
			request.getSession().setAttribute("resultMSG", "删除成功");
		}else {
			request.getSession().setAttribute("resultMSG", "删除失败");
		}
		response.sendRedirect("APmessageServlet?act=select");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id =request.getParameter("id");
		String name =request.getParameter("name");
		String address = request.getParameter("address");
		String model = request.getParameter("model");
		String ip = request.getParameter("ip");
		String groupmessage = request.getParameter("groupmessage");
		String state = request.getParameter("state");

		APmessage user = new APmessage();
		if(id!=null){
			user.setid(Integer.valueOf(id));
		}
		if(name!=null){
			user.setname(name);
		}
		if(address!=null){
			user.setAddress(address);
		}
		if(model!=null){
			user.setModel(model);
		}
		if(ip!=null){
			user.setIp(ip);
		}
		if(groupmessage!=null){
			user.setGroupmessage(groupmessage);
		}
		if(state!=null){
			user.setState(state);
		}
		
		if(dao.update(user)){
			request.getSession().setAttribute("resultMSG", "修改成功");
			response.sendRedirect("APmessageServlet?act=select");
		}else {
			request.setAttribute("updateUser", user);
			request.getSession().setAttribute("resultMSG","修改失败");
			request.getRequestDispatcher("pages/usermgr/AP_update.jsp").forward(request, response);
		}
	}

}
