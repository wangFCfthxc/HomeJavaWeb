package tw.org.iii.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Panda02")
public class Panda02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int x, y, result;

		try {
			x = Integer.parseInt(request.getParameter("x"));
			y = Integer.parseInt(request.getParameter("y"));
		} catch (Exception ec) {
			x = 0;
			y = 0;
		}
		result = x + y;
		
		PrintWriter out = response.getWriter();
		out.println("<form>");
		out.println("<input type='text' name='x' value='" + x + "' /> + ");
		out.println("<input type='text' name='y' value='" + y + "' />");
		out.println("<input type='submit' value='=' />");
		out.println("<span>" + result + "<span>");
		out.println("</form>");
		out.flush();
		out.close();
	}

}
