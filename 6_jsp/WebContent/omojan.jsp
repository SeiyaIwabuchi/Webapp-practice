<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="omojan.Omojan" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>omojan.jsp</title>
</head>
<body bgcolor="gray">
<%
	Omojan omojan = new Omojan();
	out.println(omojan.getWord());
%>
</body>
</html>