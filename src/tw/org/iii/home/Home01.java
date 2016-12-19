package tw.org.iii.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home01")
public class Home01 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// 設定內容類型
		response.setContentType("text/html; charset=UTF-8");
		try {
			// 取得表單資料
			String tmp = request.getParameter("cars");
			String carname = new String(tmp.getBytes("ISO-8859-1"), "UTF-8");
			// 輸出HTML文件
			PrintWriter pw = response.getWriter();
			pw.println("<html>\n" + "<head><title>\n" + carname + "</title></head>\n" + "<body><center>\n" + "<h2>\n"
					+ carname + "</h2>\n" + "感謝您購買本公司的" + carname + "。<br/>\n" + "</center></body>\n" + "</html>\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
