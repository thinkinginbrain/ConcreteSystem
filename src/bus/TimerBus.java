package bus;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimerBus extends TimerTask {
	
	HttpServletRequest request;
	HttpServletResponse response;
	
	public TimerBus(HttpServletRequest request,HttpServletResponse response) {
		this.request =request;
		this.response =response;
	}
	public void run(){
        PrintWriter write;
		try {
			write = response.getWriter();
			write.println("我是输出的文字<br>");  
	        write.println("姓名:花2不谢<br/>年龄:20");  
	        write.flush(); 
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}  
        
	}

}
