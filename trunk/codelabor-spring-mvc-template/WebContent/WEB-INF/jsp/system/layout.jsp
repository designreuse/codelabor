<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><tiles:getAsString name="title"/></title>
		<style type="text/css" media="all">
	  		@import url(<c:url value="/css/maven-base.css"/>);
	  		@import url(<c:url value="/css/maven-theme.css"/>);
	  		@import url(<c:url value="/css/site.css"/>);
		</style>
		<link rel="stylesheet" href="/css/print.css" type="text/css" media="print" />
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	</head>
	<body class="composite">
		<tiles:insertAttribute name="header"/>
		<div id="leftColumn">
			<div id="navcolumn">
				<tiles:insertAttribute name="menu"/>
			</div>
		</div>
		<div id="bodyColumn">
			<div id="contentBox">
				<div class="section">
					<tiles:insertAttribute name="body"/>
				</div>
		  	</div>
		</div>
		<div class="clear"><hr/></div>
		<div id="footer">
			<tiles:insertAttribute name="footer"/>
		</div>
	</body>
</html>
