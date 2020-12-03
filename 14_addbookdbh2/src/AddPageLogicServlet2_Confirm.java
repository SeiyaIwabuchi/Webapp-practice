

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Confirm")
public class AddPageLogicServlet2_Confirm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		DatabaseOperator dbope = new DatabaseOperator();
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//�Z�b�V�����擾
		HttpSession session = request.getSession();
		bean.BookBean bookInfo = (bean.BookBean)session.getAttribute("bookInfo");
		
		out.println(String.format("<h1>���Ёu%s�v��o�^���܂����B<h1>", bookInfo.getTitle()));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
}
