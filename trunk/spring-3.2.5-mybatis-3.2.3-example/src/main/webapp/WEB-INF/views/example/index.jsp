<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Example</title>
</head>
<body>
<h1>Example</h1>
<hr/>
<ul>
	<li><a href="${pageContext.servletContext.contextPath}/images/slf4j.jpg">resources example (/images)</a></li>
	<li><a href="${pageContext.servletContext.contextPath}/themes/maven/css/screen.css">resources example (/themes)</a></li>
	
	<li><a href="${pageContext.servletContext.contextPath}/example/emp/listEmp">emp example</a></li>
</ul>
</body>
</html>