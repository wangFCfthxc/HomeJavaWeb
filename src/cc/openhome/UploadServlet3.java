package cc.openhome;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

	// 設定location屬性
@WebServlet("/UploadServlet")
public class UploadServlet3 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");	// 處理中文檔名
		for(Part part : request.getParts()){
			if(part.getName().startsWith("file")){
				String filename = getFilename(part);
				part.write(filename);
			}
		}
		out.println("上傳成功v2");
	}

	private String getFilename(Part part) {
		String header = part.getHeader("Content-Disposition");
		String filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
		return filename;
	}
	
}
