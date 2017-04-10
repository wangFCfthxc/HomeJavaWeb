package cc.openhome;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Cookie_Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String passwd = request.getParameter("passwd");
		if("Panda".equals(user) && "123456".equals(passwd)) {
			String login = request.getParameter("login");
			if ("auto".equals(login)) {
				Cookie cookie = new Cookie("user", "Panda");
                cookie.setMaxAge(10);
                response.addCookie(cookie);
			}
			request.setAttribute("user", user);
            request.getRequestDispatcher("Cookie_User").forward(request, response);
		}
		else{
			response.sendRedirect("Cookie_login.html");
		}
	}

}
