package cc.openhome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Questionnaire")
public class Questionnaire extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Questionnaire</title>");
        out.println("</head>");
        out.println("<body>");
        
        String page = request.getParameter("page");
        
        out.println("<form action='Questionnaire' method='get'>");
        if (page == null) {
            out.println("問題一：<input type='text' name='p1q1'><br>");
            out.println("問題二：<input type='text' name='p1q2'><br>");
            out.println("<input type='submit' name='page' value='下一頁'>");
        } else if ("下一頁".equals(page)) {
            String p1q1 = request.getParameter("p1q1");
            String p1q2 = request.getParameter("p1q2");
            out.println("問題三：<input type='text' name='p2q1'><br>");
            out.println("<input type='hidden' name='p1q1' value='" + p1q1 + "'>");
            out.println("<input type='hidden' name='p1q2' value='" + p1q2 + "'>");
            out.println("<input type='submit' name='page' value='完成'>");
        } else if ("完成".equals(page)) {
            out.println(request.getParameter("p1q1") + "<br>");
            out.println(request.getParameter("p1q2") + "<br>");
            out.println(request.getParameter("p2q1") + "<br>");
        }
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
        out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}




}
