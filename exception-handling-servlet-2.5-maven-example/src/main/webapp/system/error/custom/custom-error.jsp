<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Custom Error</title>
</head>
<body>
	<h1>Custom Error</h1>
	<hr/>
	
	<h2>Error Data</h2>
	<table>
		<tr><th>name</th><th>value</th></tr>
		<tr><td>errorData</td><td>${pageContext.errorData}</td></tr>
		<tr><td>requestURI</td><td>${pageContext.errorData.requestURI}</td></tr>
		<tr><td>servletName</td><td>${pageContext.errorData.servletName}</td></tr>
		<tr><td>statusCode</td><td>${pageContext.errorData.statusCode}</td></tr>
	</table>
	
</body>
</html>