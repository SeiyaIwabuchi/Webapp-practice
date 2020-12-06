<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.BookBean" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import = "java.sql.*" %>
<%
BookBean bookInfo = (BookBean)session.getAttribute("bookInfo");
if(bookInfo == null) bookInfo = new BookBean();
String errors = (String)session.getAttribute("errors");
String[] checkbox_checked = {"","","","",""};
if(bookInfo.getGenreList() != null){
	for(String s : bookInfo.getGenreList().toArray(new String[bookInfo.getGenreList().size()])){
		checkbox_checked[Integer.parseInt(s)] = "checked";
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍登録画面</title>
</head>
<body>
	<h2>■書籍在庫管理システム</h2>
	<h2><%=errors==null?"":errors %></h2>
	<h3>【書籍登録画面】</h3>
	<form action="<%=request.getContextPath()%>/getresult" method="post">
		<table>
			<tr>
				<td></td>
				<td>タイトル</td>
				<td><input type="text" name="title"  value="<%=bookInfo.getTitle()==null?"":bookInfo.getTitle()%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td>著者</td>
				<td><input type="text" name="writer"   value="<%=bookInfo.getWritter()==null?"":bookInfo.getWritter() %>"/></td>
			</tr>
			<tr>
				<td></td>
				<td>出版社</td>
				<td><input type="text" name="publisher"   value="<%=bookInfo.getPublisher()==null?"":bookInfo.getPublisher()%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td>価格</td>
				<td><input type="text" name="price"   value="<%=bookInfo.getPrice()==null?"":bookInfo.getPrice()%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td>ジャンル</td>
				<td><input type="checkbox" name="genre" value="0" <%=checkbox_checked[0] %>/>文芸 
				<input	type="checkbox" name="genre" value="1"  		<%=checkbox_checked[1] %>/>実用
				<input type="checkbox" name="genre"  value="2"  		<%=checkbox_checked[2] %> />ビジネス 
				<input type="checkbox" name="genre" 	value="3"   	<%=checkbox_checked[3] %>/>教養 
				<input type="checkbox" name="genre" value="4"   		<%=checkbox_checked[4] %>/>趣味
				</td>
			</tr>
			<tr>
				<td></td>
				<td>在庫</td>
				<td><input type="radio" name="stock" value="1" <%=bookInfo.isStock()?"checked":"" %> />あり <input
					type="radio" name="stock" value="0"  <%=!bookInfo.isStock()?"checked":"" %>/>なし</td>
			</tr>
			<tr>
				<td></td>
				<td>備考</td>
				<td><textarea name="remarks" cols="40" rows="4"><%=bookInfo.getRemarks()==null?"":bookInfo.getRemarks()%></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td height="30"></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td align="right"><input type="submit" value="登録" /></td>
			</tr>
		</table>
	</form>
</body>
</html>