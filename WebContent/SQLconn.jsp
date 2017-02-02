<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://localhost:8889/client" user="root" password="root" 
	var="client" scope="page"/> 
<c:if test="${pageContext.request.method == 'POST'}">
<sql:update sql="insert into info (id,name,email,birthday,tel) values (?,?,?,?,?)" dataSource="${client}">
<sql:param value="${id }" />
<sql:param value="${name }" />
<sql:param value="${email }" />
<sql:param value="${param.years}-${param.months}-${param.days}"/>
<sql:param value="${param.tel }"/>
</sql:update>
<h1>恭喜註冊成功，3秒後轉至主畫面</h1>
</c:if> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w.ww.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="3;url=index.html">
</head>
<body>
</body>
</html>