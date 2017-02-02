package tw.org.iii.home;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home04")
public class Home04 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		// 取得表單資料
		String carname = request.getParameter("cars");
		// 取得Servlet Context
		ServletContext sc = getServletContext();
		// 轉交請求
		
		
		
		if(carname.length() != 0){
//			if(carname != null){
				
				
				
			sc.getRequestDispatcher("/thanks.html").forward(request, response);
		}
		else{
			sc.getRequestDispatcher("/error.html").forward(request, response);
		}
	}

}
