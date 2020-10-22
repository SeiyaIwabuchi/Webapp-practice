import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/kadai4/sts"})
public class OmojanServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,
				HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>HTMLサーブレット</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY bgcolor=\"gray\">");
		out.println(new Omojan().getWord());
		out.println("</BODY>");
		out.println("</HTML>");
	}
}
