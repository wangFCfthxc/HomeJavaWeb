<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>註  冊  會  員</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!----------------------  FBlogin/phone.js ---------------------->
<script type="text/javascript" src="js/FBlogin.js"></script>


</head>
<body>
<div id="sp">
<fb:login-button scope="public_profile,email" onlogin="checkLoginState()"
   data-max-rows="1" data-size="large" data-show-faces="false" 
   data-auto-logout-link="true" >
</fb:login-button><div id="status" ></div>
</div>
</body>
</html>