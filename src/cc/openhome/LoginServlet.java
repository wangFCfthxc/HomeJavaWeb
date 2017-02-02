package cc.openhome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	String header = 
			"<html>" +
	        "<head>" +
	        "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>" +
	        "<title>Login Result</title>" +
	        "</head>" +
	        "<body>";
	   String footer =
	        "</body>" +
	        "</html>";

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	                response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        try {
	            String username = request.getParameter("username");
	            String password = request.getParameter("password");
	            out.println(header);
	            if("Panda".equals(username) && "123456".equals(password)) {
	                out.println("<h1>登入成功</h1>");
	            }
	            else {
	                out.println("<h1>登入失敗</h1><br>");
	                out.println("<a href='form.html'>回登入表單</a>");
	            }
	            out.println(footer);
	        } finally {
	            out.close();
	        }
	    }
	}
