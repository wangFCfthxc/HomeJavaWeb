package cc.openhome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/HttpSession_Questionnaire")
public class HttpSession_Questionnaire extends HttpServlet {
       
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>HttpSession_Questionnaire</title>");
        out.println("</head>");
        out.println("<body>");
        
        String page = request.getParameter("page");
        
        out.println("<form action='HttpSession_Questionnaire' method='post'>");
        if (page == null) {
            out.println("問題一：<input type='text' name='p1q1'><br>");
            out.println("問題二：<input type='text' name='p1q2'><br>");
            out.println("<input type='submit' name='page' value='下一頁'>");
        } else if ("下一頁".equals(page)) {
        	String p1q1 = request.getParameter("p1q1");
            String p1q2 = request.getParameter("p1q2");
            HttpSession session = request.getSession();
            session.setAttribute("p1q1", p1q1);
            session.setAttribute("p1q2", p1q2);
            out.println("問題三：<input type='text' name='p2q1'><br>");
            out.println("<input type='submit' name='page' value='完成'>");
        }else if ("完成".equals(page)) {
        	String p2q1 = request.getParameter("p2q1");
        	HttpSession session = request.getSession();
        	session.setAttribute("p2q1", p2q1);
            
            out.println(session.getAttribute("p1q1") + "<br>");
            out.println(session.getAttribute("p1q2") + "<br>");
            out.println(session.getAttribute("p2q1") + "<br>");
        }
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
