package cc.openhome;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OutputStream_Down")
public class OutputStream_Down extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passwd = request.getParameter("passwd");
		if("123456".equals(passwd)){
			response.setContentType("application/pdf");
			InputStream in = this.getServletContext().getResourceAsStream(
                    "/upload/jdbc.pdf");
			OutputStream out = response.getOutputStream();
			WriteBytes(in, out);
		}
	}

	private void WriteBytes(InputStream in, OutputStream out) throws IOException{
		byte[] buffer = new byte[1024];
		int length = -1;
		while((length = in.read(buffer)) != -1){
			out.write(buffer, 0, length);
		}
		in.close();
		out.close();
		
	}

}
