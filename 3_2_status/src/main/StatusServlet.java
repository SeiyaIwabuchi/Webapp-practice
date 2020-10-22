package main;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns= {"/HelloServlet"})
public class StatusServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException{
		status.Status status = new status.Status();
		PrintWriter out = response.getWriter();
		out.println(status.getResult());
	}
}
