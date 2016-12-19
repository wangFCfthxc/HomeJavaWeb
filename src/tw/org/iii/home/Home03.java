package tw.org.iii.home;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Home03")
public class Home03 extends HttpServlet {
	private Date dt;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try{
	         // 取得Session
	         HttpSession hs = request.getSession(true);	
	         Integer cn = (Integer) hs.getAttribute("count");	
	         dt = (Date) hs.getAttribute("date");	

	         String str1, str2;

	         // 設定次數
	         if(cn == null){
	            cn = new Integer(1);
	            dt = new Date();
	            str1 = "這是您的初次造訪。";
	            str2 = "";
	         }
	         else{
	            cn = new Integer(cn.intValue() + 1);
	            dt = new Date();
	            str1 = "這是您的第" + cn + "次造訪。";
	            str2 = "(上次是在：" + dt + ")";
	         }
	     
	         // 設定Session
	         hs.setAttribute("count", cn);
	         hs.setAttribute("date", dt);

	         // 設定內容類型
	         response.setContentType("text/html; charset=UTF-8");

	         // 輸出HTML文件
	         PrintWriter pw = response.getWriter();
	         pw.println("<html>\n" +
	                    "<head><title>範例</title></head>\n" +
	                    "<body><center>\n" +
	                    "<h2>歡迎光臨</h2>" +
	                    "<hr />\n" +
	                    str1 + "<br/>\n" +
	                    str2 + "<br/>\n" +
	                    "請選擇一件商品。<br/>\n" +
	                    "<br/>\n" +
	                    "<a href=\"../car1.html\">汽車</a><br/>\n" +
	                    "<a href=\"../car2.html\">卡車</a><br/>\n" +
	                    "<a href=\"../car3.html\">戰車</a><br/>\n" +
	                    "</center></body>\n" +
	                    "</html>\n");
	        }
	        catch(Exception e){    
	          e.printStackTrace();
	       }
	}

}
