package tw.org.iii.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home02")
public class Home02 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			// 取得表單資料
			String tmp = request.getParameter("cars");
			String carname = new String(tmp.getBytes("ISO-8859-1"), "utf-8");
			// 設定內容類型
			response.setContentType("text/html; charset=utf-8");
			// 輸入HTML文件
			PrintWriter pw = response.getWriter();
			if (carname.length() != 0) {
				pw.println("<html>\n" + "<head><title>\n" + carname + "</title></head>\n" + "<body><center>\n"
						+ "<h2>\n" + carname + "</h2>\n" + "感謝您購買本公司的" + carname + "。<br/>\n" + "</center></body>\n"
						+ "</html>\n");
			} else {
				pw.println("<html>\n" + "<head><title>錯誤</title></head>\n" + "<body><center>\n" + "<h2>錯誤</h2>\n"
						+ "<br/>請輸入商品名稱。\n" + "</center></body>\n" + "</html>\n");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
