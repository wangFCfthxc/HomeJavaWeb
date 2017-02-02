package tw.org.iii.home;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Sample23_05")
public class Sample23_05 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try{
	         // 取得表單資料
	         String carname = request.getParameter("cars");

	         // 取得Servlet Context
	         ServletContext sc = getServletContext();

	         // 轉交請求
	         if(carname.length() != 0){
	             sc.getRequestDispatcher("/Sample23_05.jsp")
	               .forward(request, response);
	         }
	         else{
	            sc.getRequestDispatcher("/error.html")
	              .forward(request, response);
	         }
	      }
	      catch(Exception e){    
	         e.printStackTrace();
	      }
		
	}




}
