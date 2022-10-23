<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>teacher updated</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/updateddata.css">
</head>
<body>

	<canvas id="c"> </canvas>

	<div>
		<h1>New teacher data</h1>
		<p>teacher ${teacher.firstname}</p>
		<p>teacher ${teacher.lastname}</p>
	</div>

	<div>
		<a href="${pageContext.request.contextPath}/jsps/menu.jsp">Go back</a>
	</div>
	<script src="${pageContext.request.contextPath}/static/js/script.js"></script>
</body>
</html>