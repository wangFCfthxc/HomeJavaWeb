package tw.org.iii.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Panda06")
public class Panda06 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// String username = request.getParameter("username");
		// out.println(username + "<br />");

		String type = request.getContentType();
		int len = request.getContentLength();
		out.print(type + ":" + len + "<br>");
		
		 BufferedReader reader = request.getReader();
		 String line;
		 int i = 1;
		 while ((line = reader.readLine()) != null){
		 out.print(i++ + ">" + line + "<br>");
		 }
		 reader.close();
		
//		InputStream in = request.getInputStream();
//		byte[] buf = new byte[len];
//		in.read(buf);
//		in.close();

//		String cont = new String(buf);
//		out.print(getFilename(cont));
		// out.print(lastFilename(cont));
		// out.print(cont);
	}

	private String getFilename(String body) {
		int start = body.indexOf("filename=\"");
		String temp = body.substring(start + 10);
		String filename = temp.substring(0, temp.indexOf("\""));
		return filename;
	}

	// private String lastFilename(String body) {
	// int start = body.lastIndexOf("filename=\"");
	// String temp = body.substring(start+10);
	// String filename = temp.substring(0, temp.lastIndexOf("\""));
	// return filename;
	// }

}
