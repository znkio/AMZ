<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html lang="el">
<head>
	<title><decorator:title /></title>
	<meta charset="utf-8">
	<meta name="description" content="">
	<meta name="author" content="AMZ">

	
	<%@ include file="inc/includes.jsp" %>
		
	<decorator:head />	
</head>

<body>
	<%@ include file="inc/header.jsp" %>
	<div class="container">		
		<decorator:body />
	</div>
	<%@ include file="inc/footer.jsp" %>
</body>
</html>
