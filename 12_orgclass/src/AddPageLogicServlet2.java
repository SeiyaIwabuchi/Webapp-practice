

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
		boolean validateResult = validator.requiereCheck(params); //パラメータ数チェック
		for(String paramName : params) validateResult = validator.requiereCheck(paramName, request.getParameterValues(paramName)) && validateResult;
		//データ格納
		dataClasses.BookBean bookInfo = new dataClasses.BookBean();
		bookInfo.setTitle(request.getParameter("title"));
		bookInfo.setWriter(request.getParameter("writer"));
		bookInfo.setPublisher(request.getParameter("publisher"));
		bookInfo.setRemarks(request.getParameter("remarks"));
		try {
			bookInfo.setPrice(Integer.parseInt(request.getParameter("price")));
		}catch(NumberFormatException e){
			
		}
		//ジャンル処理
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
			//フォワード
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/greeting-out.jsp");//画面遷移準備
			request.setAttribute("bookInfo", bookInfo);//入力情報を次の画面に引き継ぐ
			dispatcher.forward(request, response);
		}else {
			//out.println(validator.getErrors());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/greeting-in.jsp");//画面遷移準備
			request.setAttribute("bookInfo", bookInfo);//入力情報を次の画面に引き継ぐ
			request.setAttribute("errors", validator.getErrors().toString());//エラー表示も引き継ぐ
			dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
}