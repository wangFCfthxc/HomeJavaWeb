package cc.openhome;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderServlet
 */
@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
        out.println("<head>");
        out.println("<title>HeaderServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>HeaderServlet at " +
        		request.getContextPath() + "</h1>");
        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
        	String name = names.nextElement();
            out.println(name + ": " + request.getHeader(name) + "<br>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
	}




}
