package cc.openhome;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Cookie_Index")
public class Cookie_Index extends HttpServlet {
	protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();	//	取得Cookie
		if(cookies != null) {
			for(Cookie cookie : cookies){
				String name = cookie.getName();
                String value = cookie.getValue();
                if("user".equals(name) && "Panda".equals(value)) {
                	request.setAttribute(name, value);
                    request.getRequestDispatcher("/Cookie_User").forward(request, response);
                    return;
                }
			}
		}
		response.sendRedirect("Cookie_login.html");	//	如果沒有相對應的Cookie名稱與數值 表示未允許自動登入 重新導向至Login
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
