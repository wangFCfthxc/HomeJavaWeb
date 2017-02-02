package tw.org.iii.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Panda01
 */
@WebServlet("/Panda01")
public class Panda01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doTask(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doTask(request,response);
	}
	
	private void doTask(HttpServletRequest request, HttpServletResponse response){
		Enumeration<String> headers =  request.getHeaderNames();
		while ( headers.hasMoreElements()){
			String header = headers.nextElement();
			System.out.println(header + " : " + request.getHeader(header));
		}
		
		
		try {
			PrintWriter out = response.getWriter();
			out.write("Hello, Panda01");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
