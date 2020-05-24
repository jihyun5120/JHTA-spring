<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel='stylesheet' type='text/css' href='./css/main.css'/>
<link rel='stylesheet' type='text/css' href='./css/board.css'/>
<link rel='stylesheet' type='text/css' href='./css/member.css'/>
<script src="./lib/jquery-3.4.1.js"></script>
<script src="./js/board.js"></script>
<script src="./js/member.js"></script>
</head>
<body>
<div id="page">
	<%@include file="header.jsp"%>
	
	<div id="main"></div>
	
	<%@include file="footer.jsp"%>
</div>
<script>brd.init();</script>
</body>
</html>

