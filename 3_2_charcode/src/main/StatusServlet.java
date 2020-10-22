package main;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns= {"/sts"})
public class StatusServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException{
		status.Status status = new status.Status();
		PrintWriter out = response.getWriter();
		out.println("your fortune is " +status.getResult());
		response.setContentType("text/html;charset=UTF-8");
	}
}