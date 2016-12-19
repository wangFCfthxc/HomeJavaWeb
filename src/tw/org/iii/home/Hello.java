package tw.org.iii.home;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Hello() {
		System.out.println("Hello()");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service()");

		try {
			HttpServletRequest req = (HttpServletRequest) request;
			String method = req.getMethod();
			System.out.println(method);
			Enumeration<String> ps = req.getParameterNames();
			while (ps.hasMoreElements()) {
				String item = ps.nextElement();
				String value = req.getParameter(item);
				System.out.println(item + " => " + value);
			}

		} catch (ClassCastException ce) {
			System.out.println(ce.toString());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		System.out.println("doGet()2");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		System.out.println("doPost()");
	}

}
