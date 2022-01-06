package com.wzc.login.http;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Array;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import com.alibaba.fastjson.JSONArray;
import com.sun.tools.javac.util.List;
import com.wzc.login.domain.Data;

import bus.*;
import mdl.Business;

/**
 * Servlet implementation class TableServlet
 */
@WebServlet("/TableServlet")
public class TableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("启动");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);  

	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    response.setCharacterEncoding("utf-8");  
	        System.out.println("ajax后台交互成功"); 
	        Data da =new Data();
	        TestData read = new TestData();
	        da.data = read.read();	 
	        da.serial = read.readSerial();

	        ArrayList<Data> dataList =new ArrayList<Data>();
	        dataList.add(da);
	        
	        PrintWriter write=response.getWriter();

	        write.print(JSONArray.toJSON(dataList).toString());
//	        write.println(data);
//	        write.println(serial+"号节点出现异常");  
	        write.flush(); 
//	        return;

	}
	

 
}
