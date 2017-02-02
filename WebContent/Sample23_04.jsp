<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String tmp = request.getParameter("cars");
String carname = new String(tmp.getBytes("ISO-8859-1"), "utf-8");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panda Big Company</title>
</head>
<body>
<center>
<h2><%= carname %></h2>
感謝您購買本公司的<%= carname %><br>
<jsp:include page="company.html" flush="true" />	<%--flush="true" 資料多時先在伺服端緩衝  緩衝完再送至用戶端 避免用戶端先收到不完整資料 --%>
</center>
</body>
</html>