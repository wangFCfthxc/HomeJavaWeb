package cc.openhome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Pet")
public class Pet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	// 設定請求物件字元編碼
		response.setContentType("text/html;charset=UTF-8");	// 設定內容類型
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
        out.println("<head>");
        out.println("<title>感謝填寫</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("聯絡人：<a href='mailto:"+
                request.getParameter("email") + "'>" +
                request.getParameter("user") + "</a>");
        out.println("<br>喜愛的寵物類型");
        out.println("<ul>");
        for(String type : request.getParameterValues("type")) {
            out.println("<li>" + type + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
        out.close();
	}

}
