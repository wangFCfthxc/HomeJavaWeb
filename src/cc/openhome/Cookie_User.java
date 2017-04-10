package cc.openhome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie_User")
public class Cookie_User extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		if (request.getAttribute("user") == null) {
			response.sendRedirect("Cookie_login.html");
		}

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01" + " Transitional//EN'>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet User</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + request.getAttribute("user") + "已登入</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}
