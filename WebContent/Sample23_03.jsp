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
		<%
			if (carname.length() != 0) {
		%>
		<h2><%=carname%></h2>
		感謝您購買本公司的<%=carname%><br>
		<%
			} else {
		%>
		<h2>錯誤</h2>
		請輸入名稱<br />
		<%
			}
		%>
	</center>
</body>
</html>