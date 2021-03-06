<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dataClasses.BookInformation" %>
<%
	BookInformation bookInfo = (BookInformation)request.getAttribute("bookInfo");
	if(bookInfo == null) bookInfo = new BookInformation();
	String errors = (String)request.getAttribute("errors");
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
	<h3>【書籍登録確認画面】</h3>
	<form action="<%=request.getContextPath()%>/getresult" method="post">
		<table>
			<tr>
				<td></td>
				<td>タイトル</td>
				<td><input type="text" name="title"  disabled="disabled" value="<%=bookInfo.getTitle()%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td>著者</td>
				<td><input type="text" name="writer"  disabled="disabled" value="<%=bookInfo.getWriter()%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td>出版社</td>
				<td><input type="text" name="publisher"  disabled="disabled" value="<%=bookInfo.getPublisher()%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td>価格</td>
				<td><input type="text" name="price"  disabled="disabled" value="<%=bookInfo.getPrice()%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td>ジャンル</td>
				<td>
					<input type="checkbox" name="genre" value="0"  <%=bookInfo.getGenre()[0]?"checked":"" %> disabled="disabled"/>文芸 
					<input	type="checkbox" name="genre" value="1" <%=bookInfo.getGenre()[1]?"checked":"" %>  disabled="disabled"/>実用 
					<input type="checkbox" name="genre" value="2" <%=bookInfo.getGenre()[2]?"checked":"" %>  disabled="disabled"/>ビジネス 
					<input type="checkbox" name="genre"  value="3" <%=bookInfo.getGenre()[3]?"checked":"" %>  disabled="disabled"/>教養 
					<input type="checkbox" name="genre" value="4" <%=bookInfo.getGenre()[4]?"checked":"" %>  disabled="disabled"/>趣味
				</td>
			</tr>
			<tr>
				<td></td>
				<td>在庫</td>
				<td>
				<input type="radio" name="stock" value="1" <%=bookInfo.isStock()?"checked":"" %> disabled="disabled"/>あり
				 <input type="radio" name="stock" value="0"  <%=bookInfo.isStock()?"":"checked" %> disabled="disabled"/>なし
				 </td>
			</tr>
			<tr>
				<td></td>
				<td>備考</td>
				<td><textarea name="remarks" cols="40" rows="4"  disabled="disabled"><%=bookInfo.getRemarks() %></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td height="30"></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td align="right"><!--<input type="submit" value="登録" />--></td>
			</tr>
		</table>
	</form>
</body>
</html>