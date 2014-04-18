<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="/WEB-INF/jspf/top.jspf" %>
<!DOCTYPE html>
<html>
<head>
	<title><spring:message code="title.error" /></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link type="text/css" rel="stylesheet" href="${contextPath}/css/default.css" />
	<link type="text/css" rel="stylesheet" href="${contextPath}/css/layout.css" />
	<script type="text/javascript" src="${contextPath}/js/common/common.js"></script>
</head>
<body>
	<section id="error">
		<div class="authErrorArea">
			<div class="errorImg">
				<img src="${contextPath}/images/icon/icon_dontclassreg.png" alt="error">
			</div>
			<div>
				<h1>데이터를 조회할 수 없습니다.</h1>
				<p>
					자세한 문의사항은 관리자에게 연락하시기 바랍니다.
				</p>
				<ul class="clfix">
					<li><spring:message code="label.webmaster.phoneNumber" /> : <spring:eval
							expression="@systemProperties.getProperty('webmaster.phoneNumber')" /></li>
					<li><spring:message code="label.webmaster.email" />: <spring:eval
							expression="@systemProperties.getProperty('webmaster.email')" /></li>
				</ul>
			</div>
		</div>
	</section>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>