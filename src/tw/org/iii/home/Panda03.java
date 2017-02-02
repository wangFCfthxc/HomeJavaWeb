package tw.org.iii.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Panda03")
public class Panda03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x, y, result = 0, op, result2 = 0;
		try{
			x = Integer.parseInt(request.getParameter("x"));
			op = Integer.parseInt(request.getParameter("op"));
			y = Integer.parseInt(request.getParameter("y"));
		}catch(Exception ec){
			x=0; y=0; op=1;
		}
		
		switch(op){
		default:
		case 1: result = x + y; break;
		case 2: result = x - y; break;
		case 3: result = x * y; break;
		case 4: result = x / y; break;
		}
		
		switch(op){
		case 4: result2 = x % y; break;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<form>");
		out.println("<input type='text' name='x' value='" + x + "' />");
		out.println("<select name='op'>");
		out.println("<option value='1' "+ (op==1?"selected":"") +">+</option>");
		out.println("<option value='2' "+ (op==2?"selected":"") +">-</option>");
		out.println("<option value='3' "+ (op==3?"selected":"") +">x</option>");
		out.println("<option value='4' "+ (op==4?"selected":"") +">/</option>");
		out.println("</select>");
		out.println("<input type='text' name='y' value='" + y + "' />");
		out.println("<input type='submit' value='=' />");
		
		if(result2 == 0){
			out.println("<span>" + result + "<span>");
			
		}else{
			out.println("<span>" + result + "......" + result2 + "<span>");
		}
		out.println("</form>");
		out.flush();
		out.close();
	}


}
