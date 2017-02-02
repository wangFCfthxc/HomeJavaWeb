<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://localhost:8889/client" user="root" password="root" 
	var="client" scope="page"/> 
<c:set var="id" value="${param.id }" scope="session"/>
<c:set var="name" value="${param.name }" scope="session"/>
<c:set var="email" value="${param.email }" scope="session"/>

	<sql:query var="result" dataSource="${client }">
		select id from info
	</sql:query>

<c:if	test="${pageContext.request.method == 'POST' }">
	<c:forEach items="${result.rows }" var="clientID">
		<c:if test="${param.id == clientID.id}">
			<c:redirect url="SQLconn.jsp"/>
		</c:if>
	</c:forEach>
	<c:redirect url="form.html"/>
</c:if>