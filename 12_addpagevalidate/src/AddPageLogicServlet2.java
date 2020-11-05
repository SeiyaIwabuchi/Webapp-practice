

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
		if(validateResult) {
			//ジャンル処理
			boolean[] genre_checked = {false,false,false,false,false};
			for (String s : request.getParameterValues("genre")) {
				genre_checked[Integer.parseInt(s)] = true;
			}
			String stock_checked = request.getParameter("stock");
			//表示
			out.println("<html>");
			out.println("<head>");
			out.println(" <title>書籍登録確認画面</title>");
			out.println("</head>");
			out.println("<body>");
			out.println(" <h2>■書籍在庫管理システム</h2>");
			out.println(" <h3> 【書籍登録確認画面】</h3>");
			out.println(" <form action=\"pages/addpage.jsp\">");
			out.println(" <table>");
			out.println(" <tr><td> </td><td>タイトル</td><td><input type=\"text\" name=\"title\" disabled=\"disabled\" value=\"" + request.getParameter(params.get(0)) + "\"/></td></tr>");
			out.println(" <tr><td></td><td>著者</td><td><input type=\"text\" name=\"writer\" disabled=\"disabled\"  value=\"" + request.getParameter(params.get(1)) + "\"/></td></tr>");
			out.println(" <tr><td></td><td>出版社</td><td><input type=\"text\" name=\"publisher\" disabled=\"disabled\"  value=\"" + request.getParameter(params.get(2)) + "\"/></td></tr>");
			out.println(" <tr><td></td><td>価格</td><td><input type=\"text\" name=\"price\" disabled=\"disabled\"  value=\"" + request.getParameter(params.get(3)) + "\"/></td></tr>");
			out.println(" <tr><td></td><td>ジャンル</td><td>");
			out.println(" <input type=\"checkbox\" name=\"genre\" value=\"0\" "+(genre_checked[0]?"checked":"")+"  disabled=\"disabled\" />文芸");
			out.println(" <input type=\"checkbox\" name=\"genre\" value=\"1\" "+(genre_checked[1]?"checked":"")+" disabled=\"disabled\" />実用");
			out.println(" <input type=\"checkbox\" name=\"genre\" value=\"2\" "+(genre_checked[2]?"checked":"")+" disabled=\"disabled\" />ビジネス");
			out.println(" <input type=\"checkbox\" name=\"genre\" value=\"3\" "+(genre_checked[3]?"checked":"")+" disabled=\"disabled\" />教養");
			out.println(" <input type=\"checkbox\" name=\"genre\" value=\"4\" "+(genre_checked[4]?"checked":"")+" disabled=\"disabled\" />趣味</td></tr>");
			out.println(" <tr><td></td><td>在庫</td><td>");
			out.println(" <input type=\"radio\" name=\"stock\" value=\"1\" " + (stock_checked.equals("1")? "checked":"") + " disabled=\"disabled\" />あり");
			out.println(" <input type=\"radio\" name=\"stock\" value=\"0\" " + (stock_checked.equals("0")? "checked":"") + " disabled=\"disabled\" />なし</td></tr>");
			out.println(" <tr><td></td><td>備考</td><td><textarea name=\"remarks\" cols=\"40\" rows=\"4\" disabled=\"disabled\">" + request.getParameter(params.get(6)) + "</textarea></td></tr>");
			out.println(" <tr><td></td><td height=\"30\"></td><td></td></tr>");
			out.println(" <tr><td></td><td></td><td align=\"right\">");
			out.println(" <input type=\"submit\" value=\"キャンセル\" />");
			out.println(" </table>");
			out.println(" </form>");
			out.println("</body>");
			out.println("</html>");
		}else {
			out.println(validator.getErrors());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
}