

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getresult")
public class AddPageLogicServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<String> params = new ArrayList<String>();
		//validate
		validate.Validator validator = new validate.Validator();
		for(Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();) {
			params.add(e.nextElement());
		}
		boolean validateResult = validator.requiereCheck(params); //�p�����[�^���`�F�b�N
		for(String paramName : params) validateResult = validator.requiereCheck(paramName, request.getParameterValues(paramName)) && validateResult;
		//�f�[�^�i�[
		dataClasses.BookBean bookInfo = new dataClasses.BookBean();
		bookInfo.setTitle(request.getParameter("title"));
		bookInfo.setWriter(request.getParameter("writer"));
		bookInfo.setPublisher(request.getParameter("publisher"));
		bookInfo.setRemarks(request.getParameter("remarks"));
		try {
			bookInfo.setPrice(Integer.parseInt(request.getParameter("price")));
		}catch(NumberFormatException e){
			
		}
		//�W����������
		boolean[] genre_checked = {false,false,false,false,false};
		if(request.getParameterValues("genre") != null) {
			for (String s : request.getParameterValues("genre")) {
				genre_checked[Integer.parseInt(s)] = true;
			}
		}
		bookInfo.setGenre(genre_checked);
		bookInfo.setStock(request.getParameter("stock").equals("0")?false:true);
		bookInfo.setValidateResult(validateResult);
		if(validateResult) {
			//�t�H���[�h
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/greeting-out.jsp");//��ʑJ�ڏ���
			request.setAttribute("bookInfo", bookInfo);//���͏������̉�ʂɈ����p��
			dispatcher.forward(request, response);
		}else {
			//out.println(validator.getErrors());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/greeting-in.jsp");//��ʑJ�ڏ���
			request.setAttribute("bookInfo", bookInfo);//���͏������̉�ʂɈ����p��
			request.setAttribute("errors", validator.getErrors().toString());//�G���[�\���������p��
			dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
}